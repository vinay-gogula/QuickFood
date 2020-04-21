import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class UpdateLocationServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String lat = (String)request.getParameter("latitude");
    	String lon = (String)request.getParameter("longitude");
    	if(lat==null||lon==null) {request.getRequestDispatcher("acceptedbooking.jsp").forward(request, response);}
    	String username=(String)session.getAttribute("username");
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/quickfood","root","vinay123");
            String query = "UPDATE bookings SET lat=?,lon=? WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,lat);
            ps.setString(2,lon);
            ps.setString(3,username);
            int i=ps.executeUpdate();
            out.print(lat);
            ps.close();
            if(i>0) {
            	request.getRequestDispatcher("CheckBookingServlet").forward(request, response); 
            }
            else {request.getRequestDispatcher("CheckBookingServlet").forward(request, response);}      
        }
        catch(Exception se1) {
        	se1.printStackTrace();
        } 
}
}