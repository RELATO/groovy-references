package braces;

class Braces extends GroovyTestCase {

    void test1() {
        println ((("100" as int) + 1) as String) + "2"
    }

}
