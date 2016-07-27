package embed

class Embed extends GroovyTestCase{
    void test1() {

        def shell = new GroovyShell()
        def result = shell.evaluate("12 + 23")
        println result
    }

    void test2() {

        def shell = new GroovyShell()
        def result = shell.evaluate("""

class Main {
    int i
    public Main(int i) {this.i = i}
    public String toString() { "hello \${i}" }
}

return new Main(55).toString()

""")
        println result
    }
}
