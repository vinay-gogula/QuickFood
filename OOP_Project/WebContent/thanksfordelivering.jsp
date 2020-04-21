<html>
 <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>QuickFood</title>
    <link rel="stylesheet" href="styles.css" type="text/css" />
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
<div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet" class="w3-button w3-teal w3-small" >Logout</a></div>
</div>
</header>
<table>
<br> </br>
<center><h3>Hey <%=session.getAttribute("Agent") %></h3></center>
<center><h3><b> Thanks For Delivering Food In Time </b></h3></center>
<style>
.checked {
  color: orange;
}
</style>
<span style="display:inline-block; width:385;"></span>
<span class="fa fa-star checked w3-xxlarge"></span>
<span class="fa fa-star checked w3-xxlarge"></span>
<span class="fa fa-star checked w3-xxlarge"></span>
<span class="fa fa-star checked w3-xxlarge"></span>
<span class="fa fa-star checked w3-xxlarge"></span>
<br> </br>
<center><a href="<%=request.getContextPath()%>/agenthome.jsp" class="w3-button w3-teal w3-large ">Go To Home</a></center>
</center>
<br> </br>
 </body>
</html>
