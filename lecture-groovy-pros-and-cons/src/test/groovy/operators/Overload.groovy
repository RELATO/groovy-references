package operators

class Overload extends GroovyTestCase {

    void test1() {

        Authority files = new Authority() + Role.READ + Role.WRITE
        println files

        Authority readOnly = files - Role.WRITE
        println readOnly

        Authority blog = new Authority([Role.COMMENT])
        blog += Role.MODERATE
        println blog

        println files + blog
    }

}
