#!/usr/bin/python

myfile = open("sorted-names.txt",'r')
wfile = open("quotenames.txt",'w')
for line in myfile.readlines():
	wfile.writeline('"%s"' % str(line))
