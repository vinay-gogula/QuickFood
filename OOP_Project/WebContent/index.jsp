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
<div id="container" >
<header>
<h1><a href='index.jsp'>Quick<span>Food</span></a></h1>
<h2>Homemade Food.Quick Deliveries.</h2>
<div class="panelHeader">
<b> Hey <%=session.getAttribute("User") %> </b>
<div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet" class="w3-button w3-teal w3-small" >Logout</a></div>
</div>
</header> <center><a href="userhome.jsp" class="w3-btn w3-green w3-round-xxlarge w3-xlarge">Place an Order</a></center>
<br></br>
<center><a href="<%=request.getContextPath()%>/orderaccepted.jsp" class="w3-btn w3-orange w3-round-xxlarge w3-large" >Current or Previous Order Status</a></center>
<br></br>
<center><a href="<%=request.getContextPath()%>/askforpwd.jsp" class="w3-btn w3-teal w3-round-xxlarge w3-xlarge"" >Account Settings</a></center>
<br></br>
<br></br>
</div>
</body>
</html>