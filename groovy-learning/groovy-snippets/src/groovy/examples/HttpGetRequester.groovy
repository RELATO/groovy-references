package groovy.examples

/**
 * This class shows how to make REST API call using Groovy
 *
 */
class HttpGetRequester {

	static main(args) {
		def baseURL = 'https://www.googleapis.com/customsearch/v1?'
		def paramMap = [key:'AIzaSyDo77PB-8pCk64buONn3S9y5F4FtHrMw-8', cx:'partner-pub-7224703061376934%3Ad94rr5-308j', q:'AppleiPhone5']
		def paramList = paramMap.collect{k,v -> "$k" + "=" +"$v"}
		def queryString = paramList.join("&")
		def requestURL = baseURL + queryString
		
		println 'request URL: ' + requestURL
		println requestURL.toURL().text
	}

}
