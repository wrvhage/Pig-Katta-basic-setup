package org.apache.pig.piggybank.storage;

import org.apache.hadoop.fs.Path;
import org.apache.lucene.index.IndexWriter;
import java.io.File;

public class LuceneStorageConf
{
    private LuceneStorageConf()
    {
        // no code req'd
    }

    public static LuceneStorageConf getInstance() {
      if (ref == null)
          // it's ok, we can call this constructor
          ref = new LuceneStorageConf();
      return ref;
    }

    private static LuceneStorageConf ref;

    private IndexWriter i;
    private File p;
    private String d;

    public void setWriter(IndexWriter i) {
      this.i = i;
    }

    public IndexWriter getWriter() {
      return i;
    }

    public void setShard(File p) {
      this.p = p;
    }

    public File getShard() {
      return p;
    }

    public void setDest(String d) {
      this.d = d;
    }

    public String getDest() {
      return d;
    } 
}