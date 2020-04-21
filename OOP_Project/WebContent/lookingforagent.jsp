<html>
<meta http-equiv="refresh" content="2;url=<%=request.getContextPath()%>/CheckOrderAcceptedServlet" />
 <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>QuickFood</title>
    <link rel="stylesheet" href="styles.css" type="text/css" />
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="loader.css" type="text/css" />
    
</head>

<% //In case, if Admin session is not set, redirect to Login page
if((request.getSession(false).getAttribute("User")== null))
{
%>
<jsp:forward page="login.jsp"></jsp:forward>
<%} %>


 <body>
<div id="container">
<header>
<h1><a href='index.jsp'>Quick<span>Food</span></a></h1>
<h2>Homemade Food.Quick Deliveries.</h2>
</header>
<div class="panelHeader">
<b> LOOKING FOR DELIVERY AGENT  </b>
<br> Please Wait </br>
<br></br>
<center><div class="loader"></div></center>
<br></br>
<div style="text-align: center"><a href="<%=request.getContextPath()%>/CancelUserServlet" class="w3-button w3-teal w3-small" >Cancel My Booking</a></div>
</div>

 </body>
</html>