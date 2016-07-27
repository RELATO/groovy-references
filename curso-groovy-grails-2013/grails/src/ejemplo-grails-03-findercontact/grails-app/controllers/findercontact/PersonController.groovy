package findercontact

import grails.plugins.springsecurity.Secured

@Secured(['IS_AUTHENTICATED_FULLY'])
//IS_AUTHENTICATED_ANONYMOUSLY - NO LOGIN NEEDED
//IS_AUTHENTICATED_REMEMBERED - LOGED O REMBER CHECKED
//IS_AUTHENTICATED_FULLY - MUST RE-LOGIN
class PersonController {

    def personService

    def person

    def index() {
    }

    @Secured(['ROLE_ADMIN'])
    def findContacts() {

        person = new Person(params)

        if (!person.validate()) {
            return render(view:'index', model:[user:person])
        }

        def contacts = personService.findContacts(person)

        log.info "-----------------CONTROLLER-----------------------------------"
        log.info contacts.size()
        contacts.each { log.info it }

        render(view:'findContacts', model:[contacts:contacts])
    }
}
