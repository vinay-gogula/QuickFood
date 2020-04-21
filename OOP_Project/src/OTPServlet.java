import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
 
public class OTPServlet {
	
	public static String sendSms(String rname,String rnum,String OTP ) {
		try {
			// Construct data
			String apiKey = "apikey=" + "8m3pBzt0SGI-0wRQ0ncONqTuD6caTDx6H29Vbeh2Bt";
			String message = "&message=" + "Hello "+ rname +"\n You will recieve your Food Soon. \nYour OTP for delivery is "+ 
	    	OTP +". \nThank You For Using QuickFood.";;
			String sender = "&sender=" + "TXTLCL";
		    String numbers = "&numbers=" + rnum;
			
		    // Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
}