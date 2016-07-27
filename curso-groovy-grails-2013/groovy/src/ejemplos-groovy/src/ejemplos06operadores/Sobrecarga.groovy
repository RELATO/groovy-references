package ejemplos06operadores

class Factura {
	
	int total
	
	def plus(Factura f) {
		new Factura(total:total+f.total)
	}
	
	String toString() {
		total
	}
}

def f1 = new Factura(total:5)
def f2 = new Factura(total:2)

println f1 + f2
println f1