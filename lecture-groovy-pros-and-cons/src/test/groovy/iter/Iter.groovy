package iter

import etters.Person

class Iter extends GroovyTestCase {

    void testEach() {

        def people = [
                new Person("Гоша", 35),
                new Person("Петя", 38),
                new Person("Саша", 31),
                new Person("Валя", 37),
                new Person("Коля", 35),
                new Person("Маша", 31),
                new Person("Даша", 35),
        ]

        people.eachWithIndex { Person entry, int i ->

            entry.age = 20 + i
        }

        people.each {

            println it
        }
    }

    void testAggregate() {

        def people = [
                new Person("Гоша", 35),
                new Person("Петя", 38),
                new Person("Саша", 32),
                new Person("Валя", 37),
                new Person("Коля", 36),
                new Person("Маша", 31),
                new Person("Даша", 36),
        ]

        println people.every { it.age % 2 == 0 }
        println people.any { it.age % 2 == 0 }
        println people.count { it.age % 2 == 0 }
        println people.sum { (it.age % 2 == 0) ? it.age : 0 }
        println people.max { it.age }
        println people.min { it.name }

    }

    void testFind() {

        def people = [
                new Person("Гоша", 35),
                new Person("Петя", 38),
                new Person("Саша", 32),
                new Person("Валя", 37),
                new Person("Коля", 36),
                new Person("Маша", 31),
                new Person("Даша", 36),
        ]

        println people.find { it.name.startsWith("К") }
        println()
        println people.findAll { it.age > 35 || it.name.startsWith("М") }
        println()
        println people.collect { [name: it.name, age: it.age, random: Math.random()] }
        println()
        println people.collect { it.age }.sort().unique()

    }

}
