@Grab('com.github.groovy-wslite:groovy-wslite:1.1.2')
import wslite.rest.*

def location = "1600+Amphitheatre+Parkway,+Mountain+View,+CA"


def client = new RESTClient('https://maps.googleapis.com/')
def getResponse = client.get(path:'/maps/api/geocode/json', query:[address: location, sensor:'false'])

println getResponse.text

try {
	def postResponse = client.post (path: 'maps/api/geocode', body:[address: 'Magalang', sensor:'false'])
	println postResponse.getData()
} catch (Exception e) {
	println "Error at POST method of REST"
	e.printStackTrace()
}


//https://maps.googleapis.com/maps/api/distancematrix/json?origins=Magalang&destinations=SM Tarlac&mode=driving