import javax.xml.ws.soap.SOAPFaultException;

@Grab('com.github.groovy-wslite:groovy-wslite:1.1.2')
import wslite.rest.*
import wslite.soap.*

try{
	def restClient = new RESTClient('http://maps.googleapis.com/')
	def restResponse = restClient.get(path:'/maps/api/geocode/json', query:[address:'Philippines', sensor:'false'])
	
	println restResponse.text
}
catch(RESTClientException rce){
	println "error at rest"
	rce.printStackTrace()
}
println "==============================="
try{
	def soapClient = new SOAPClient('http://www.webservicex.net/ConvertTemperature.asmx')
	def soapResponse = soapClient.send (SOAPAction: 'http://www.webserviceX.NET/ConvertTemp'){
		body{
			ConvertTemp('xmlns':'http://www.webserviceX.NET/'){
				Temperature(100)
				FromUnit('degreeCelsius')
				ToUnit('degreeFahrenheit')
			}
		}
	}
	println soapResponse.ConvertTempResponse.ConvertTempResult
}
catch(SOAPFaultException sce){
	println "error at soap"
	sce.printStackTrace()
}