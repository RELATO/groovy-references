package ejemplos05collections

def imprimir = { c -> 
	println c.class
	c << "uno"
	c << "dos"
	c << "uno"
	c.each { println it }
	println "---"
}

def c1 = []
imprimir c1

def c2 = [] as Set
imprimir c2

