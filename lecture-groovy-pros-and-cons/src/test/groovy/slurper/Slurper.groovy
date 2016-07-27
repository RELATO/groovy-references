package slurper

import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.xml.MarkupBuilder
import groovy.xml.XmlUtil

class Slurper extends GroovyTestCase {

    void testWriteXml() {

        def builder = new MarkupBuilder(new PrintWriter(System.out))

        builder.numbers {
            description 'Squares and factors of 10..15'
            for (i in 10..15) {
                number(value: i, square: i * i) {
                    for (j in 2..<i) {
                        if (i % j == 0) {
                            factor(value: j)
                        }
                    }
                }
            }
        }
    }

    void testReadXml() {
        def xmlString = """<person id="123"><username>Guillaume</username><age>33</age><gender>female</gender><pets><pet>Hector</pet><pet>Felix</pet></pets></person>"""

        println XmlUtil.serialize(xmlString)

        def person = new XmlSlurper().parseText(xmlString)
        println person.username
        person.pets.pet.each { println "pet's name: " + it }
    }

    void testReadJson() {
        def someJSONString = '{"person":{"username":"Guillaume","age":33,"pets":["Hector","Felix"]}}'
        println JsonOutput.prettyPrint(someJSONString)

        def slurper = new JsonSlurper()
        def doc = slurper.parseText(someJSONString)

        println doc.person.username
        doc.person.pets.each { println it }
    }

    void testWriteJson() {
        def builder = new JsonBuilder()
        builder.people {
            person {
                firstName 'Guillame'
                lastName 'Laforge'
                // Named arguments are valid values for objects too
                address(
                        city: 'Paris',
                        country: 'France',
                        zip: 12345,
                )
                married true
                // a list of values
                conferences 'JavaOne', 'Gr8conf'
            }
        }

        println builder.toPrettyString()
    }
}
