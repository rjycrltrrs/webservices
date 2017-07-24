@Grab('com.github.groovy-wslite:groovy-wslite:1.1.2')
import wslite.soap.*

def client = new SOAPClient('http://wsf.cdyne.com/WeatherWS/Weather.asmx') //asmx
def response = client.send (SOAPAction: 'http://ws.cdyne.com/WeatherWS/GetWeatherInformation'){
	body{
		
	}
}

println response.text