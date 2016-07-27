/**
*
*/

class CSVParser {
    static def parseCSV(file,closure) {
        def lineCount = 0
        file.eachLine() { line ->
            def field = line.tokenize("\t")
            lineCount++
            closure(lineCount,field)
        }
    }
}

use(CSVParser.class) {
    File fil = new File('/tmp/test.csv')
    fil.parseCSV { index,field ->
        println "row: ${index} | ${field[0]} ${field[1]} ${field[2]}"
    }
}
