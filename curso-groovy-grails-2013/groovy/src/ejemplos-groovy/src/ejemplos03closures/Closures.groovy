package ejemplos03closures

def nombre = "Adolfo"

def closure = {
	println "hola ${nombre}"
}
closure()
println "---"

def closureParametroIt = {
	println "hola ${it}"
}
closureParametroIt "Pepe"
println "---"

def closureParametroNombre = { nombreParametro ->
	println "hola ${nombreParametro}"
}
closureParametroNombre "Pepito"
println "---"

def closure2Parametros = { x, y ->
	def suma = x + y
	println "suma = ${suma}"
}
closure2Parametros 5, 2
println "---"

def closure2ParametrosDefecto = { x, y=5 ->
	def suma = x + y
	println "suma = ${suma}"
}
closure2ParametrosDefecto 5
closure2ParametrosDefecto 5, 2
println "---"

def closure2ParametrosCurry = { x, y ->
	def res = x * y
	println "res = ${res}"
}
def doble = closure2ParametrosCurry.curry(2)
def triple = closure2ParametrosCurry.curry(3)
doble 7
triple 7
println "---"

def funcionNecesitaClosureComoParametro(int total, Closure closure) {
	for(int i = 0; i < total; i++) {
		closure.call(i)
	}
}
funcionNecesitaClosureComoParametro 4, closureParametroNombre
println "---"
funcionNecesitaClosureComoParametro 4, { println "closure anonima : ${it}" }
println "---"

def lista=[1,3,5]
lista.each { println it*2 }