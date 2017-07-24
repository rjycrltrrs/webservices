import javax.xml.ws.soap.SOAPFaultException;

@Grab('com.github.groovy-wslite:groovy-wslite:1.1.2')
import wslite.soap.*

def client = new SOAPClient('http://wsf.cdyne.com/WeatherWS/Weather.asmx')
try{
	def response = client.send(SOAPAction:'http://ws.cdyne.com/WeatherWS/GetCityForecastByZIP') {
	    body {
	        GetCityForecastByZIP('xmlns':'http://ws.cdyne.com/WeatherWS/') {
	         ZIP (10001)
	        }
	    }
	}
	
	println response.GetCityForecastByZIPResponse.GetCityForecastByZIPResult
}
catch(SOAPClientException sce){
	sce.message
	
}