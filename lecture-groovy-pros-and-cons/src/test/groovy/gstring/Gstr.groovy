package gstring

public class Gstr extends GroovyTestCase {

    static class Complex {

        String getWord(){
            return "complex"
        }

    }

    void test1() {

        def foxtype = 'quick'
        def foxcolor = ['b', 'r', 'o', 'w', 'n']

        println "The $foxtype ${foxcolor.join("")} fox"
    }

    void test2() {
        println "It is currently ${ new Date() }"
    }

    void test3() {
        println "This is ${Math.sin(1) > 1 ? "an error" : "a ${new Complex().word + " ${GString.class.simpleName}"} example"}"
    }

    void test4() {
        println """
                This
                    Is
                        A
                            Test
                """
    }
}
