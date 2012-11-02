register './lib/*.jar';                                                                                      
register './dist/lib/commoncrawl-examples-1.0.1.jar';
a = LOAD 'test.arc.gz' USING org.commoncrawl.pig.ArcLoader() as (date, length, type, statuscode, ipaddress, url, html, payload);
words = foreach a generate flatten(statuscode) as codes; 
grpd = group words by codes;
cntd = foreach grpd generate group, COUNT(words);
dump cntd;
