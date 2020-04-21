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


 <body>
<div id="container">
<header>
<h1><a href='index.jsp'>Quick<span>Food</span></a></h1>
<h2>Homemade Food.Quick Deliveries.</h2>
<div class="panelHeader">
<b> Hey <%=session.getAttribute("User") %>.  Please Confirm Your Booking  </b>
<div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet" class="w3-button w3-teal" >Logout</a></div>
</div>
</header>
<table>
<tr>
<td><b>Pickup Point</b></td> 
<td><%= request.getAttribute("pickuppoint")%></tr>
</tr>
<tr>
<td><b>Delivery Point</b></td> 
<td><%= request.getAttribute("destination")%></tr>
</tr>
<tr>
<td><b>Recipient Name</b> </td> 
<td><%= request.getAttribute("recipientname")%></tr>
</tr>
<tr>
<td><b>Recipient Number </b></td> 
<td><%= request.getAttribute("recipientnumber")%></tr>
</tr>
<tr>
<td><b>Discount Offered</b> </td> 
<td><%=request.getAttribute("discount")%></tr>
</tr>
<tr>
<td><b>DELIVERY PRICE</b> </td> 
<td> Rs.<%= request.getAttribute("price") %> </tr>
</tr>

</table>

    <form id='booking' action='/OOP_Project/LookForAgentServlet' accept-charset='UTF-8'>
         
         <tr>
        <td colspan='2'>
           <center> <input type="submit" class="w3-btn w3-blue w3-round-xxlarge w3-large" name='confirm' value="Confirm"/> 
            <a href="<%=request.getContextPath()%>/CancelUserServlet" class="w3-btn w3-teal w3-round-xxlarge w3-large">Cancel Your Order</a></center>
    </tr>
 </table>
</form>
</div>
 </body>
</html>