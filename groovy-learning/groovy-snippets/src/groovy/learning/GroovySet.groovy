package groovy.learning

/**
 * This class shows how to create and use Set in Groovy
 * By default, Groovy use HashSet
 *
 */
class GroovySet {

	static main(args) {
		def mySet = ['C', 'Java'] as Set
		mySet.add 'Groovy'
		mySet += 'PHP'
		mySet << 'Perl'

		mySet.each { i -> println i }
	}
}
