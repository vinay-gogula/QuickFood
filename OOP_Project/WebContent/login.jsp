<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id" content="743797968780-277k01sfp05ra70rf8uehgh7ee36dqog.apps.googleusercontent.com">

<title>Quick Food</title>
<link rel="stylesheet" href="styles.css" type="text/css" />
<link rel="stylesheet" href="socialmedia.css" type="text/css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head><body>
<div id="container">
<header>
<h1><a href='login.jsp'>Quick<span>Food</span></a></h1> 
<h2>Homemade Food.Quick Deliveries.</h2>
<div class='panelHeader'> 
<b>Get Food Delivered</b>
</div>
</header>
<div class="container">
  <form method="post" action="/OOP_Project/LoginServlet">
    <div class="row">
      <h2 style="text-align:center">Login with Social Media or Manually</h2>
      <div class="vl">  
      </div>
      <div class="col">
      <div class="g-signin2" onclick="ClickLogin()" data-width="370" data-height="50" data-theme="dark"  data-onsuccess="onSignIn">
      </div>
             
       <script>
       var clicked=false;//Global Variable
       function ClickLogin()
       {
           clicked=true;
       }
      function onSignIn(googleUser) {
    	  if (clicked){
         var profile = googleUser.getBasicProfile();
         console.log('ID: ' + profile.getId());
         console.log('Name: ' + profile.getName());
         console.log('Image URL: ' + profile.getImageUrl());
         console.log('Email: ' + profile.getEmail());
         console.log('id_token: ' + googleUser.getAuthResponse().id_token);
         var redirectUrl = 'login';
         var form = $('<form action="' + redirectUrl + '" method="post">' +
                          '<input type="text" name="id_token" value="' +
                           googleUser.getAuthResponse().id_token + '" />' +
                                                                '</form>');
         $('body').append(form);
         form.submit();
      }
      };
   </script>
           <br>  
        <a href="#" class="fb btn">
          <i class="fa fa-facebook fa-fw" ></i> Login with Facebook
        </a>
      </div>
      
      <div class="col">
        <div class="hide-md-lg">
          <p>Or sign in manually:</p>
        </div>

      <tr> <td><b> Username  </b></td><td><input type="text" name="username"></td></tr>
	<tr> <td><b> Password  </b></td><td><input type="password" name="password"></td></tr>
	<br></br>
	<tr><td><input type="submit" class="w3-btn w3-red w3-round-xxlarge w3-large" name="submit" value="Sign In"></td>
	<a href="forgotpwd.jsp" style="color:black" class="btn">Forgot Password or Username</a>
      </div>
    </div>
  </form>
</div>
<div class="bottom-container">
      <a href="register.jsp" style="color:white" class="btn">Register</a>
    </div>
    </div>
</body>
</html>