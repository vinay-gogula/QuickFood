<!DOCTYPE html>
<meta http-equiv="refresh" content="10;url=<%=request.getContextPath()%>/TrackServlet" />
<html lang="en">
<head>
<meta charset="UTF-8">
<title>AGENT TRACKER</title>
<script src="http://maps.google.com/maps/api/js?key=AIzaSyCyRxEm4H-7RM_Eg9la1M49GVsx1esdn2Q"></script>
<%double lat = (double)request.getAttribute("latitude");%>
<%double lon =(double)request.getAttribute("longitude");%>
<script type="text/javascript">
function showPosition(){
    if(navigator.geolocation){
        navigator.geolocation.watchPosition(showMap, showError);
    } else{
        alert("Sorry, your browser does not support HTML5 geolocation.");
    }
}
  
// Define callback function for successful attempt
function showMap(position){
	
	var lat = <%=lat%>;
    var lon = <%=lon%>;
	var latlong = new google.maps.LatLng(lat,lon);
     
    var myOptions = {
        center: latlong,
        zoom: 16,
        mapTypeControl: true,
        navigationControlOptions: {style:google.maps.NavigationControlStyle.SMALL}
    }
     
    var map = new google.maps.Map(document.getElementById("embedMap"), myOptions);
    var marker = new google.maps.Marker({position:latlong, map:map, title:"You are here!"});
}
  
// Define callback function for failed attempt
function showError(error){
 
   var err = document.getElementById('embedMap');
        switch(error.code) {
        case error.PERMISSION_DENIED:
        err.innerHTML = "User denied the request for Geolocation."
        break;
        case error.POSITION_UNAVAILABLE:
        err.innerHTML = "Location information is unavailable."
        break;
        case error.TIMEOUT:
        err.innerHTML = "The request to get user location timed out."
        break;
        case error.UNKNOWN_ERROR:
        err.innerHTML = "An unknown error occurred."
        break;
     
}
}
</script>
</head>
<body onload=showPosition() >
    <div id="embedMap" style="width: 2000px; height: 900px;">
    </div>
</body>
</html> 