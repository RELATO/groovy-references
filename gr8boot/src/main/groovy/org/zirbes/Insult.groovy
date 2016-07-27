package org.zirbes

import org.joda.time.LocalDate

import groovy.text.SimpleTemplateEngine
import groovy.text.Template

class Insult {

    static final String DEFAULT_INSULT = 'Good day to you ${subject}.'

    private final String insultTemplateString
    private final Template insultTemplate

    static Insult fuckOff() {
        return Insult.fromTemplate(DEFAULT_INSULT)
    }

    Insult(String insultTemplateString) {
        this.insultTemplateString = insultTemplateString

        final SimpleTemplateEngine engine = new SimpleTemplateEngine()
        insultTemplate = engine.createTemplate(insultTemplateString)
    }

    static Insult fromTemplate(String insultTemplateString) {
        return new Insult(insultTemplateString)
    }

    Template getTemplate() {
        return insultTemplate
    }

}
