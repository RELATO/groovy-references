package groovy.learning

import groovy.learning.domain.Message

/**
 * This class shows how to create and use List in Groovy
 * By default, Groovy use LinkedArrayList
 *
 */
class GroovyList {

	static main(args) {

		// list init and iterating over it
		def myCityList = ['Madrid', 'Berlin', 'Paris']
		myCityList.each { println it }

		def myCarList = [
			new Message(type:'SMS', content: 'Hello!'),
			new Message(type:'SMS', content: 'BYE!'),
		]
		
		println '-----> printing myCarList List'
		myCarList.each{ println "${it.type} - ${it.content}" }

		println '-----> printing myCarList List using closure as argument'
		// closure as argument
		def myPrintingClosure = {println it.content}
		myCarList.each(myPrintingClosure)

		def myCountryList = ['USA']
		// adding elements
		myCountryList.add('Germany')
		myCountryList.add 'France'
		myCountryList << 'Japan'
		myCountryList.add(4, 'Sweden')
		myCountryList += 'Turkey'

		println '-----> printing myCountryList after adding elements'
		myCountryList.each{ println it }

		// removing elements from List
		myCountryList-= 'Turkey'
		myCountryList.remove 0
		myCountryList.remove 'Sweden'

		println '-----> printing myCountryList after removing elements'
		myCountryList.each{ println it }
	}

}