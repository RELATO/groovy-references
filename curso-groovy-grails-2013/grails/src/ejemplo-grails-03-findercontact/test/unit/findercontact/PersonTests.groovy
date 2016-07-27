package findercontact

import grails.test.mixin.*

import org.junit.*

@TestFor(Person)
class PersonTests {

    void testValidate() {
        def p1 = new Person(name:"Adolfo", age:35, height:1.79f, sex:Person.MAN)
        assert p1.validate()

        def p2 = new Person(name:"A", age:3, height:-1.79f, sex:'S')
        assert !p2.validate()
        assert p2.errors.errorCount == 4
    }
}
