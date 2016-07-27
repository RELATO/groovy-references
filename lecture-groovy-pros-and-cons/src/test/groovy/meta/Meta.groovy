package meta

import etters.Person
import groovy.time.TimeCategory

class Meta extends GroovyTestCase {
    void testInteger() {
        Integer.metaClass.getPeople = { ->
            def result = []
            for (int i = 0; i < delegate; i++) {
                result << new Person("Иван Иванов", (Math.random().trunc(2) * 100) as int)
            }
            return result
        }

        println 6.people
    }

    void testPerInstance() {
        def str = "hello"
        str.metaClass.test = { "test" }

        println str.test()
        println "qwerty".test()
    }

    void testInterface() {

        def i = 10
        def impl = [
                hasNext: {
                    i > 0
                },
                next   : {
                    i--
                },
        ]
        def iter = impl as Iterator

        for (Object num : iter) {
            println num
        }
    }

    void testCategory() {

        use(TimeCategory) {

            println new Date() + 1.year - 2.months

        }
    }

}
