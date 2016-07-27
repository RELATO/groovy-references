//  unique list of values
def uniqueA= [
	[a:'a1',b:'b1'],
	[a:'a2',b:'b2'],
	[a:'a1',b:'b2'],
	[a:'a1',b:'b3'],
].collect{ it.a }.unique()

println "unique set of values for a: ${uniqueA}"

