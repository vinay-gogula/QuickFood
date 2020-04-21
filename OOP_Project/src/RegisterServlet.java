import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
        String name = request.getParameter("name");
        String username= request.getParameter("username");
        String password = request.getParameter("password");
        String phonenumber = request.getParameter("phonenumber");
        String emailid = request.getParameter("emailid");
        String role = request.getParameter("role"); 
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/quickfood","root","vinay123");
            String query = "Select * from users WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()== false) {  } 
            else {
            do {
            	request.getRequestDispatcher("newusername.jsp").forward(request, response);
            } while(rs.next());
          } 
                
            query = "insert into users(name,username,password,phonenumber,email,role) values (?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, phonenumber);
            ps.setString(5, emailid);
            ps.setString(6, role);
            int i = ps.executeUpdate();
            if(i > 0) {
                request.getRequestDispatcher("/regsuccess.jsp").forward(request, response); 
            }
            else {request.getRequestDispatcher("/register.jsp").forward(request, response);}
        }
        catch(Exception se) {
            se.printStackTrace();
        }
 
    }
  
}