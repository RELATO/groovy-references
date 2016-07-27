package ejemplos07metaprogramacion

def posicion = new Expando()

posicion.latitud = 10
posicion.longitud = 20

posicion.mover = { deltaLatitud, deltaLongitud ->
	posicion.latitud += deltaLatitud
	posicion.longitud += deltaLongitud
}

posicion.toString = {
	"latitud:$latitud & longitud:$longitud"
}

println posicion
posicion.mover 5, 3
println posicion
