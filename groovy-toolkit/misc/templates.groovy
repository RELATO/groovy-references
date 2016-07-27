/**
*	reusable templating
*/
import groovy.text.SimpleTemplateEngine
def engine = new SimpleTemplateEngine()

def template = 'Dear "$firstname $lastname",\nSo nice to meet you in <% print city %>.\nSee you in ${month},\n${signed}' 

def binding = ["firstname":"Warren", 
		"lastname":"Nisley", 
		"city":"San Francisco", 
		"month":"July", 
		"signed":"wn"] 

template = engine.createTemplate(template).make(binding)

println template.toString()

