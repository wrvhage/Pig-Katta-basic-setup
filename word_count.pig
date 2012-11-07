input_lines = LOAD '$INPUT' USING PigStorage('\n') AS (line:chararray);

-- remove empty lines
non_empty = FILTER input_lines BY line MATCHES '.*\\w+.*';

trimmed = FOREACH non_empty GENERATE REPLACE(line,'^\\W+','') AS line; 
trimmed2 = FOREACH trimmed GENERATE REPLACE(line,'\\W+$','') AS line; 
 
-- Extract words from each lowercased line and 
-- then flatten the bag to get one tuple on each row
tuples = FOREACH trimmed2 GENERATE FLATTEN(STRSPLIT(LOWER(TRIM(line)),'\\W+'));

-- Put each word in its own tuple, put each tuple on a separate row
words = FOREACH tuples GENERATE FLATTEN(TOBAG(*)) AS word;

-- create a group for each word
word_groups = GROUP words BY word;
 
-- count the entries in each group
word_count = FOREACH word_groups GENERATE COUNT(words) AS count, group AS word;
 
-- order the records by count
ordered_word_count = ORDER word_count BY count DESC;
STORE ordered_word_count INTO '$OUTPUT';

