package ejemplos08dsl

class Minutos {
	
	def minutos
	
	def getSegundos() {
		new Segundos(segundos:minutos*60)
	}
	
	def plus(suma) {
		// println "suma="+suma.class
		// def m = suma.minutos
		// println "m="+m.class
		def minutosSuma = suma.minutos.exportToInteger()
		def nuevosMinutos = minutos + minutosSuma
		new Minutos(minutos: nuevosMinutos)
	}
	
	Integer exportToInteger() {
		minutos
	}
	
	String toString() {
		"$minutos minutos"
	}
	
	def getEn() {
		this
	}
}

class Segundos {
	
	Integer segundos
	
	def getMinutos() {
		new Minutos(minutos:segundos/60)
	}
	
	def plus(suma) {
		// println "suma="+suma.class
		// def s = suma.segundos
		// println "s="+s.class
		def segundosSuma = suma.segundos.exportToInteger()
		def nuevosSegundos = segundos + segundosSuma
		new Segundos(segundos: nuevosSegundos)
	}
	
	Integer exportToInteger() {
		segundos
	}
	
	String toString() {
		"$segundos segundos"
	}
	
	def getEn() {
		this
	}
}

Integer.metaClass.getSegundos = {
	new Segundos(segundos:delegate)
}

Integer.metaClass.getMinutos = {
		new Minutos(minutos:delegate)
}

Integer.metaClass.exportToInteger = {
	delegate
}

println 2.minutos.segundos
println 180.segundos.en.minutos

println 3.minutos + 2.minutos
println 120.segundos + 180.segundos

println 3.minutos + 60.segundos
println 120.segundos + 5.minutos