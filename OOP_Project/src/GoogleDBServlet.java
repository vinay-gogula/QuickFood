import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet(urlPatterns = {"/login"})
public class GoogleDBServlet extends HttpServlet {
    @Override
    protected void service (HttpServletRequest req,
                        HttpServletResponse resp)
                        throws ServletException, IOException {

        resp.setContentType("text/html");

        try {
            String idToken = req.getParameter("id_token");
            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
            String name = (String) payLoad.get("name");
            String email = payLoad.getEmail();
            System.out.println("User name: " + name);
            System.out.println("User email: " + email);
            HttpSession session = req.getSession(true);
            session.setAttribute("User", name);
            
            req.setAttribute("User",name);
            req.setAttribute("account","google");
                    
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/quickfood","root","vinay123");
            String query = "insert ignore into users(name,username,password,phonenumber,email,role) values (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, name);
            ps.setString(3, "password");
            ps.setString(4, "9542342414"); // HARDCODED NUMBER
            ps.setString(5, email);
            ps.setString(6, "user");
            int i = ps.executeUpdate();
            if(i > 0) {
            		req.setAttribute("username",name);
                    req.setAttribute("password","B$2fsK!63");
            	req.getServletContext().getRequestDispatcher("/LoginServlet").forward(req, resp);
                }
            else {
            	req.setAttribute("username",name);
                req.setAttribute("password","password");
        	req.getServletContext().getRequestDispatcher("/LoginServlet").forward(req, resp);
            
            }
        

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
