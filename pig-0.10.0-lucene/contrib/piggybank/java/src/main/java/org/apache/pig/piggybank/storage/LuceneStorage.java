package org.apache.pig.piggybank.storage;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.OutputCommitter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.pig.data.DataType;

import java.util.*;
import java.io.File;

import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.OutputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.log4j.Logger;
import org.apache.pig.LoadPushDown;
import org.apache.pig.PigException;
import org.apache.pig.StoreFuncInterface;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.PigSplit;
import org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.PigTextInputFormat;
import org.apache.pig.builtin.PigStorage;
import org.apache.pig.bzip2r.Bzip2TextInputFormat;
import org.apache.pig.data.DataByteArray;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
import org.apache.pig.impl.logicalLayer.FrontendException;
import org.apache.pig.impl.util.ObjectSerializer;
import org.apache.pig.impl.util.StorageUtil;
import org.apache.pig.impl.util.UDFContext;
import org.apache.pig.StoreFuncInterface;
import org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.PigHadoopLogger;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriter.MaxFieldLength;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import org.apache.pig.*;

public class LuceneStorage implements StoreFuncInterface {
	
	private final Log log = LogFactory.getLog(getClass());
	private Configuration _conf;
	private String finalDestination;
	private Analyzer analyzer;
	public IndexWriter indexWriter;
	private File shardFile;
	private Job _job;
	private List<String> fieldNames;

	public LuceneStorage(String f) {
		fieldNames = parseFieldList(f,",",true);
		log.info("Using field names " + fieldNames.toString());
	}

	@Override
	public void putNext(Tuple tuple) throws IOException {
		Document doc = new Document();
		int size = tuple.size();
		for (int i = 0; i < size; i++) {
			Object field = tuple.get(i);
			String fieldName = fieldNames.get(i);
			Field toAdd = new Field(fieldName, field.toString(), Store.YES, Index.ANALYZED);
			doc.add(toAdd);
			// log.info("Adding field " + fieldName + " to doc " + doc + ": " + field.toString() );
		}
		indexWriter.addDocument(doc);
	}

    private List<String> parseFieldList(String columnList,
                                             String delimiter,
                                             boolean ignoreWhitespace) {
        List<String> columnInfo = new ArrayList<String>();

        // Default behavior is to allow combinations of spaces and delimiter
        // which defaults to a comma. Setting to not ignore whitespace will
        // include the whitespace in the columns names
        String[] colNames = columnList.split(delimiter);
        if(ignoreWhitespace) {
            List<String> columns = new ArrayList<String>();

            for (String colName : colNames) {
                String[] subColNames = colName.split(" ");

                for (String subColName : subColNames) {
                    subColName = subColName.trim();
                    if (subColName.length() > 0) columns.add(subColName);
                }
            }

            colNames = columns.toArray(new String[columns.size()]);
        }

        for (String colName : colNames) {
            columnInfo.add(colName);
        }

        return columnInfo;
    }


	@Override
	public void setStoreLocation(String location, Job job) throws IOException {
		// determine some location
		log.info("Final Destination: " + location);
		finalDestination = location;
		_conf = job.getConfiguration();
		_job = job;
	}

    public void cleanupOnFailure(String location, Job job) 
    throws IOException {        
        Path path = new Path(location);
        FileSystem fs = path.getFileSystem(job.getConfiguration());
        if(fs.exists(path)){
            fs.delete(path, true);
        }    
    }

    @Override
    public void checkSchema(ResourceSchema s) throws IOException {
        // default implementation is a no-op
    }

	@Override
	public String relToAbsPathForStoreLocation(String location, Path curDir) 
	throws IOException {
		return LoadFunc.getAbsolutePath(location, curDir);
	}   
	@SuppressWarnings("unchecked")
	@Override
	public void prepareToWrite(RecordWriter writer) throws IOException {	
		String tmp = _conf.get("hadoop.tmp.dir");
		long millis = System.currentTimeMillis();
		String shardName = "" + millis + "-" + new Random().nextInt();
		shardFile = new File(tmp, shardName);
		log.info("Writing to shard " + shardFile);

		analyzer = new StandardAnalyzer(Version.LUCENE_CURRENT);
		indexWriter = new IndexWriter(FSDirectory.open(shardFile), analyzer, MaxFieldLength.UNLIMITED);
		indexWriter.setMergeFactor(100000);

		LuceneStorageConf.getInstance().setWriter(indexWriter);
		LuceneStorageConf.getInstance().setShard(shardFile);
		LuceneStorageConf.getInstance().setDest(finalDestination);
	}

    @Override
    public void setStoreFuncUDFContextSignature(String signature) {
        // default implementation is a no-op
    }

	@SuppressWarnings("unchecked")
	@Override
	public OutputFormat getOutputFormat() throws IOException {
	  return new LuceneOutputFormat(indexWriter);
	}

	class LuceneOutputFormat extends OutputFormat<NullWritable, NullWritable> {
		IndexWriter indexWriter;
		LuceneOutputFormat(IndexWriter i) {
			indexWriter = i;
		}

	  @Override
	  public void checkOutputSpecs(JobContext context) throws IOException,
	      InterruptedException {
	    // IGNORE
	  }

	  @Override
	  public OutputCommitter getOutputCommitter(TaskAttemptContext context)
	      throws IOException, InterruptedException {

	    return new OutputCommitter() {

	      @Override
	      public void abortTask(TaskAttemptContext context) throws IOException {

	      }

	      @Override
	      public void commitTask(TaskAttemptContext context) throws IOException {
	      	indexWriter = LuceneStorageConf.getInstance().getWriter();
	      	shardFile = LuceneStorageConf.getInstance().getShard();
	      	finalDestination = LuceneStorageConf.getInstance().getDest();
	      	//throw new RuntimeException("Cleaning up");
	      	log.info("Optimizing index...");		
	      	indexWriter.optimize();
	      	indexWriter.close();
	      	FileSystem fileSystem = FileSystem.get(context.getConfiguration());

	      	long millis = System.currentTimeMillis();
	      	String shardName = "" + millis + "-" + new Random().nextInt();

	      	log.info("Copying index shard to final destination...");
	      	Path destination = new Path(finalDestination + "/" + shardName);
	      	fileSystem.copyFromLocalFile(new Path(shardFile.getAbsolutePath()), destination);
	      	log.info("Deleting temporary files...");
	      	FileUtil.fullyDelete(shardFile);
	      }

	      @Override
	      public boolean needsTaskCommit(TaskAttemptContext context)
	          throws IOException {
	        return true;
	      }

	      @Override
	      public void cleanupJob(JobContext context) throws IOException {
	        // IGNORE

	      }

	      @Override
	      public void setupJob(JobContext context) throws IOException {
	        // IGNORE
	      }

	      @Override
	      public void setupTask(TaskAttemptContext context) throws IOException {
	        // IGNORE
	      }
	    };
	  }

	  @Override
	  public RecordWriter<NullWritable, NullWritable> getRecordWriter(
	      TaskAttemptContext context) throws IOException, InterruptedException {
	    // We don't use a record writer to write to database
	  	return new RecordWriter<NullWritable, NullWritable>() {
	  		   	  @Override
	  		   	  public void close(TaskAttemptContext context) {
	  		   		  // Noop
	  		    	  }
	  		    	  @Override
	  		    	  public void write(NullWritable k, NullWritable v) {
	  		    		  // Noop
	  		    	  }
	  		      };
	  }

	}

}
