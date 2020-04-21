import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DeclineServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String orderstatus = "declined";
        HttpSession session = request.getSession();
        String username=(String)session.getAttribute("username");
        out.print(username+"hello");
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/quickfood","root","vinay123");
            String query = "UPDATE bookings SET orderstatus=?  WHERE username = ? ";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,orderstatus);
            ps.setString(2,username);
            int i=ps.executeUpdate();
            ps.close();
            if(i>0) {
            	request.getRequestDispatcher("agenthome.jsp").forward(request, response);
            }
            else {request.getRequestDispatcher("agenthome.jsp").forward(request, response);}
        }
        catch(Exception se1) {
        	se1.printStackTrace();
        } 
}
}