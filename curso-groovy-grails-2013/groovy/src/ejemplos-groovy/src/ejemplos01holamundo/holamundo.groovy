package ejemplos01holamundo

class HelloWorld {

	def nombre

	def saluda() {
		return "Hola " + nombre
	}
}

HelloWorld hw = new HelloWorld()
hw.nombre = "Groovy"
println hw.saluda()

