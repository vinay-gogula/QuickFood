<html>
<meta http-equiv="refresh" content="3;url=<%=request.getContextPath()%>/CheckBookingServlet" />
 <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>QuickFood</title>
    <link rel="stylesheet" href="styles.css" type="text/css" />
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<% //In case, if Admin session is not set, redirect to Login page
if((request.getSession(false).getAttribute("Agent")== null))
{
%>
<jsp:forward page="login.jsp"></jsp:forward>
<%} %>

<script>
var x = document.getElementById("demo");

function getLocation() {
  if (navigator.geolocation) {
    navigator.geolocation.watchPosition(showPosition);
  } else { 
    x.innerHTML = "Geolocation is not supported by this browser.";
  }
}
    
function showPosition(position) {
	lat=position.coords.latitude;
	lon=position.coords.longitude;
    document.getElementById('latitude').value = lat;
    document.getElementById('longitude').value = lon;
	document.getElementById("use").innerHTML = "Latitude: " + lat + "<br>Longitude: " + lon;
}


function showError(error) {
	  switch(error.code) {
	    case error.PERMISSION_DENIED:
	      x.innerHTML = "User denied the request for Geolocation."
	      break;
	    case error.POSITION_UNAVAILABLE:
	      x.innerHTML = "Location information is unavailable."
	      break;
	    case error.TIMEOUT:
	      x.innerHTML = "The request to get user location timed out."
	      break;
	    case error.UNKNOWN_ERROR:
	      x.innerHTML = "An unknown error occurred."
	      break;
	  }
	}
</script>

<body onload="getLocation()">
<div id="container">
<header>
<h1><a href='agenthome.jsp'>Quick<span>Food</span></a></h1>
<h2>Homemade Food.Quick Deliveries.</h2>
<div class="panelHeader">
<b> AGENT HOME PAGE </b>
<div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet" class="w3-button w3-teal w3-small" >Logout</a></div>
</div>
</header>
<table>
<center><h2>Hey <b> <%=session.getAttribute("Agent") %></b></h2>
<br>
<center><h3><b>  There Are Currently No Bookings Nearby You</b></h3>
<br>
<center><h3>Current Booking Radius : <b><%=session.getAttribute("radius")%></b></h3>

           <a href="<%=request.getContextPath()%>/CheckBookingServlet?rad=5 KMs" class="w3-button w3-teal w3-large ">5 KMs</a>
         
           <a href="<%=request.getContextPath()%>/CheckBookingServlet?rad=10 KMs" class="w3-button w3-teal w3-large ">10 KMs</a>
          
            <a href="<%=request.getContextPath()%>/CheckBookingServlet?rad=15 KMs" class="w3-button w3-teal w3-large ">15 KMs</a>   
<br></br>
<p id="use"></p>
<form id="loc" action="CheckBookingServlet">
<input type="hidden" name="latitude" id="latitude" value="" />
<input type="hidden" name="longitude" id="longitude" value="" />
<input type=submit value="Update Location">
</form>
<br></br>
</table>
 </body>
</html>