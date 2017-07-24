//@Grab('com.github.groovy-wslite:groovy-wslite:1.1.2')
import wslite.rest.*

public class GoogleMap{
	public String getMap(String location){
		
		def response = 'http://maps.googleapis.com/maps/api/staticmap?center='+ location +'&size=1320x768'
		
		return response
	}
}





//http://maps.googleapis.com/maps/api/staticmap?center=Philippines&size=1320x768