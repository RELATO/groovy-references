package templates

import groovy.text.SimpleTemplateEngine

class Templater extends GroovyTestCase {
    void test1() {

        def ste = new SimpleTemplateEngine()

        def template = 'Dear "$firstname $lastname",\n' +
                'So nice to meet you in <% print city %>.\n' +
                'See you in ${month},\n' +
                '${signed}'

        def binding = [
                "firstname": "Sam",
                "lastname": "Pullara",
                "city": "San Francisco",
                "month": "December",
                "signed": "Groovy-Dev"
        ]

        println ste.createTemplate(template).make(binding).toString()
    }
}
