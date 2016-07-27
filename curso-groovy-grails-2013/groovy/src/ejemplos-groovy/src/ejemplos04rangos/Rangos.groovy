package ejemplos04rangos

(1..3).each { println it }
println "---"

(1..<3).each { println it }
println "---"

def hoy = new Date()
def mas3dias = hoy + 3
(hoy..mas3dias).each { println it }
println "---"

('b'..'d').each { println it }
println "---"

def rango = (5..8)
println rango.class
println rango.from
println rango.to
println rango.contains(6)
println rango.size()
println rango.get(2)
println rango[2]
println "---"

def sueldo = 1500
switch(sueldo) {
	case 300..<1000:
		println 'nivel 1'
		break
	case 1000..<2000:
		println 'nivel 2'
}