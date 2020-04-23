import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


public class CheckDirections extends HttpServlet {
	 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        try {
        	String url = "http://maps.google.com/maps?saddr="+(String)session.getAttribute("pickuppoint")+"&daddr="+(String)session.getAttribute("destination");
            response.sendRedirect(url);
            }            
 catch(Exception se1) {se1.printStackTrace();}        
}
}