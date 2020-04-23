import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class PricingServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("CRASH IN PRICING SERVLET");
  
        HttpSession session=request.getSession();
        String username = (String)session.getAttribute("User");
        String pickuppoint = (String) request.getAttribute("pickuppoint");
        String destination= (String) request.getAttribute("destination");
        String parcelsize = (String) request.getAttribute("parcelsize");
        int minutes = (int) request.getAttribute("minutes");
        String discount="";
        out.print("CRASH IN PRICING SERVLET JUST BEFORE FINDING DISTANCE");
        Pricing pobj = new Pricing();
        double distance=0;
        while(distance==0) {
        distance = pobj.getDistance(pickuppoint,destination); } // Use DistanceMatrix / Google (or) LocationIQ Geocoders 
        int price = (int) Math.floor(distance*10.0);   // 10 RUPEES EACH KM
        out.print("CRASH IN PRICING SERVLET JUST AFTER FINDING DISTANCE");
        if(parcelsize.equals("medium")) {price=price+10;} // ADDITIONAL 10 FOR MEDIUM
        if(parcelsize.equals("large")) {price=price+20;} //  ADDITIONAL 20 FOR LARGE

        if((minutes>45)&&(minutes<60)) {
        discount="20% Applied (Regular Basis)"; // DISCOUNT APPLIES
        price=(int)Math.floor(price*0.8);}  
        else {discount="Not Applied (Occasional Basis)";}  // NO DISCOUNT
         
        
 try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/quickfood","root","vinay123");
            String query = "UPDATE bookings SET price = ?,discount=? WHERE username = ? ";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,price);
            ps.setString(2,discount);
            ps.setString(3,username);
            int i = ps.executeUpdate();
            ps.close();            
            if(i > 0) {
                request.setAttribute("price",price);
                request.setAttribute("discount",discount);  
                session.setAttribute("destination",destination);
                request.getRequestDispatcher("/confirmbook.jsp").forward(request, response); // Confirm Booking Page
            }   
        }
        catch(Exception se) {
            se.printStackTrace();
        }
    }    
}