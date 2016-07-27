import java.util.regex.Pattern


samples = [
	'aa,bb,cc',
	'asdf.fyfyf.owososos',
]

//
//	groovy-ish
//
samples.each {
	println "---------------------------------"
	println "v1.sample:"+it
	pattern = ~/(bb|cc)/
	println 'matches? '+pattern.matcher(it).matches()
	println 'find? '+pattern.matcher(it).find()
	println 'findAll? '+pattern.matcher(it).findAll()
}


//
//	old-school
//
def exp = Pattern.compile("(bb|cc)")
samples.each {
	println "---------------------------------"
	println "v2.sample:"+it
	def matcher = exp.matcher(it)
	while(matcher.find()) {
		println matcher
	}
}
