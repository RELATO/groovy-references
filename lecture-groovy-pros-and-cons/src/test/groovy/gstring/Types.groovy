package gstring

class Types extends GroovyTestCase {
    void test1() {
        def str1
        String str2
        def name = "John"

        str1 = "hello ${name}"
        str2 = str1

        println str1.equals(str2)
        println str1 == str2
    }
}
