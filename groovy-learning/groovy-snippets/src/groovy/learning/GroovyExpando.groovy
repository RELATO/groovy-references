package groovy.learning

/**
 * This class shows the use of Expando. Avoid creating domain classes if they have one time use. 
 *
 */
class GroovyExpando {

	static main(args) {

		def user = new Expando();
		user.fName = 'Dave'
		user.age = '30'
		user.location = 'Berlin'

		user.greet = {greetMsg ->
			println "${greetMsg} ${fName}! You are ${age} years old and live in ${location}."
		}
		
		user.greetHim = {greetMsg, language ->
			println "${language} - ${greetMsg} ${fName}! You are ${age} years old and live in ${location}."
		}
		
		user.greet('Guten Tag')
		user.greetHim('Guten Tag', 'German')
	}
}
