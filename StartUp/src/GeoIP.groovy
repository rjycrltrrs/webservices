@Grab ('com.github.groovy-wslite:groovy-wslite:1.1.2')
import wslite.soap.*

def client = new SOAPClient('http://www.webservicex.net/geoipservice.asmx')
def response = client.send (SOAPAction: 'http://www.webservicex.net/GetGeoIP'){
	body{
		GetGeoIP('xmlns':'http://www.webservicex.net/'){
			IPAddress ('192.168.8.1')
		}
	}
}

println response.GetGeoIPResponse.GetGeoIPResult