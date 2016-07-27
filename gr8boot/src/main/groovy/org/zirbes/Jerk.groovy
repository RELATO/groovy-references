package org.zirbes

import org.joda.time.LocalDate
import rx.Observable

class Jerk {

    Observable<Delivery> insult(String author, String subject) {
        String[] subjects = [ subject ]
        return insult(author, subjects)
    }


    Observable<Delivery> insult(String author, Collection<String> subjects) {
        return insult(author, subjects.toArray())
    }

    Observable<Delivery> insult(String author, String[] subjects) {
        List<Confrontation> confrontations = []
        subjects.collect{ confrontations << new Confrontation(author, it) }
        return insultConfrontations(confrontations)
    }

    private Observable<Delivery> insultConfrontations(Collection<Confrontation> confrontations) {
        List<Delivery> deliveries = confrontations.collect{ new Delivery(confrontation: it) }
        return Observable.from(deliveries)
    }
}
