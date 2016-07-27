package groovy.learning

import groovy.learning.domain.Message

/**
 * This class shows how to make use of Groovy operators
 * - Elvis operator ?:
 * - Safe navigation operator ?.
 * - Spread Operator *.
 *
 */
class GroovyOperators {

	static main(args) {

		// ELVIS operator ?:
		Message message = new Message(type:'PLAIN TEXT')
		String messageContent = message.content ?: 'undefined'
		println "elvis op / messageContent: ${messageContent}"

		// Safe navigation operator ?.
		Message message1 = null
		String messageContent1 = message1?.content
		println "safe navigation op / messageContent1: ${messageContent1}"
		
		// Spread operator *.
		def myList = [new Message(type:'SMS',content:'Hi'), new Message(type:'SMS',content:'Bye')]
		println 'printing list using spread operator'
		myList*.printMessage()
	}
}
