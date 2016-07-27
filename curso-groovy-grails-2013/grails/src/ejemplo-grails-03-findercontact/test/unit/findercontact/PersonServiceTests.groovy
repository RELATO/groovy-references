package findercontact



import grails.test.mixin.*

import org.junit.*

@TestFor(PersonService)
@Mock(Person)
class PersonServiceTests {

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
    }


    @Test
    void testFindContacts() {

        defineBeans {
            rules(fidercontactrules.Rules) {
                deltaAge = 5
                deltaHeight = 0.1
            }
        }

        def p = new Person(name:"Teresa", age:35, height:1.6f, sex:Person.WOMAN)
        def contacts = service.findContacts(p)
        assert contacts.size() == 2
        contacts.each {
            assert it.name == "Javier" || it.name == "Julio"
        }
    }
}
