import java.io.IOException;
import java.net.MalformedURLException;
public class Pricing {
	// PRICING IS ACTUALLY USED JUST FOR DISTANCE CALCULATION
	double getDistance(String Starting,String Destination) throws MalformedURLException, IOException {	
		Geocode sample=new Geocode();
        String lat1 = sample.getLat(Starting);
        String lon1 = sample.getLon(Starting);
        String lat2 = sample.getLat(Destination);
        String lon2 = sample.getLon(Destination);
        double d = 0;
    	     
        int flag=0;
        if(lat1=="error 404"||lat2=="error 404") {flag=1; d=10.0;}  // IF LOCATION CANNOT BE GEOCODED, DIS IS 10 km
        if(flag==0) {
        DistanceCord obj = new DistanceCord();
        d=obj.getDist(lat1,lon1,lat2,lon2);	
        }
        return d ;
	}	
}
