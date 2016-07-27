package groovy.learning

import groovy.text.SimpleTemplateEngine

/**
 * This class show how to substitute values into template using SimpleTemplateEngine
 *
 */
class GroovyTextTemplate {

	static main(args) {
		def String template = 'Hello ${name}. Thank you for purchasing ${product}. Received your order on ${orderDate}'

		def valueMap = [name: 'Dave', product: 'Smart Phone', orderDate: new Date()]
		def engine = new SimpleTemplateEngine();
		def writable = engine.createTemplate(template).make(valueMap);

		println '----> printing template with values substituated'
		println writable.toString()
	}
}
