package methods

class Methods extends GroovyTestCase {

    void up1(String str) {
        str.toUpperCase()
    }

    def up2(String str) {
        str.toUpperCase()
    }

    void test1() {
        println up1("abcd")
        println up2("efgh")
    }


    def up3(String str) {
        if(str.length()>3){
            str.toUpperCase()
        }
    }
    void test2() {
        println up3("qw")
        println up3("hello")
    }

    def tcf(boolean thrw) {
        try {
            if (thrw) throw new Exception("foo")
            1
        } catch(e) {
            2
        } finally {
            3
        }
    }

    void test3() {
        println tcf(true)
        println tcf(false)
    }
}
