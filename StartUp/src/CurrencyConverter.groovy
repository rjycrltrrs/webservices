@Grab ('com.github.groovy-wslite:groovy-wslite:1.1.2')
import wslite.soap.*

def client = new SOAPClient('http://www.webservicex.net/CurrencyConvertor.asmx')
def response = client.send (SOAPAction: 'http://www.webserviceX.NET/ConversionRate'){
	body{
		ConversionRate('xmlns':'http://www.webserviceX.NET/'){
			FromCurrency('PHP')
			ToCurrency('USD')
		}
	}
}
println response.ConversionRateResponse.ConversionRateResult