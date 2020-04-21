<html>
 <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>QuickFood</title>
    <link rel="stylesheet" href="styles.css" type="text/css" />
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<% //In case, if Admin session is not set, redirect to Login page
if((request.getSession(false).getAttribute("User")== null))
{
%>
<jsp:forward page="login.jsp"></jsp:forward>
<%} %>

<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCyRxEm4H-7RM_Eg9la1M49GVsx1esdn2Q&sensor=false&libraries=places"></script>
    <script type="text/javascript">
        google.maps.event.addDomListener(window, 'load', function () {
            var places = new google.maps.places.Autocomplete(document.getElementById('txtPlaces1'));
            google.maps.event.addListener(places, 'place_changed', function () {
                var place = places.getPlace();
                var address = place.formatted_address;
                var latitude = place.geometry.location.A;
                var longitude = place.geometry.location.F;
            });
            var places = new google.maps.places.Autocomplete(document.getElementById('txtPlaces2'));
                    google.maps.event.addListener(places, 'place_changed', function () {
                        var place = places.getPlace();
                        var address = place.formatted_address;
                        var latitude = place.geometry.location.A;
                        var longitude = place.geometry.location.F;
                    });
        });
    </script>
    
 <body>
<div id="container">
<header>
<h1><a href='index.jsp'>Quick<span>Food</span></a></h1>
<h2>Homemade Food.Quick Deliveries.</h2>
<div class="panelHeader">
<b>Welcome <%=session.getAttribute("User") %> </b>
<div style="text-align: left"><a href="index.jsp" class="w3-button w3-teal w3-small" >Back</a></div>
<div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet" class="w3-button w3-teal w3-small" >Logout</a></div>
</div>
</header>
    <form id='booking' action='/OOP_Project/BookServlet' method='post'
    accept-charset='UTF-8'>
         <span style="color:red;">Note:</span> Please fill the details of your food parcel.</br></br>
         <table cellpadding='2'>
    <tr>
        <td><b>Pickup Point</b></td>
        <td><input required type='text' class="w3-input" id="txtPlaces1" size="60" name="pickuppoint" maxlength="100" /></input></td>
    </tr>
    <tr>
        <td><b>Delivery Point</b></td>
        <td><input required type="text" class="w3-input" id="txtPlaces2" size="60" name="destination" maxlength="100"></input></td>
    </tr>
    <tr>
        <td><b>Recipient Name</b></td>
        <td><input required type="text" class="w3-input" name="recipientname" maxlength="30"></input></td>
    </tr>
    <tr>
        <td><b>Recipient Number</b></td>
        <td><input required type="tel" class="w3-input" name="recipientnumber" maxlength="10" pattern="[0-9]{10}" ></input></td>
    </tr>
        <tr>
        <td><b>Food Parcel Size</b></td>
        <td>
        <select name="parcelsize" id='parcelsize'>
		<option value="small">Small (Less than 200g)</option>
		<option value="medium">Medium (200g to 500g)</option>
		<option value="large">Large (More than 500g)</option>
		</select>
        </td>
        </tr>
 
    <tr>
        <td colspan='2'>
            <center><input type="submit" class="w3-button w3-teal w3-large" name='book' value="Book" /></center>
        </td>
    </tr>
 </table>
</form>
</div>
 </body>
</html>