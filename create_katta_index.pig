-- Register user-defined functions for loading Wikipedia and creating a Katta Lucene index
register 'pignlproc-0.1.0-SNAPSHOT.jar'
register 'piggybank.jar'

-- Work locally on a single chunk of 100MB
parsed = LOAD './wikipedia' USING pignlproc.storage.ParsingWikipediaLoader('en') AS (title, uri, text, redirect, links, headers, paragraphs);

-- Work on HDFS on the complete Wikipedia dump
-- parsed = LOAD 'hdfs:/user/jehoekse/wikipedia' USING pignlproc.storage.ParsingWikipediaLoader('en') AS (title, uri, text, redirect, links, headers, paragraphs);

-- select the relevant fields
out = FOREACH parsed GENERATE uri, title, text;

-- Build an index with the field names 'uri', 'title' and 'text', the field 'uri' is obligatory for our Katta setup
STORE out INTO 'test' USING org.apache.pig.piggybank.storage.LuceneStorage('uri title text');

