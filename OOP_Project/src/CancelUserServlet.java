import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class CancelUserServlet extends HttpServlet {
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String username=(String)session.getAttribute("User");
       
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/quickfood","root","vinay123");
            String query = "DELETE from bookings WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,username);
            int i=ps.executeUpdate();
            ps.close();
            if(i>0) {
            	request.getRequestDispatcher("canceluserorder.jsp").forward(request, response);
            }
            else {
            	request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
        catch(Exception se1) {
        	se1.printStackTrace();
        } 
}
}