import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ChangeField extends HttpServlet {
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
        HttpSession session = request.getSession();
        String fieldval = request.getParameter("newfield");
        String field = (String) session.getAttribute("field"); 
        String username = (String) session.getAttribute("User");  
        out.print(username+" "+field+" "+fieldval+" ");
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/quickfood","root","vinay123");
            String query="";
            if(field.equals("Password")) {
            query = "UPDATE users SET password=? WHERE username = ? ";
            }
            else if(field.equals("Email")) {
            query = "UPDATE users SET email=? WHERE username = ? ";
                }
            else if(field.equals("PhoneNumber")) {
            query = "UPDATE users SET phonenumber=? WHERE username = ? ";
                }
            out.print(query);
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,fieldval);
            ps.setString(2,username);
            int i=ps.executeUpdate();
            ps.close();
            if(i>0) {
            	request.getRequestDispatcher("updatesuccess.jsp").forward(request, response); 
            }
            else {request.getRequestDispatcher("settings.jsp").forward(request, response);}         }
        catch(Exception se1) {
        	se1.printStackTrace();
        } 
}
}