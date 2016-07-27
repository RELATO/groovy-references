package findercontact

import static org.junit.Assert.*
import grails.validation.ValidationException

import org.junit.*

class PersonIntegrationTests {

    @Test
    void testSave() {

        def p1 = new Person(name:"Adolfo", age:35, height:1.79f, sex:Person.MAN)
        def initCount1 = Person.count
        assert p1.save()
        def endCount1 = Person.count
        assert endCount1 == initCount1 + 1

        def p2 = new Person(name:"A", age:3, height:-1.79f, sex:'S')
        def initCount2 = Person.count
        assert !p2.save()
        def endCount2 = Person.count
        assert endCount2 == initCount2
        assert p2.errors.errorCount == 4

        try {
            p2.save(failOnError:true)
            fail "should not be here"
        } catch (ValidationException e) {
            assert p2.errors.errorCount == 4
        }
    }
}
