package ejemplos07metaprogramacion

Integer.metaClass.numeroAleatorio = {
	def random = new Random()
	random.nextInt(delegate)
}

println 50.numeroAleatorio()