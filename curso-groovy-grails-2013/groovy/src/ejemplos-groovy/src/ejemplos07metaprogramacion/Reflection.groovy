package ejemplos07metaprogramacion

class Ejemplo implements Serializable {

	String nombre
	
	def imprimir() {
		println "nombre -> $nombre"
	}
	
	def add(cadena) {
		nombre+=cadena
	}
}

def ej = new Ejemplo(nombre:"Adolfo")

def cl = { println it }
def hd = { println "---$it---"}

hd "interfaces"
ej.class.interfaces.each cl

hd "constructores"
ej.class.constructors.each cl

hd "methods"
ej.class.methods.each cl

hd "properties"
ej.properties.each cl

assert Ejemplo == ej.class

hd "metaClass"
if ( Ejemplo.metaClass.hasProperty(ej, "nombre") ) {
	cl "has property nombre"
}
if ( Ejemplo.metaClass.respondsTo(ej, "imprimir") ) {
	cl "has method imprimir"
}

hd "ejecucion dinámica"
def cadena = "imprimir"
ej."$cadena"()

hd "funcion a closure"
def mas = ej.&add
mas " hola"
mas " adios"
ej.imprimir()