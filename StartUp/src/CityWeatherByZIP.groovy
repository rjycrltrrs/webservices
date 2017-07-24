//@Grab('com.github.groovy-wslite:groovy-wslite:1.1.2')
import wslite.soap.*

class CityWeatherByZIP{
	def client = new SOAPClient('http://wsf.cdyne.com/WeatherWS/Weather.asmx') //asmx
	
	def response
	
	def getData(text){
		response = client.send (SOAPAction: 'http://ws.cdyne.com/WeatherWS/GetCityWeatherByZIP'){
			body{
				GetCityWeatherByZIP('xmlns':'http://ws.cdyne.com/WeatherWS/'){
					ZIP(text)
				}
			}
		}
		
		return response.GetCityWeatherByZIPResponse.GetCityWeatherByZIPResult
	}
}