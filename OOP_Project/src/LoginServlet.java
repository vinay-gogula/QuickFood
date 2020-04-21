import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class LoginServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
             
        String gmailname = (String)request.getAttribute("username");
        String gmailpwd = (String) request.getAttribute("password");
        
        try
        {
        	if(Validate.checkUser(gmailname,gmailpwd,"user"))
            {
                System.out.println("USER HOME");
                HttpSession session = request.getSession();
                session.setAttribute("User",gmailname); // might have error 
                request.setAttribute("UserName",gmailname);// might have error
                RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
                rs.forward(request, response);
            }
 
        	
        	
         if(Validate.checkUser(username, password,"user"))
        {
            System.out.println("USER HOME");
            HttpSession session = request.getSession();
            session.setAttribute("User",username); // might have error 
            request.setAttribute("UserName",username);// might have error
            RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
            rs.forward(request, response);
        }
         
         else if(Validate.checkUser(username,password,"agent"))
         {
        	 System.out.println("DELIVERY AGENT HOME");
        	 HttpSession session = request.getSession();
        	 session.setAttribute("Agent", username);
        	 session.setAttribute("radius", "10 KMs");
        	 session.setAttribute("lat", "12.9179683");
             session.setAttribute("lon", "80.18768");
             request.setAttribute("UserName",username);
             RequestDispatcher rs = request.getRequestDispatcher("agenthome.jsp");
             rs.forward(request, response);
         }
         
        else
        {
           out.println("<center><b>Username or Password incorrect</b></center>");
           RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
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