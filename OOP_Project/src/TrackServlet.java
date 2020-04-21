import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


public class TrackServlet extends HttpServlet {
	 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String username=(String)session.getAttribute("User");      
        String lat,lon;
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/quickfood","root","vinay123");
            String query = "Select * from BOOKINGS WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()== false) {request.getRequestDispatcher("orderaccepted.jsp").forward(request, response);} // means invalid username
            else {
            do {
            lat=rs.getString(15);
            lon=rs.getString(16);
            double lt = Double.parseDouble(lat);
            double ln = Double.parseDouble(lon);
            request.setAttribute("latitude", lt);
            request.setAttribute("longitude", ln);
            request.getRequestDispatcher("trackagent.jsp").forward(request, response);
               } while(rs.next());
            }
        }            
 catch(Exception se1) {se1.printStackTrace();}        
}
}