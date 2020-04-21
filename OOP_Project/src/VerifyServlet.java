import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class VerifyServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("User"); 
    
        try
        { 	
         if(Validate.checkUser(username, password,"user"))
        {
            RequestDispatcher rs = request.getRequestDispatcher("settings.jsp");
            rs.forward(request, response);
        }
        
         
        else
        {
           out.println("<center><b>Password incorrect</b></center>");
           RequestDispatcher rs = request.getRequestDispatcher("askforpwd.jsp");
           rs.include(request, response);
        }
         
      }
    catch(IOException e1) {
       e1.printStackTrace();
    	}
    catch(Exception e2) {
    	e2.printStackTrace();
    	}
    }  
}