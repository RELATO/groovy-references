package ejemplos10xml

import groovy.xml.MarkupBuilder

def writer = new StringWriter()
def builder = new MarkupBuilder(writer)
builder.setDoubleQuotes true
builder.personas{
  persona(id:"1"){
    nombre "Adolfo"
    edad 35
  }
  persona(id:"2"){
    nombre "Alba"
    edad 25
  }
}
println writer.toString()

def file = new File("personas.xml")
file.write(writer.toString())