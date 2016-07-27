package findercontact

class PersonService {

    def rules

    def findContacts(Person p) {
        def contacts
        if (p.sex == Person.WOMAN) {
            contacts = Person.findAllBySex(Person.MAN)
        } else {
            contacts = Person.findAllBySex(Person.WOMAN)
        }

        log.info "-----------------SERVICE 1---------------------------"
        log.info contacts.size()
        contacts.each { log.info it }

        log.info "-----------------SERVICE 2---------------------------"
        log.info rules.class
        log.info "deltaAge=${rules.deltaAge}"
        log.info "deltaHeight=${rules.deltaHeight}"
        log.info "p=${p}"

        log.info "-----------------SERVICE 3---------------------------"
        contacts.each { log.info "$it -> ${rules.isAGoodContact(p,it)}" }

        log.info "-----------------SERVICE 4---------------------------"
        def goodContacts = contacts.findAll { rules.isAGoodContact(p,it) }
        log.info goodContacts.size()
        goodContacts.each { log.info it }

        goodContacts
    }
}
