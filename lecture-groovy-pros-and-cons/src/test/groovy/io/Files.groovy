package io

class Files extends GroovyTestCase {

    void testRead() {

        def file = new File('pom.xml')
        file.each { println it }

        println new File('src/test/groovy/io/Files.groovy').text

        file = new File('.gitignore')
        file.withInputStream { is ->
            println is.read()
            println is.read()
            println is.read()
            println is.read()
            println is.read()
        }
    }

    void testWrite() {
        def file = new File('test.log')

        file.withWriter { writer ->
            writer.write("test success!\n")
        }

        (1..10).each { num ->
            file.withWriterAppend { writer ->
                writer.write("append line ${num}\n".toString())
            }
        }
    }
}
