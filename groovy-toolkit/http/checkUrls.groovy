@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.5.0-RC2' )
import groovyx.net.http.*

/*
*       given an input file of URLs, test each URL
*       output a file of valid (including redirected) URLs
*/

http = new HttpURLClient()
http.setFollowRedirects(false)

if ( args.size() < 2  )
  { println "missing arguments" + args.size()
    println "Usage:  groovy checkurls.groovy inputFileName outputFileName [maxToCheck]"
    return
  }

inputFileName = args[0]
outFileName   = args[1]
max = 9999999999
if (args.size() > 2) {
	max = args[2].toInteger()
}

infile = new File(inputFileName)
if (! infile.exists()) {
    println "input file ${inputFileName} does not exist"
    return
}

outfile = new File(outFileName)
if (outfile.exists()) {
    outfile.delete()
    outfile = new File(outFileName)
}

int cnt = 0
infile.readLines().each{ url ->
  if (++cnt < max) {
        try {
            def resp = http.request(url: url)
            switch (resp.status) {
		case 200:
			outfile.append url
			outfile.append '\n'
			break
		case 301:
			outfile.append resp.url
			outfile.append '\n'
			println "redirect\t${url} ${resp.url}"
			break
		default:
			println "${resp.status}\t${url}"
		}
        } catch (Exception e) {
		println "fail:${e.message}\t${url}"
	}
  }
}

println "checked ${cnt} URLs"

