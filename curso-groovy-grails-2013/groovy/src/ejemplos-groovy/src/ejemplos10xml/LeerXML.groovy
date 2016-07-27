package ejemplos10xml

def personas1=new XmlParser().parse("personas.xml")
personas1.each { println it }
println personas1.persona.size()
println personas1.persona[0].@id
println personas1.persona[0].nombre
println personas1.persona[0].nombre.text()

println "---"

def personas2=new XmlSlurper().parse("personas.xml")
personas2.each { println it }
println personas2.persona.size()
println personas2.persona[0].@id
println personas2.persona[0].nombre
println personas2.persona[0].nombre.text()

