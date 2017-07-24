@Grab ('com.github.groovy-wslite:groovy-wslite:1.1.2')
import wslite.soap.*

def client = new SOAPClient('http://www.webservicex.net/geoipservice.asmx')
def response = client.send(SOAPAction: 'http://www.webservicex.net/GetGeoIPContext'){
	body{
		GetGeoIPContext('xmlns':'http://www.webservicex.net/'){
			
		}
	}
}
println response.text