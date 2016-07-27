/**
*
* ideas: http://www.kellyrob99.com/blog/2010/07/01/groovy-and-csv-how-to-get-your-data-out/
*
*/
def vals = [ [a:'a',b:'b',1:2,foo:'bar'],
             [a:'aa',b:'bb',1:22,foo:'BAS'],
	]
def delim='\t'
def theFile = new File('/tmp/test.csv')
theFile.delete()

keys = vals[0].keySet()	// use first row's keys as columns...

// 			write the keys as a header line
theFile << '#'
theFile << keys.join(delim)
theFile.append '\n'

// write each key value
vals.each { row ->
  keys.each {
	theFile.append row[it]
	theFile.append delim
  }
  theFile.append '\n'
}

