@Grab('com.github.groovy-wslite:groovy-wslite:1.1.2')
import wslite.soap.*

def client = new SOAPClient('http://www.webservicex.net/ConvertTemperature.asmx')
 def response = client.send (SOAPAction: 'http://www.webserviceX.NET/ConvertTemp'){
	body{
		ConvertTemp('xmlns':'http://www.webserviceX.NET/'){
			Temperature(100)
			FromUnit('degreeCelsius')
			ToUnit('degreeFahrenheit')
		}
	}
}
println response.ConvertTempResponse.ConvertTempResult
