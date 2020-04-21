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
<b> Hey <%=session.getAttribute("User") %>. </b>
<div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet" class="w3-button w3-teal w3-small" >Logout</a></div>
</div>
</header>
<table>
<center><h3><b>Looks Like Our Delivery Agent Is Busy</b></h3></center>
<center><h3>We Regret The Inconvenience</h3></center>
<center><a href="<%=request.getContextPath()%>/CancelUserServlet" class="w3-button w3-teal">Okay</a></center>
<br></br>
<center><a href="<%=request.getContextPath()%>/LookForAgentServlet" class="w3-button w3-teal">Keep Looking</a></center>
<br></br>
 </body>
</html>