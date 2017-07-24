import wslite.soap.*

public class Calculator {
	def client = new SOAPClient('http://www.dneonline.com/calculator.asmx')
	
	public def getSum(int a, int b){
		def response = client.send(SOAPAction:'http://tempuri.org/Add'){
			body{
				Add('xmlns':'http://tempuri.org/'){
					intA(a)
					intB(b)
				}
			}
		}
		return response.AddResponse.AddResult
	}
	public def getDifference(int a, int b){
		def response = client.send(SOAPAction:'http://tempuri.org/Subtract'){
			body{
				Subtract('xmlns':'http://tempuri.org/'){
					intA(a)
					intB(b)
				}
			}
		}
		return response.SubtractResponse.SubtractResult
	}
	public def getProduct(int a, int b){
		def response = client.send(SOAPAction:'http://tempuri.org/Multiply'){
			body{
				Multiply('xmlns':'http://tempuri.org/'){
					intA(a)
					intB(b)
				}
			}
		}
		return response.MultiplyResponse.MultiplyResult
	}
	public def getQuotient(int a, int b){
		def response = client.send(SOAPAction:'http://tempuri.org/Divide'){
			body{
				Divide('xmlns':'http://tempuri.org/'){
					intA(a)
					intB(b)
				}
			}
		}
		return response.DivideResponse.DivideResult
	}
}