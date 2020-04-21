import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
	
public class Geocode {

	    
	    String getLat(String address)
	            throws MalformedURLException, IOException {
	         
	    	String urlString="https://us1.locationiq.org/v1/search.php?&key=fc7b144b4705e7"+"&q="+address+"&format=json&countrycodes=IN";
	    	if(urlString.contains(" ")) urlString = urlString.replace(" ", "%20");
	    	URL url = new URL(urlString);
	        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
	        if(urlConnection.getResponseCode()>400) {return "error 404";} // NOT JUST 404 , ANY ERROR RESPONSE
	        String lat = "";
	 
	        try {
	            InputStream in = url.openStream();
	            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	            String result, line = reader.readLine();
	            result = line;
	            while ((line = reader.readLine()) != null) {
	                result += line;
	            }
	            reader.close();
	            JSONParser parser = new JSONParser();
	            JSONArray data = (JSONArray)parser.parse(result);  // ONLY CHANGE THESE 3 LINES IF YOU ARE USING OTHER GEOCODERS
	            JSONObject first = (JSONObject) data.get(0);
	            lat = (String)first.get("lat");
	        }
	        catch (org.json.simple.parser.ParseException e) {
	             e.printStackTrace();
	        }
	        urlConnection.disconnect();
            return lat;	       
	    }
        
	    String getLon(String address)
	            throws MalformedURLException, IOException {
	         
	    	String urlString="https://us1.locationiq.org/v1/search.php?&key=fc7b144b4705e7"+"&q="+address+"&format=json&countrycodes=IN";
	    	if(urlString.contains(" ")) urlString = urlString.replace(" ", "%20");
	    	URL url = new URL(urlString);
	        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
	        if(urlConnection.getResponseCode()>400) {return "error 404";}  // NOT JUST 404 , ANY ERROR RESPONSE
	        String lat = "";
	 
	        try {
	            InputStream in = url.openStream();
	            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	            String result, line = reader.readLine();
	            result = line;
	            while ((line = reader.readLine()) != null) {
	                result += line;
	            }
	            reader.close();
	            JSONParser parser = new JSONParser();
	            JSONArray data = (JSONArray)parser.parse(result); // ONLY CHANGE THESE 3 LINES IF YOU ARE USING OTHER GEOCODERS
	            JSONObject first = (JSONObject) data.get(0);
	            lat = (String)first.get("lon");
	        }
	        catch (org.json.simple.parser.ParseException e) {
	             e.printStackTrace();
	        }	        
	        urlConnection.disconnect();
            return lat;	       
	    }
 
	    String getAdd(String address)
	            throws MalformedURLException, IOException {
	         
	    	String urlString="https://us1.locationiq.org/v1/search.php?&key=fc7b144b4705e7"+"&q="+address+"&format=json&countrycodes=IN";
	    	if(urlString.contains(" ")) urlString = urlString.replace(" ", "%20");
	    	URL url = new URL(urlString);
	        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
	        if(urlConnection.getResponseCode()>400) {return "error 404";}   // NOT JUST 404 , ANY ERROR RESPONSE 
	        String lat = "";
	 
	        try {
	            InputStream in = url.openStream();
	            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	            String result, line = reader.readLine();
	            result = line;
	            while ((line = reader.readLine()) != null) {
	                result += line;
	            }
	            reader.close();
	            JSONParser parser = new JSONParser();
	            JSONArray data = (JSONArray)parser.parse(result); // ONLY CHANGE THESE 3 LINES IF YOU ARE USING OTHER GEOCODERS
	            JSONObject first = (JSONObject) data.get(0);
	            lat = (String)first.get("display_name");
	        }
	        catch (org.json.simple.parser.ParseException e) {
	             e.printStackTrace();
	        }	        
	        urlConnection.disconnect();
            return lat;	       
	    }
}
