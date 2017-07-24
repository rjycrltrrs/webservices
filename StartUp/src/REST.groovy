//@Grab('com.github.groovy-wslite:groovy-wslite:1.1.2')
import wslite.rest.*

public class REST{
	
	public REST(){
		getGeo("Magalang")
	}
	
	public String getGeo(location){
	
	def client = new RESTClient("http://maps.googleapis.com/")
	def getResponse = client.get(path:'/maps/api/geocode/json', query:[address:location, sensor:'false'])
	
	return getResponse.json.results.formatted_address
	
	}
	public static void main(String []args){
		new REST()
	}
}

//POST
//def postResponse = client.post (path: '/maps/api/geocode/xml'){
//	type ContentType.XML
//	xml{
//		Comment{
//			Text("This is a comment from xvi")
//		}
//	}
//}
//
//println postResponse.text
