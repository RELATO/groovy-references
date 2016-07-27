package closure

class Return extends GroovyTestCase {

    static boolean isPrime(def x) {
        if (x == 2) return true
        int limit = Math.sqrt(x) + 1
        (2..limit).each {
            if (x % it == 0) {
                return false
            }
        }
        true
    }

    void test1() {
        println(isPrime("4" as Double))
    }
}
