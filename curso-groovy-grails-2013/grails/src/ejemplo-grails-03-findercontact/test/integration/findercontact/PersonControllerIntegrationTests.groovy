package findercontact

import static org.junit.Assert.*

import org.junit.*

class PersonControllerIntegrationTests {

    @Before
    void setUpPersons() {

        Person.findAll().each { it.delete() }

        new Person(name:"Adolfo", age:35, height:1.7f, sex:Person.MAN).save(failOnErro:true)
        new Person(name:"Andres", age:25, height:1.6f, sex:Person.MAN).save(failOnErro:true)
        new Person(name:"Javier", age:30, height:1.51f, sex:Person.MAN).save(failOnErro:true)
        new Person(name:"Julio", age:40, height:1.69f, sex:Person.MAN).save(failOnErro:true)
        new Person(name:"Laura", age:35, height:1.6f, sex:Person.WOMAN).save(failOnErro:true)
    }


    @Test
    void testFind() {

        def controller = new PersonController()

        controller.request.method = 'POST'
        def params = [name:"Teresa", age:35, height:1.6f, sex:Person.WOMAN]
        controller.params.putAll(params)

        controller.findContacts()

        assert controller.modelAndView.viewName == '/person/findContacts'
        def contacts = controller.modelAndView.model.contacts
        assert contacts.size() == 2
        contacts.each {
            assert it.name == "Javier" || it.name == "Julio"
        }
    }
}
