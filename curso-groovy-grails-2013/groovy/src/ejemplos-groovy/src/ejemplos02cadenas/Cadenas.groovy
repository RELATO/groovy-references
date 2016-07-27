package ejemplos02cadenas

def nombre = "Adolfo"

def imprimirCadena = { cadena -> 
	println cadena
	println cadena.class
	println "---"
}

imprimirCadena 'Hola ${nombre}' // comillas simples no interpretan la variable nombre

imprimirCadena "Hola $nombre" // comillas dobles si interpretan la variable nombre

def textoLargo = """
Hola ${nombre}
¿Qué tal estás hoy?
"""

imprimirCadena textoLargo