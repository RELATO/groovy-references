import com.couchbase.client.CouchbaseClient
import com.google.gson.Gson

class LocationInfo {
    int id
    String name
}


Gson gson = new Gson()

def li = new LocationInfo(id:7840,name:'Chicago')
String key = "loc.7840"

String doc = gson.toJson(li,LocationInfo)


int timeout = 0;
ArrayList<URI> nodes = new ArrayList<URI>();
nodes.add(URI.create("http://127.0.0.1:8091/pools"));
CouchbaseClient client = new CouchbaseClient(nodes, "default", "")

client.set(key, timeout, doc);

LocationInfo linfo = gson.fromJson(client.get(key),LocationInfo)
println 'got:'+linfo.name

client.shutdown()
