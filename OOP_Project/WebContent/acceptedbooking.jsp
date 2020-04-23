<html>
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

 <body>
<div id="container">
<header>
<h1><a href='agenthome.jsp'>Quick<span>Food</span></a></h1>
<h2>Homemade Food.Quick Deliveries.</h2>
<div class="panelHeader">
<b> Hey <%=session.getAttribute("Agent") %>. </b>
</header>

<br>
<center><a href="<%=request.getContextPath()%>/CheckDirections" target="_blank" class="w3-button w3-purple w3-large ">Check Directions</a></center>

<table>
<center><h3><b>Current Task</b></h3></center>
<center><h4><b>Order Status : <%= session.getAttribute("orderstatus")%> </b></h4></center>
<tr>
<td> Booking ID : </td> 
<td><%= session.getAttribute("bookingid")%></tr>
</tr>
<tr>
<td> Customer Name : </td> 
<td><%= session.getAttribute("username")%></tr>
</tr>
<tr>
<tr>
<td> Customer Number : </td> 
<td><%= session.getAttribute("usernumber")%></tr>
</tr>
<td>Pickup Point : </td> 
<td><%= session.getAttribute("pickuppoint")%></tr>
</tr>
<tr>
<td>Delivery Point : </td> 
<td><%= session.getAttribute("destination")%></tr>
<tr>
<td>Order Placed At : </td> 
<td><%= session.getAttribute("ordertime")%></tr>
</tr>
<tr>
<td>Parcel Size : </td> 
<td><%= session.getAttribute("parcelsize")%></tr>
</tr>
<tr>
<td>Recipient Name : </td> 
<td><%= session.getAttribute("recipientname")%></tr>
</tr>
<tr>
<td>Recipient Number : </td> 
<td><%= session.getAttribute("recipientnumber")%></tr>
</tr>
<tr>
<td><b>One Time Password : </b></td> 
<td><%= session.getAttribute("otp")%></tr>
</tr>
<br>
</table>

	<tr>
		<span style="display:inline-block; width:150;"></span>
		
           <a href="<%=request.getContextPath()%>/CollectServlet" class="w3-button w3-blue w3-large ">Parcel Collected</a></center>
         
           <a href="<%=request.getContextPath()%>/OnthewayServlet" class="w3-button w3-orange w3-large ">Towards Destination</a></center>
          
             <a href="<%=request.getContextPath()%>/DeliveredServlet" class="w3-button w3-green w3-large ">Parcel Delivered</a></center>
  	   
    </tr>   
    <br>
<body onload="getLocation()">
<center><form id="loc" action="UpdateLocationServlet">
<input type="hidden" name="latitude" id="latitude" value="" />
<input type="hidden" name="longitude" id="longitude" value="" />
<input type=submit value="Update Location">
</form>
 <br>
 
 </table>
 </body>
</html>