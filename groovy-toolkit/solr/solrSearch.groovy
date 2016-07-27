import org.apache.solr.client.solrj.impl.CloudSolrServer;

import org.apache.solr.client.solrj.SolrQuery
import UrlInfo

def cloudUrl = "localhost:9983"
def solrServer = new CloudSolrServer( cloudUrl )
solrServer.setDefaultCollection("theCore")

println "solr server:"+solrServer
if ( args.size() != 1  ) { 
	println "missing arguments" + args.size()
	println 'args:'+args
	println "Usage:  groovy solrSearch.groovy keyword"
	return
}

def keyword = args[2]
println "searching ${keyword}"

def solrQuery = new SolrQuery()
	.setRows(100)
        .addField("url")
        .setQuery("${keyword} OR \"${keyword}\"^30")
	.addFilterQuery("last_update:[NOW/DAY-10DAYS TO NOW/HOUR-1HOUR]")
solrQuery.set("qf", "url_s metaKeywords_s")
solrQuery.set("defType","edismax")

println "query:\n "+solrQuery
rsp = solrServer.query(solrQuery)
beans = rsp.getBeans(UrlInfo.class)
beans.each {
	println "${it.url}"
}
solrServer.shutdown()
