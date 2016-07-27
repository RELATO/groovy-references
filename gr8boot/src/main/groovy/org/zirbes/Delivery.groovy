package org.zirbes

import org.joda.time.LocalDate

class Delivery {

    private LocalDate dateCreated = new LocalDate()

    Insult insult = Insult.fuckOff()
    Confrontation confrontation

    String toString() {
        return insult.template.make(confrontation.toMap()).toString()
    }

    String getCreated() {
        dateCreated.toString('yyyy-MM-dd')
    }

}
