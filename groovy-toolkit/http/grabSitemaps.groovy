import java.util.zip.GZIPInputStream;

/*
*	given the URL of an xml sitemap, output a file with all page URLs
*	handle sitemaps containing other sitemaps
*/
def sitemapReader(sitemapUrl) {
	println "starting sitemap:"+sitemapUrl
	def reader = sitemapUrl.toURL().newInputStream()
	if (sitemapUrl.endsWith('.gz')) {
	   reader = new GZIPInputStream(reader)
	}
	def sitemap = new XmlParser().parse(reader)

		// this is a sitemap containing other sitemaps
	sitemap.sitemap.loc.each { item ->
		sitemapReader(item.text())
    	}
		// this is a sitemap containing page URLs
	sitemap.url.loc.each { item ->
		outfile.append item.text()
		outfile.append '\n'
    	}
	reader.close()
}


if ( args.size() != 2  )
  { println "missing arguments" + args.size()
    println "Usage:  groovy grabSitemaps.groovy startingURL outputFileName"
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
sitemapReader(startingUrl)
