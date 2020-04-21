<html>
 <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>QuickFood</title>
    <link rel="stylesheet" href="styles.css" type="text/css" />
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
 <body>
<div id="container">
<header>
<h1><a href='login.jsp'>Quick<span>Food</span></a></h1>
<h2>Homemade Food.Quick Deliveries.</h2>
<div class='panelHeader'>
<b>One Step Away From Your First Booking</b>
</div>
<center><h3><b>Registration Page</b></h3>
</header>
    <form id='register' action='/OOP_Project/RegisterServlet' method='post' accept-charset='UTF-8'>
         <table cellpadding='2' cellspacing='1'>
    <tr>
        <td><b>FULL NAME</b></td>
        <td><input required type="TEXT" name="name" id='name' maxlength="25" /></input></td>
    </tr>
    <tr>
        <td><b>USERNAME</b></td>
        <td><input required type="TEXT" size="20" name="username"></input></td>
    </tr>
    <tr>
        <td><b>PASSWORD</b></td>
        <td><input required type="PASSWORD" size="20" name="password"/></td>
    </tr>
     <tr>
        <td><b>PHONE NUMBER</b></td>
        <td><input required type="tel" size="20" name="phonenumber" pattern="[0-9]{10}"/></td>
    </tr>
    
     <tr>
        <td><b>DEFAULT LOCATION</b></td>
        <td><input type="text" size="20" placeholder="Optional Field" name="defaultlocation"/></td>
    </tr>
   
    <tr>
        <td><b>EMAIL ID</b></td>
        <td><input required type="email" size="20" name="emailid"/></td>
    </tr>
    <tr>
        <td><b>ROLE</b></td>
        <td>
        <select name="role">
		<option value="user">User</option>
		<option value="agent">Delivery Agent</option>
		</select>
        </td>
        </tr>
    <tr>
        <td colspan='2'>
            <center><input type="submit" class="w3-btn w3-green w3-round-xxlarge w3-xlarge" value="Register" /></center>
        </td>
    </tr>
 </table>
</form>
<center><a href="login.jsp" class="w3-btn w3-orange w3-round-xxlarge w3-large" >Already have an Account? Sign In</a></center>
</div>
 </body>
</html>