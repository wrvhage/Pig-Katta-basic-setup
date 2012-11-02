package org.commoncrawl.pig;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.http.HttpException;
import org.apache.pig.LoadFunc;
import org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.PigSplit;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
import org.commoncrawl.hadoop.mapred.ArcInputFormat;
import org.commoncrawl.hadoop.mapred.ArcRecord;

public class ArcLoader extends LoadFunc {

  private RecordReader<Text, ArcRecord> in;
  private TupleFactory mTupleFactory = TupleFactory.getInstance();

  @Override
  public InputFormat<Text, ArcRecord> getInputFormat() throws IOException {
    return new ArcInputFormat();
  }

  @Override
  public Tuple getNext() throws IOException {
    try {
      boolean notDone = in.nextKeyValue();
      if (!notDone) {
        return null;
      }
      ArcRecord value = in.getCurrentValue();
      Tuple t = mTupleFactory.newTuple(8);
      t.set(0, value.getArchiveDate().toString());
      t.set(1, value.getContentLength());
      t.set(2, value.getContentType());
      try {
        t.set(3, value.getHttpStatusCode());
      } catch(HttpException e) {
        t.set(3, -1);
      }
      t.set(4, value.getIpAddress());
      t.set(5, value.getURL());
      if (value.getParsedHTML() != null) {
        t.set(6, value.getParsedHTML().toString());
      } else {
        t.set(6, null);
      }
      t.set(7, value.getPayload());
      return t;
    } catch (InterruptedException e) {
      throw new IOException("Error getting input");
    }
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Override
  public void prepareToRead(RecordReader reader, PigSplit arg1)
      throws IOException {
    in = reader;
  }

  @Override
  public void setLocation(String location, Job job) throws IOException {
    FileInputFormat.setInputPaths(job, location);
  }

}
