import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MailServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();
        
        String to = (String)session.getAttribute("usermail");
        String subject = "QuickFood Booking Confirmation";
        out.print(to);
        
        
        String message = "Hello "+(String)session.getAttribute("username")+".\nYour booking has been confirmed."
        		+ "\nOur Delivery Agent "+ (String)session.getAttribute("Agent") +" will arrive soon.\n"+
        		"YOUR BOOKING DETAILS : \n"+
        		"\nBooking ID : "+ (String)session.getAttribute("bookingid") +
        		"\nPickup Point : "+ (String)session.getAttribute("pickuppoint") +
        		"\nDelivery Point : "+ (String)session.getAttribute("destination") +
        		"\nRecipient Name : "+ (String)session.getAttribute("recipientname") +
        		"\nRecipient Number :"+ (String)session.getAttribute("recipientnumber") +
        		"\nAmount To be Paid : "+Integer.toString((int)session.getAttribute("price"))+
        		"\nTHANK YOU FOR USING QUICKFOOD";
        
        out.print(to);
        
        String user = "f20160646@hyderabad.bits-pilani.ac.in"; 
        String pass = "09542342414";
        SendMail.send(to,subject, message, user, pass);
        out.println("Mail sent successfully");
      
        request.getRequestDispatcher("acceptedbooking.jsp").forward(request, response);
    }   
}