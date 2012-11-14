#!/bin/env ruby

require 'uri'

# If you want to preprocess a query, change it here.
SEARCH_COMMAND = Proc.new { |query, index, max| "bin/katta search '#{index}' '#{query}' #{max}" }
INPUT_FILE = "testbed.csv"

def process_file(cmd,filename)
	aps = []
	f = File.foreach(filename) do |line|
		if line.strip != '' and line[0] != 42 then
			parts = line.strip.split(',')
			group = parts.shift
			query = parts.shift
			puts "Query for group #{group}: #{query}"
			relevant_uris = parts.map { |uri| URI.escape(uri,"():").gsub('http%3A//','http://') }
			aps << test_query(cmd,query,'*',relevant_uris)
		end
	end
	map = (aps.reduce(0.0) { |sum,x| sum + x.to_f }) / aps.size.to_f
	puts "For #{aps.size} queries:"
	puts "MAP:          #{map}"
end

def test_query(cmd, query, index, relevant_uris)
	max = (relevant_uris.size > 10) ? relevant_uris.size * 2 : 20
	cmd = cmd.call query, index, max
	puts "Performing query '#{query}'... (#{cmd})"
	puts "Expecting results: #{relevant_uris.inspect}"
	results = %x( #{cmd} )
	rel = 0
	irrel = 0
	puts "Query results:"
	ap = 0.0
	results.split("\n").reject {|l| not /^\|.*\d+.*/ =~ l }.map {|l| l.sub(/^\|.*\|.*\|.*\|.*\| ([^ ]*)[ ]*\|.*\|.*$/,"\\1") }.each do |result|
		if relevant_uris.include?(result) then
			puts "  #{rel+irrel+1}. Relevant:   #{result}"
			rel = rel + 1
			ap = ap + rel.to_f/(rel+irrel).to_f
		else
			puts "  #{rel+irrel+1}. Irrelevant: #{result}"
			irrel = irrel + 1
		end
	end
	ap = ap / relevant_uris.size.to_f
	p = (rel.to_f/(rel+irrel).to_f)
	r = rel.to_f/relevant_uris.size.to_f
	puts "\nSummary:"
	puts "  Relevant results:   #{rel}"
	puts "  Irrelevant results: #{irrel}"
	puts "  Precision:          #{p}"
	puts "  Recall:             #{r}"
	puts "  F1:                 #{(2*p*r)/(p+r)}"
	puts "  AP:                 #{ap}"
	puts " "
	ap
end
puts INPUT_FILE
process_file SEARCH_COMMAND, INPUT_FILE
