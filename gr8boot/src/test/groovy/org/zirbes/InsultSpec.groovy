package org.zirbes

import java.util.concurrent.CopyOnWriteArrayList

import spock.lang.Specification

class InsultSpec extends Specification {

    String AUTHOR = 'Pooh Bear'
    String SUBJECT = 'Eeor'
    Jerk jerk

    void setup() {
        jerk = new Jerk()
    }

    void 'insult works as expected'() {
        given:
        Confrontation confrontation = getFight()
        Delivery delivery = new Delivery(confrontation: confrontation)

        when:
        String insult = delivery.toString()

        then:
        insult == 'Good day to you Eeor.'
    }

    void 'insult works with observable'() {
        given:
        CopyOnWriteArrayList<String> insults = []

        when:
        jerk.insult(AUTHOR, SUBJECT).subscribe{
            insults << it.toString()
        }

        then:
        insults[0] == 'Good day to you Eeor.'
    }


    void 'insult works on a collection'() {
        given:
        String[] subjects = [ 'Peter', 'Paul', 'Mary' ]
        CopyOnWriteArrayList<String> insults = []

        when:
        jerk.insult(AUTHOR, subjects).subscribe{
            insults << it.toString()
        }

        then:
        insults.size() == 3
        insults[0] == 'Good day to you Peter.'
        insults[2] == 'Good day to you Mary.'
    }

    Confrontation getFight() {
        Confrontation confrontation = new Confrontation(AUTHOR, SUBJECT)

    }

}
