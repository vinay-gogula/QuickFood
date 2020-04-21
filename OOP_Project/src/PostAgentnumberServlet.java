import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


public class PostAgentnumberServlet extends HttpServlet {
	 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        

        HttpSession session = request.getSession();
        String username=(String)session.getAttribute("username");
        String agentname=(String)session.getAttribute("Agent");
      
        
        String usernumber=" ";
        String usermail=" ";
        String agentnumber=" ";
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/quickfood","root","vinay123");
            String query = "Select * from users WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()== false) {request.getRequestDispatcher("agenthome.jsp").forward(request, response);} // means invalid username
            else {
            do {
            usernumber=rs.getString(4); // got user's number
            usermail=rs.getString(5);  // user's mail      
               } while(rs.next());
          } 
            
            query="Select * from users where username=?";
            ps = con.prepareStatement(query);
            ps.setString(1,agentname);
            rs = ps.executeQuery();
            if(rs.next()== false) {request.getRequestDispatcher("agenthome.jsp").forward(request, response);} 
            else {
            do {
                agentnumber=rs.getString(4); // got agent's number
               } while(rs.next());
          }
            
            query="UPDATE bookings SET agentnumber=?  WHERE username = ?";
            ps = con.prepareStatement(query);
            ps.setString(1,agentnumber);
            ps.setString(2,username);
            int i=ps.executeUpdate();
            if(i>0) {
                session.setAttribute("usernumber", usernumber);
                session.setAttribute("usermail", usermail);
            	request.getRequestDispatcher("MailServlet").forward(request, response);} 
            else { request.getRequestDispatcher("agenthome.jsp").forward(request, response); } 
            
            }
        catch(Exception se1) {
        	se1.printStackTrace();
        } 
        
}
}