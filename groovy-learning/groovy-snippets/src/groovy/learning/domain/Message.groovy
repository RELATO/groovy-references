package groovy.learning.domain

class Message {
	String type
	String content
	
	void printMessage() {
		println "Message - type: ${type} content: ${content}"
	}
}
