package ejemplos11plantillas

import groovy.text.SimpleTemplateEngine

class Usuario {
	def nombre
	def apellidos
}

def plantilla=this.class.getResource("plantillaEmail.gtpl")
def datos=[
	"usuario": new Usuario(nombre:"Adolfo", apellidos:"Sanz"),
	"fecha":new Date()]
def procesador=new SimpleTemplateEngine()
def correo=procesador.createTemplate(plantilla).make(datos);
println correo.toString()
