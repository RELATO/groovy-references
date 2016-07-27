@Grab(group='org.jsoup', module='jsoup', version='1.7.2')
/*
*	given a starting URL, output a file with all child page URLs
*/
def pageReader(url,handlePage) {
	println "starting page:"+url
	thisHost = new URL(url).host
	this.scraped << url
	try {
		def document = org.jsoup.Jsoup.connect(url)
		def resp = document.get()
		def links = resp.select("a[href]"); // a with href
		links.each {
			page  = it.attr("href")
			handlePage(it)
		}
	} catch (Exception e) {
		println "exception ${url} ${e.message}"
	}
}


if ( args.size() != 2  )
  { println "missing arguments" + args.size()
    println "Usage:  groovy scraper.groovy startingURL outputFileName"
    return
  }

def startingUrl = args[0]
def outFileName = args[1]

outfile = new File(outFileName)
if (outfile.exists()) {
    outfile.delete()
    outfile = new File(outFileName)
}

println "output file name:${outFileName}"
scraped = []

handlePage = {
	page  = it.attr("href")
	title = it.text()
println page+"\t"+title
	if (!scraped.contains(page) && page.startsWith("http") && ! page.contains("?") ) {
		if (page.endsWith("sitemap")) {
			pageReader(page,handlePage)
		} else if (	// criteria here...
page.startsWith("http:") 
&& new URL(page).host == thisHost 
&& !page.contains("?")
//&& (page.contains(".h") || page.contains(".t") || page.contains(".i") )
//&& new URL(page).path.split('/').size() > 2 
) {
			outfile.append page
			outfile.append '\n'
			pageReader(page,handlePage)
		}
	}
}
pageReader(startingUrl,handlePage)
