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


 <body>
<div id="container">
<header>
<h1><a href='agenthome.jsp'>Quick<span>Food</span></a></h1>
<h2>Homemade Food.Quick Deliveries.</h2>
<div class="panelHeader">
<b> Hey <%=session.getAttribute("Agent") %>. </b>
<div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet" class="w3-button w3-teal w3-small" >Logout</a></div>
</div>
</header>


<table>
<center><h3><b>Booking Nearby You</b></h3></center>

<tr>
<td> Customer : </td> 
<td><%= session.getAttribute("username")%></tr>
</tr>
<tr>
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
</table>

    <form id='booking' action='/OOP_Project/AcceptServlet' method='post'
    accept-charset='UTF-8'>
         
         <tr>
        <td colspan='2'>
           <center> <input type="submit" class="w3-btn w3-blue w3-round-xxlarge w3-large" name='accept' value="Accept"/> 
            
            <a href="<%=request.getContextPath()%>/DeclineServlet" class="w3-btn w3-teal w3-round-xxlarge w3-large">Decline</a></center>
    </tr>
    
    
 </table>
</form>
</div>

 </body>
</html>