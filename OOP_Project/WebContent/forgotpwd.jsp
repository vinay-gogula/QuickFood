<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quick Food</title>
<link rel="stylesheet" href="styles.css" type="text/css" />
<link rel="stylesheet" href="socialmedia.css" type="text/css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head><body>
<div id="container">
<header>
<h1><a href='login.jsp'>Quick<span>Food</span></a></h1> 
<h2>Homemade Food.Quick Deliveries.</h2>
<div class='panelHeader'> 
<center><b>Forgot Password or Username</b></center>
</div>
</header>
  <form method="post" action="/OOP_Project/ForgotServlet">
	<tr> <td><b><h3> Mail ID : </h3></b></td><td><input required type="email" size="20" name="emailid"></td></tr>
	<br></br>
	<tr><td><input type="submit" class="w3-btn w3-red w3-round-xxlarge w3-xlarge" name="submit" value="Send Account Details To My Mail"></td>
      </div>
  </form>
    </div>
</body>
</html>