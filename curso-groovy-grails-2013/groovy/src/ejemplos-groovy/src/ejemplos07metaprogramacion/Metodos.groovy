package ejemplos07metaprogramacion

class Articulo1 {

	String nombre

	def imprimir() {
		println "nombre=$nombre"
	}

	Object invokeMethod(String metodo, Object args) {
		println "-> metodo=$metodo & args=$args"
	}
}

def a1 = new Articulo1(nombre:"art1")
a1.imprimir()
a1.metodoInexistente("asd", 123, true)

println "---"

class Articulo2 implements GroovyInterceptable {

	String nombre

	def imprimir() {
		println "nombre=$nombre"
	}

	Object invokeMethod(String metodo, Object args) {
		System.out.println "INCIO -> metodo=$metodo & args=$args"
		def metaMetodo = this.class.metaClass.getMetaMethod(metodo, args)
		metaMetodo?.invoke(this, args)
		System.out.println "FIN -> metodo=$metodo & args=$args"
	}
}

def a2 = new Articulo2(nombre:"art2")
a2.imprimir()
a2.metodoInexistente("asd", 123, true)