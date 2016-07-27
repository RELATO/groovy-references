package groovy.learning

import groovy.json.StringEscapeUtils;

/**
 * This class shows how to use MetaClass property of a class to add behavior to it at runtime
 * - delegate holds reference of the object on which MOP is being invoked
 * - MOP - Meta Objest Protocol allows you to add properties and methods to existing classes - even to final classes
 * - each class in Groovy has a property groovy.lang.MetaClass
 * - 
 */
class GroovyMetaClass {

	static main(args) {
		
		String.metaClass.toStringTest = {
			 "metaClass- ${delegate.toString()}"
		}
		
		String.metaClass.toStringTest = {str ->
			"metaClass - ${str} - ${delegate.toString()}"
	   }
		
		def myString = "test"
		
		println '---> invokind MOP without param'
		println myString.toStringTest()
		
		println '---> invokind MOP with param'
		println myString.toStringTest("hello")
	}

}
