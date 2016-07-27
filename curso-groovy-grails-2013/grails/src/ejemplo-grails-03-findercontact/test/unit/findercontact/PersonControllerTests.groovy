package findercontact



import org.junit.*

import fidercontactrules.Rules
import grails.test.mixin.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(PersonController)
@Mock([Person, PersonService])
class PersonControllerTests {

    @Before
    void setUpPersons() {

        def p1 = new Person(name:"Adolfo", age:35, height:1.7f, sex:Person.MAN)
        p1.save(failOnErro:true)

        def p2 = new Person(name:"Andres", age:25, height:1.6f, sex:Person.MAN)
        p2.save(failOnErro:true)

        def p3 = new Person(name:"Javier", age:30, height:1.51f, sex:Person.MAN)
        p3.save(failOnErro:true)

        def p4 = new Person(name:"Julio", age:40, height:1.69f, sex:Person.MAN)
        p4.save(failOnErro:true)

        def p5 = new Person(name:"Laura", age:35, height:1.6f, sex:Person.WOMAN)
        p5.save(failOnErro:true)

        controller.personService.rules = new Rules(5, 0.1f)
    }


    void testFind() {

        request.method = 'POST'
        def params = [name:"Teresa", age:35, height:1.6f, sex:Person.WOMAN]
        controller.params.putAll(params)

        controller.findContacts()

        assert view == '/person/findContacts'
        def contacts = model.contacts
        assert contacts.size() == 2
        contacts.each {
            assert it.name == "Javier" || it.name == "Julio"
        }
    }
}
