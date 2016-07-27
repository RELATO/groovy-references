package exec

class Exec extends GroovyTestCase {
    void testExec() {

        def proc = 'cmd /C dir'.execute()
        proc.waitForOrKill(5000)
        println proc.in.text
    }
}
