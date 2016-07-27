package closure

import etters.Person

class Closures extends GroovyTestCase {

    void test1() {
        def square = { it * it }
        println square(5)
    }

    void test2() {
        println(
                [1, 2, 3, 4].collect { it + 1 }
        )
    }

    void test3() {
        def t = Thread.start {
            sleep(1000)
            println("I'm a new thread!")
        }

        println("test")
        t.join()
    }

    void test4() {

        def people = [
                new Person("Гоша", 35),
                new Person("Петя", 38),
                new Person("Саша", 31),
                new Person("Валя", 37),
                new Person("Коля", 35),
                new Person("Маша", 31),
                new Person("Даша", 35),
        ]

        println people.sort { Person a, Person b ->
            return a.age <=> b.age ?: b.name <=> a.name
        }
    }
}
