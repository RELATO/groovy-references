package regex

class RegEx extends GroovyTestCase {

    void test1() {

        println (("cheesecheese" =~ /qwerty/) as boolean)
        println (("cheesecheese" =~ /cheese/) as boolean)
        println "cheesecheese" ==~ /qwerty/
        println "cheesecheese" ==~ /cheese/
        println "cheesecheese" ==~ /cheese\w+/

        def cheese = ("cheesecheese" =~ /cheese/).replaceFirst("nice")
        println cheese

        println "colour".replaceFirst(/ou/, "o")
    }
}
