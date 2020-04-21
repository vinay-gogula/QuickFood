<html>
<meta http-equiv="refresh" content="1;url=<%=request.getContextPath()%>/OrderAcceptedServlet" />
 <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>QuickFood</title>
    <link rel="stylesheet" href="styles.css" type="text/css" />
    <link rel="stylesheet" href="card.css" type="text/css" />
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
<div class="panelHeader">
<b> Hey <%=session.getAttribute("User") %>. </b>
<div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet" class="w3-button w3-teal w3-small" >Logout</a></div>
</div>
</header>

<div class="card">
  <h1>Order <%=request.getAttribute("status") %></h1>
  <h3><b><%= request.getAttribute("agentusername")%></b></h3>
    <p class="title">Delivery Agent <p> 
  <a href="TrackServlet" target="_blank" class="w3-btn w3-green w3-round-xxlarge w3-large"  >Track Agent</a>
  <br> </br>
  <p><button>Contact at <%=request.getAttribute("agentnumber")%></button></p>
</div>


<center><b>ORDER SUMMARY</b></center>
<table>
<tr>
<td>Booking ID : </td> 
<td><%= request.getAttribute("bookingid")%></tr>
</tr>
<tr>
<td>Pickup Point : </td> 
<td><%= request.getAttribute("pickuppoint")%></tr>
</tr>
<tr>
<td>Delivery Point : </td> 
<td><%= request.getAttribute("destination")%></tr>
</tr>
<tr>
<td>Recipient Name : </td> 
<td><%= request.getAttribute("recipientname")%></tr>
</tr>
<tr>
<td>Recipient Number : </td> 
<td><%= request.getAttribute("recipientnumber")%></tr>
</tr>
<tr>
<td> Order Placed At : </td> 
<td><%= request.getAttribute("ordertime")%></tr>
</tr>
<tr>
<td>Delivery Price : </td> 
<td> Rs.<%= request.getAttribute("price") %> </tr>
</tr>
</table>
</div>
 </body>
</html>