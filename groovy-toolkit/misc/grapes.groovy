@Grab(group = 'org.codehaus.groovy.modules.http-builder', module = 'http-builder', version = '0.5.0-RC2')

import groovyx.net.http.*
def http = new HttpURLClient()
http.setFollowRedirects(false)

def qry  = "http://www.flythisweekend.com"
def resp = new URL(qry).text

println resp

