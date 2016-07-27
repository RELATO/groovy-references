package collections

class Collections extends GroovyTestCase {

    void testList() {

        def list = []
        list << "hello"
        list << "world"

        println list
        println list.reverse()
    }

    void testListStarDot() {

        def list = ["a", "qwerty", "hello", "123", ""]

        println list*.length()
        println list*.length()*.multiply(2)
    }

    void testMap() {

        def map = [:]
        map.name = "John"
        map.age = 20
        map.country = "Russia"
        map.job = "carpenter"

        println map
        println map + [birthday: new Date() - 20 * 366]
    }

    void testRange() {

        def range = 1..10

        for(n in range) {
            println n
        }
    }

    void testRangeLetters() {

        def range2 = 'a'..'f'
        for(n in range2) {
            println n
        }
    }

    void testRangeWords() {
        def range3 = 'ab'..'cd'
        for(n in range3) {
            println n
        }
    }
}
