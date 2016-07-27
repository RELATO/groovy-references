package ejemplos05collections

def mapa = [:]
println mapa.getClass()

mapa = [ "uno":"one", "dos":"two" ]

// acceder por key
println mapa["uno"]
println mapa."uno"
println mapa.uno
println mapa.get("uno")

// asignar
mapa.put("dos","2")

// iteracion
mapa.each { println it }
mapa.each { println it.key + " -> " + it.value }
mapa.each { k, v -> println "$k >> $v" }

// keySet y values
mapa.keySet().each { println it }
mapa.values().each { println it }