import org.xml.sax.Attributes
import org.xml.sax.InputSource
import org.xml.sax.helpers.DefaultHandler

import javax.xml.parsers.SAXParserFactory

/**
 * Process Solr XML responses using a sax parser.
 * (Sax parsing is more efficient for very large files)
 *
 * Inject an "endDoc" closure to process each document...
 *
 * usage:

 def qry = "http://myhost.com:8980/location/select?rows=100&wt=xml&fq=loc.level:7&q:locale=fr_FR"

 def handleDoc = {
    println it.get('loc.locationName')
 }
 groovy.SolrXmlResponseSaxHandler.handleQuery(qry,handleDoc)


 */
class SolrXmlResponseSaxHandler extends DefaultHandler {

    def currentDoc
    def currentKey = null
    def currentVal = ""
    def inResult = false
    def endDoc = {}

    void startElement(String ns, String localName, String qName, Attributes atts) {
        switch (qName) {
            case 'result':
                inResult = true
                break
            case 'doc':
                currentDoc = [:]
                currentKey = null
                currentVal = ""
                break
            case 'int':
                if (inResult && atts.getValue("name")) {
                    currentKey = atts.getValue("name") // top-level integer
                }
                break
            case 'arr':
                if (inResult && atts.getValue("name")) {
                    currentKey = atts.getValue("name")   // top-level array
                }
                break
            case 'date':
                if (inResult && atts.getValue("name")) {
                    currentKey = atts.getValue("name") 	// top-level date  
                }
                break
            case 'str':
                if (inResult && atts.getValue("name")) {
                    currentKey = atts.getValue("name") 	// top-level string
                }
                break
            default:
                currentKey = null
        }
    }

    void characters(char[] chars, int offset, int length) {
        if (inResult && currentKey) {
            currentVal += new String(chars, offset, length)
        }
    }

    void endElement(String ns, String localName, String qName) {
        if (inResult) {
            switch (qName) {
                case "str":
                    if (currentKey) {
                        currentDoc[currentKey] = currentVal
                        currentVal = ""
                    }
                    break
                case "date":
                    if (currentKey) {
                        currentDoc[currentKey] = currentVal
                        currentVal = ""
                    }
                    break
                case "int":
                    if (currentKey) {
                        currentDoc[currentKey] = currentVal
                        currentVal = ""
                    }
                    break
                case "doc":
                    this.endDoc(currentDoc)
            }
        }
    }

    /**
     *
     * @param query - solr query string to execute
     * @param endDocClosure - closure to fire after every solr doc element
     */
    def static handleQuery(String query, Closure endDocClosure) {
        def handler = new SolrXmlResponseSaxHandler(endDoc: endDocClosure)
        def reader = SAXParserFactory.newInstance().newSAXParser().XMLReader
        reader.setContentHandler(handler)
        def inputStream = new URL(query).openStream()
        reader.parse(new InputSource(inputStream))
    }
}

