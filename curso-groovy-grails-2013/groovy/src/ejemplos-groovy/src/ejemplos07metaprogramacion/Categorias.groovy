package ejemplos07metaprogramacion

class ClaseReceptora {

	def nombre
}

class ClaseCategoria {
	
	static def imprimir(ClaseReceptora cr) {
		println cr.nombre
	}
}

def c = new ClaseReceptora(nombre:"Adolfo")

use(ClaseCategoria) {
	
	c.imprimir()
}
