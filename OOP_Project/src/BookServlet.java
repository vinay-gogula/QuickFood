import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class BookServlet extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("CRASHED IN BOOK SERVELT");
        String pickuppoint = request.getParameter("pickuppoint");
        if(pickuppoint==null) {pickuppoint="Medavakkam, Chennai, Tamil Nadu";} // HardCoded Default Location
        String destination= request.getParameter("destination");
        String recipientname = request.getParameter("recipientname");
        String recipientnumber = request.getParameter("recipientnumber");
        String parcelsize = request.getParameter("parcelsize");
        HttpSession session=request.getSession();
        String username = (String)session.getAttribute("User");
        java.util.Date date = new java.util.Date();
		@SuppressWarnings("deprecation")
		int minutes = date.getMinutes();
        String ordertime= date.toString();        
        
 try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/quickfood","root","vinay123");
            String query = "insert into bookings(username,pickuppoint,destination,recipientname,recipientnumber,parcelsize,ordertime) values (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, pickuppoint);
            ps.setString(3, destination);
            ps.setString(4, recipientname);
            ps.setString(5, recipientnumber);
            ps.setString(6, parcelsize);
            ps.setString(7,ordertime);
            int i = ps.executeUpdate();
            ps.close();
            if(i > 0) {
            	request.setAttribute("pickuppoint",pickuppoint);
                request.setAttribute("destination",destination);
                request.setAttribute("recipientname",recipientname);
                request.setAttribute("recipientnumber",recipientnumber);
                request.setAttribute("parcelsize",parcelsize);
                request.setAttribute("minutes",minutes);
                request.getRequestDispatcher("/PricingServlet").forward(request, response); // display a confirm booking page
            }
        }
        catch(Exception se) {
            se.printStackTrace();
        }  
    }   
}
