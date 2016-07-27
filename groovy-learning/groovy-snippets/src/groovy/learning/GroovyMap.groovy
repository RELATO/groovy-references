package groovy.learning

/**
 * This class shows how to create and use Map in Groovy
 * By default, Groovy use LinkedHashMap
 *
 */
class GroovyMap {

	static main(args) {

		def myGroovyMap = ['host':'tmp.test.com']
		myGroovyMap.put('port', '8080')
		myGroovyMap.put 'param', 'test'
		myGroovyMap.put 'param1', 'test1'

		myGroovyMap.remove 'param1'
		// closure + GString
		myGroovyMap.each{ println "map key: ${it.key} - value: ${it.value}" }
	}

}
