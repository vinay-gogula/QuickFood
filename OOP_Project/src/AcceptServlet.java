import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.lang.Math;

public class AcceptServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String orderstatus = "accepted";
        HttpSession session = request.getSession();
        String username=(String)session.getAttribute("username");
        String agentname=(String)session.getAttribute("Agent");
        session.setAttribute("orderstatus",orderstatus);
        int otp=(int)(Math.random() * (9999 - 1000 + 1) + 1000);
        session.setAttribute("otp",otp);
        
        
        String rname=(String)session.getAttribute("recipientname");
    	String rnum=(String)session.getAttribute("recipientnumber");
    	String OTP =Integer.toString(otp);
        // String OTPStatus=OTPServlet.sendSms(rname,rnum,OTP); out.print(OTPStatus); // DISABLE WHEN YOU DON'T WANT TO SEND SMS
        
    	
    	try {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/quickfood","root","vinay123");
            String query = "UPDATE bookings SET orderstatus=?,agentusername=?,otp=?  WHERE username = ? ";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,orderstatus);
            ps.setString(2,agentname);
            ps.setInt(3, otp);
            ps.setString(4,username);
            int i=ps.executeUpdate();
            ps.close();
            if(i>0) {
            	request.getRequestDispatcher("/PostAgentnumberServlet").forward(request, response); 
            }
            else {request.getRequestDispatcher("agenthome.jsp").forward(request, response);} // probably means order was cancelled
        }
        catch(Exception se1) {
        	se1.printStackTrace();
        } 
}
}