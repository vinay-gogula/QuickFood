import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class OrderAcceptedServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String username=(String)session.getAttribute("User");
        
        int bookingid;
        String pickuppoint;
        String destination;
        String recipientname;
        String recipientnumber;
        String parcelsize;
        int price;
        String orderstatus;
        String agentusername;
        String agentnumber;
        int otp;
        String ordertime;
        String discount;
  
       
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/quickfood","root","vinay123");
            String query = "Select * from bookings WHERE username = ? ORDER BY bookingid DESC LIMIT 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()== false) {request.getRequestDispatcher("noprevorders.jsp").forward(request, response);}
            else {
            	do { 
            bookingid=rs.getInt(1);
            pickuppoint=rs.getString(3);
            destination=rs.getString(4);
            recipientname=rs.getString(5);
            recipientnumber=rs.getString(6);
            parcelsize=rs.getString(7);
            price=rs.getInt(8);
            orderstatus=rs.getString(9);
            agentusername=rs.getString(10);
            otp=rs.getInt(11);  
            ordertime=rs.getString(12);
            discount=rs.getString(13);
            agentnumber=rs.getString(14);
            
            /////////////////////////////////////////////
   
            request.setAttribute("bookingid",bookingid);     
            request.setAttribute("pickuppoint",pickuppoint);
            request.setAttribute("destination",destination);
            request.setAttribute("recipientname",recipientname);
            request.setAttribute("recipientnumber",recipientnumber);
            request.setAttribute("parcelsize",parcelsize);
            request.setAttribute("price",price);
            request.setAttribute("agentusername",agentusername);
            request.setAttribute("agentnumber",agentnumber);
            request.setAttribute("ordertime",ordertime);
           
            if(orderstatus.contains("accepted")) {
            request.setAttribute("status","Accepted");
            request.getRequestDispatcher("orderaccepted.jsp").forward(request, response);}
           
            else if(orderstatus.contains("collected")) {
                request.setAttribute("status","Collected");
                request.getRequestDispatcher("orderaccepted.jsp").forward(request, response);}
                
            else if(orderstatus.contains("ontheway")) {
                request.setAttribute("status","On The Way");
                request.getRequestDispatcher("orderaccepted.jsp").forward(request, response);}
                
            else if(orderstatus.contains("delivered")) {
                request.setAttribute("status","Delivered");
                request.getRequestDispatcher("delivered.jsp").forward(request, response);}
            
            else if(orderstatus.contains("declined")) {
                request.setAttribute("status","Cancelled. We Are Sorry");
                request.getRequestDispatcher("orderaccepted.jsp").forward(request, response);}
            
        } while(rs.next());
            }
            }
        catch(Exception se1) {
        	se1.printStackTrace();
        } 
        
        
}
}
