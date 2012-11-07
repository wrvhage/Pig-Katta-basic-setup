-- Register user-defined functions for loading Wikipedia and creating a Katta Lucene index
register 'pignlproc-0.1.0-SNAPSHOT.jar'
register 'piggybank.jar'

-- Load input from $INPUT - this can be a local path or a HDFS URI
parsed = LOAD '$INPUT' USING pignlproc.storage.ParsingWikipediaLoader('en') AS (title, uri, text, redirect, links, headers, paragraphs);

-- select the relevant fields
out = FOREACH parsed GENERATE uri, title, text;

-- Build an index with the field names 'uri', 'title' and 'text', the field 'uri' is obligatory for our Katta setup
STORE out INTO '$OUTPUT' USING org.apache.pig.piggybank.storage.LuceneStorage('uri title text');

