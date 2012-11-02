register commoncrawl-examples/lib/*.jar;                                                                                      
register commoncrawl-examples/dist/lib/commoncrawl-examples-1.0.1.jar
a = LOAD 'commoncrawl/Common_Crawl_trial.arc.gz' USING org.commoncrawl.pig.ArcLoader() as (date, length, type, statuscode, ipaddress, url, html, payload);
words = foreach a generate flatten(statuscode) as codes;
grpd = group words by codes;
cntd = foreach grpd generate group, COUNT(words);
cntd10 = LIMIT cntd 10;
dump cntd10;
