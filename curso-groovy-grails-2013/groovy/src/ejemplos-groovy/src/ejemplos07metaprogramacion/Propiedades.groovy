package ejemplos07metaprogramacion

class EjemploPropiedades {

	def propiedades = [:]
	
	void setProperty(String nombre, Object valor) {
		propiedades[nombre] = valor
	}
	
	Object getProperty(String nombre) {
		propiedades[nombre]
	}
}


def ej = new EjemploPropiedades()
ej.nombre = "Adolfo"
ej.edad = 35
println "${ej.nombre} -> ${ej.edad}"

ej.@propiedades.each { println it }