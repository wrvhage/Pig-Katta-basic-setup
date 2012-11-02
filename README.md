To build a Katta Lucene index using Pig, run the create_katta_index.pig script.

You can run it locally using the supplied Pig as follows:
pig-0.10.0-lucene/bin/pig -x local create_katta_index.pig

You can run it on Hadoop by loading the pig, hadoop, and java modules and the
following command (NB! you have to set the path to the location of Wikipedia on HDFS in the Pig script,
also, the index will end up on HDFS, not in your regular file system):
pig create_katta_index.pig

You can set up a baseline Katta system locally as follows:
cd katta/modules/katta-core
bin/start-all.sh
bin/katta addIndex <index_name> <path_to_index> <replication_factor>
bin/katta search <index_name> <query> <#results>

You can stop the Katta like this:
bin/stop-all.sh

You can set up a baseline Katta system on the DAS4 cluster as follows:
cd katta/modules/katta-core
bin/launch-katta-cluster <#nodes>
bin/katta addIndex <index_name> hdfs://<path_to_index> <replication_factor>
bin/katta search <index_name> <query> <#results>

You can stop the Katta like this:
bin/stop-katta-cluster

--

You can adapt the entire information retrieval process by changing the following pieces of code:
Preprocessing (e.g. implement PageRank approximation): 
create_katta_index.pig

Tokenization etc: 
pig-0.10.0-lucene/contrib/piggybank/java/src/main/java/org/apache/pig/piggybank/storage/LuceneStorage.java

Query preprocessingi (e.g. expansion, fuzzy matching):
katta/modules/katta-core/src/main/java/net/sf/katta/Katta.java (around line 827)

Weighting scheme:
Implement your own Lucene Similarity class and change the LuceneServer in Katta at
katta/modules/katta-core/src/main/java/net/sf/katta/lib/lucene/LuceneServer.java (around line 438)
Find more information about this class at
http://lucene.apache.org/core/old_versioned_docs/versions/3_5_0/api/core/org/apache/lucene/search/Similarity.html
Or, adapt Lucene altogether and supply a different lucene-core-3.5.0.jar file at
katta/modules/katta-core/lib/compile/

Query field weighting etc (e.g. incorporate PageRank effect):
Just adapt the query, details can be found on the Lucene web page.
http://lucene.apache.org/core/old_versioned_docs/versions/3_5_0/queryparsersyntax.html


