import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class CheckOrderAcceptedServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String username=(String)session.getAttribute("User");
        String orderstatus;
       
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/quickfood","root","vinay123");
            String query = "Select * from bookings WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()==false) {request.getRequestDispatcher("index.jsp").forward(request, response);}
            else{
            	do{
            orderstatus=rs.getString(9);
            if(orderstatus.contains("confirmed")) {
            	request.getRequestDispatcher("lookingforagent.jsp").forward(request, response);
            }
            else if(orderstatus.contains("accepted")) {
            	request.getRequestDispatcher("/OrderAcceptedServlet").forward(request, response);
            }
            else if(orderstatus.contains("declined")) {
            	request.getRequestDispatcher("orderdeclined.jsp").forward(request, response);
            }
            else if(orderstatus==null) {
            	request.getRequestDispatcher("index.jsp").forward(request, response);
            }         
            }while(rs.next());
        }
        }
        catch(Exception se1) {
        	se1.printStackTrace();
        } 
        
        
}
}