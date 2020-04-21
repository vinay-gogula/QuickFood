import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class CheckBookingServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("CRASH IN CHECK BOOKING SERVLET");
        HttpSession session = request.getSession();
        String lat = (String)request.getParameter("latitude");
    	String lon = (String)request.getParameter("longitude");
    	if(lat!=null&&lon!=null){
        session.setAttribute("lat", lat);
        session.setAttribute("lon", lon);}
        String temp=(String)session.getAttribute("orderstatus");
        String rad = (String)request.getParameter("rad");
        if(rad!=null){session.setAttribute("radius", rad);}
        if (temp=="accepted"||temp=="collected"||temp=="ontheway") {
        	request.getRequestDispatcher("acceptedbooking.jsp").forward(request, response);
        }
        
        String bookingid;
        String pickuppoint;
        String destination;
        String username;
        String recipientname;
        String recipientnumber;
        String parcelsize;
        int price;
        String orderstatus="confirmed";
        String ordertime;
       
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/quickfood","root","vinay123");
            String query = "Select * from bookings WHERE orderstatus = ? ORDER BY bookingid DESC LIMIT 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,orderstatus);
            ResultSet rs = ps.executeQuery();
            if(rs.next()== false) {request.getRequestDispatcher("agenthome.jsp").forward(request, response);}
            else {
            do {
            bookingid=rs.getString(1);
            username=rs.getString(2); // USER WANTS TO REMAIN ANYONYMOUS
            pickuppoint=rs.getString(3);
            destination=rs.getString(4);
            recipientname=rs.getString(5);
            recipientnumber=rs.getString(6);
            parcelsize=rs.getString(7);
            price=rs.getInt(8);
            ordertime=rs.getString(12);
            int nearby=0;  // set as 1 if nearby
            
            /////////////////////////////////////////////
             out.print("CRASH IN CHECK BOOKING SERVLET BEFORE CALCULATION DISTANCE");
             String lat2=(String)session.getAttribute("lat");
             String lon2=(String)session.getAttribute("lon");
             String r1 = (String)session.getAttribute("radius");
             String r2 = r1.replaceAll("[^0-9]", "");
             int r = Integer.parseInt(r2);
             Geocode a = new Geocode();
             String lat1 = a.getLat(pickuppoint);
             String lon1 = a.getLon(pickuppoint);
             if(lat1=="error 404"||lon1=="error 404"){nearby=1;}
             if(nearby==0) {
             DistanceCord obj = new DistanceCord();
             double d =obj.getDist(lat1,lon1,lat2,lon2);
             if(nearby==0){ if(d<=r){nearby=1;}}
             }
             out.print("CRASH IN CHECK BOOKING SERVLET AFTER CALCULATION DISTANCE");
            ////////////////////////////////////////////
           
            session.setAttribute("bookingid",bookingid);
            session.setAttribute("username", username);
            session.setAttribute("pickuppoint",pickuppoint);
            session.setAttribute("destination",destination);
            session.setAttribute("recipientname",recipientname);
            session.setAttribute("recipientnumber",recipientnumber);
            session.setAttribute("parcelsize",parcelsize);
            session.setAttribute("price",price);
            session.setAttribute("ordertime",ordertime);
            
            if(nearby==1) {
            request.getRequestDispatcher("bookingsnearby.jsp").forward(request, response);}
           
            else {
                request.getRequestDispatcher("agenthome.jsp").forward(request, response);}
               
        } while(rs.next());
          }
            }
        catch(Exception se1) {
        	se1.printStackTrace();
        } 
        
}
}