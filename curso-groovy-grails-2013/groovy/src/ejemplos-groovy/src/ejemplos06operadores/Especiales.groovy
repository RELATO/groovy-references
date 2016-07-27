package ejemplos06operadores

class Persona {

	String nombre
	
	int edad
	
	String imprimir() {
		println "$nombre:$edad"
	}
	
	String imprimir(num) {
		println "$nombre:$edad:$num"
	}
	
	boolean equals(Object o) {
		return nombre?.equals(o.nombre)
	}
	
	String toString() {
		"$nombre:$edad"
	}
}

def p = new Persona(edad:25)
println p?.nombre?.indexOf(0)
println "---"

println p.@edad // accede directamente a la propiedad y es más óptimo que utilizar get o set
println "---"

def p1 = new Persona(nombre:"pepe",edad:25)
def personas = [ p1, new Persona(nombre:"fulano", edad:35)]
personas*.imprimir()
println "---"

def cadena1 = "otro valor"
println cadena1?:"valor por defecto"
println "---"

def cadena2 = ""
println cadena2?:"valor por defecto"
println "---"

def p2 = new Persona(nombre:"pepe")
def p3 = personas[0]
println p2.is(p3)
println p2 == p3
println "---"

def p4 = personas[0]
println p4.is(p3)
println p4 == p3
println "---"

def closure = p1.&imprimir
(1..4).each closure
println "---"

personas.each { println it }
println "---"

def del = personas.&remove
del 0
personas.each { println it }
println "---"