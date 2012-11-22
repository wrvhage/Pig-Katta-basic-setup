# Basic starting setup for the Information Retrieval course at the VU University Amsterdam
This repository contains everything needed to set up a local or distributed search engine over the Engish Wikipedia using Hadoop, Pig, Lucene and Katta. Tools for CommonCrawl are also included.
If you want to download the CommonCrawl ARC file loader submodule you have to invoke git like this:

    git clone --recursive https://github.com/wrvhage/Pig-Katta-basic-setup.git

## Build a basic index and serve it using Katta

To build a Katta Lucene index using Pig, run the *create_katta_index.pig* script.

You can run it locally using the supplied Pig installation as follows:

    pig-0.10.0-lucene/bin/pig -x local -p INPUT=wikipedia -p OUTPUT=wiki-index create_katta_index.pig

You can run it on the Hadoop cluster by loading the pig, hadoop, and java modules and issuing the
following command *(NB! The index will end up on HDFS, not in your regular file system)*:
    
    module load hadoop java pig
    pig -p INPUT='hdfs:/user/jehoekse/wikipedia/chunk-0200.xml' -p OUTPUT=wiki-index create_katta_index.pig

If you want to run CommonCrawl code on the DAS cluster, you have to use the module "java/jdk-1.6.0_27" instead of "java", because this will load java 1.6.0, which is required by the CommonCrawl code, instead of the default 1.7.0.

To set up a baseline Katta system locally, issue the following commands:

    cd katta/modules/katta-core
    bin/start-all.sh
    bin/katta addIndex <index_name> <path_to_index> <replication_factor>
    bin/katta search <index_name> <query> <#results>

You can stop the Katta system like this:

    bin/katta removeIndex <index_name>
    bin/stop-all.sh

You can set up a baseline Katta cluster on the DAS4 cluster and search it as follows:

    cd katta/modules/katta-core
    bin/launch-katta-cluster <#nodes>
    bin/katta addIndex <index_name> hdfs://<path_to_index> <replication_factor>
    bin/katta search <index_name> <query> <#results>

You can stop the Katta cluster like this:

    bin/katta removeIndex <index_name>
    bin/stop-katta-cluster

Make sure to undeploy (remove) your index on the Katta cluster before stopping it, otherwise it will remain using disk space. Also keep in mind the 15 minute execution limit of the DAS4 cluster.

## Example

The following example clones this repository, builds an index from the full wikipedia dump, starts a Katta cluster, deploys the generated index, and searches for the top 10 documents with the word 'banana'. It then undeploys the index and shuts down the katta cluster. *When running this, please subsitute the output and index paths to your own.*

    [jehoekse@fs0 ~]$ git clone https://github.com/wrvhage/Pig-Katta-basic-setup.git ir-setup
    [jehoekse@fs0 ~]$ cd ir-setup
    [jehoekse@fs0 ir-setup]$ module load hadoop java pig
    [jehoekse@fs0 ir-setup]$ pig -p INPUT='hdfs:/user/jehoekse/wikipedia/chunk-0200.xml' -p OUTPUT=wiki-index create_katta_index.pig    
    [jehoekse@fs0 ir-setup]$ cd katta/modules/katta-core
    [jehoekse@fs0 katta-core]$ bin/launch-katta-cluster 10
    [jehoekse@fs0 katta-core]$ bin/katta addIndex wiki hdfs://10.141.0.254:8115/user/jehoekse/wiki-index 1
    [jehoekse@fs0 katta-core]$ bin/katta search wiki 'text:banana' 10
    [jehoekse@fs0 katta-core]$ bin/katta removeIndex wiki
    [jehoekse@fs0 katta-core]$ bin/stop-katta-cluster

## Modifying the process

You can adapt the entire information retrieval process by changing the following pieces of code:
* Preprocessing (e.g. implement PageRank approximation): 
    * create_katta_index.pig

* Tokenization etc: 
    * pig-0.10.0-lucene/contrib/piggybank/java/src/main/java/org/apache/pig/piggybank/storage/LuceneStorage.java

* Query preprocessing (e.g. expansion, fuzzy matching):
    * katta/modules/katta-core/src/main/java/net/sf/katta/Katta.java (around line 827)

* Weighting scheme:
    * Implement your own Lucene Similarity class and change the LuceneServer in Katta at katta/modules/katta-core/src/main/java/net/sf/katta/lib/lucene/LuceneServer.java (around line 438). Find more information about this class at http://lucene.apache.org/core/old_versioned_docs/versions/3_5_0/api/core/org/apache/lucene/search/Similarity.html
    * Additionally, adapt Lucene altogether and supply a different lucene-core-3.5.0.jar file at katta/modules/katta-core/lib/compile/

* Query field weighting etc (e.g. incorporate PageRank effect):
    * Just adapt the query, details can be found on the Lucene web page. http://lucene.apache.org/core/old_versioned_docs/versions/3_5_0/queryparsersyntax.html


## Evaluation

In the *katta/modules/katta-core* directory you will find a file called *testbed.csv* containing a set of quries and relevant documents based on the assessments done in assignment 1 of the IR course. You can use this testbed to do benchmarking on the Wikipedia corpus.
You can run the testbed by calling:

    cd katta/modules/katta-core
    # launch a katta cluster and add your index
    ruby bin/testbed.rb
    # remove your index and stop your katta cluster

This will fire all the queries and calculate some performance metrics like Average Precision and F-measure over all queries to guide your development process. You may add to the testbed as you like.
The testbed sets of relevant documents currently do not include Wikipedia pages about Categories, Talk, or Files (e.g. images). You might want to filter these from your search results or index. This can be accomplished in Pig, or by rewriting the queries by appending

     AND NOT uri:*File* AND NOT uri:*Talk* AND NOT uri:*Category*

If you want to use your own wrapper around Katta, for example, to rewrite queries before firing them, you can change the testbed.rb Ruby script near the top of the script to call your wrapper.

