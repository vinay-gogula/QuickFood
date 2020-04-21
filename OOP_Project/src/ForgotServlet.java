import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ForgotServlet extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String usermail = request.getParameter("emailid");
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/quickfood","root","vinay123");
            String query = "select * from users where email = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, usermail);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	String name=rs.getString(1);
                String username=rs.getString(2);
                String password=rs.getString(3);
                String phonenumber=rs.getString(4);
                String subject = "QuickFood Account Recovery";
                String message = "Hey "+name+"\nYOUR ACCOUNT DETAILS :"
                		+"\nUsername :"+username+"\nPassword :"+password+"\nPhone Number :"+phonenumber+
                		"\nThank You For Using QuickFood"; 
                String user = "f20160646@hyderabad.bits-pilani.ac.in"; 
                String pass = "09542342414";
                SendMail.send(usermail,subject, message, user, pass);
                out.println("Mail sent successfully");  
                request.getRequestDispatcher("mailsent.jsp").forward(request, response);
            
                
                
            }
        }
        catch(Exception se1) {
        	se1.printStackTrace();
        } 
}
}