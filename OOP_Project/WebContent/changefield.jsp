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
<%String f = request.getParameter("field"); session.setAttribute("field",f); %>
<div id="container" >
<header>
<h1><a href='index.jsp'>Quick<span>Food</span></a></h1>
<h2>Homemade Food.Quick Deliveries.</h2>
<div class="panelHeader">
<b> Hey <%=session.getAttribute("User") %> </b>
<div style="text-align: left"><a href="settings.jsp" class="w3-button w3-teal w3-small" >Back</a></div>
<div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet" class="w3-button w3-teal w3-small" >Logout</a></div>
</div>
</header>
<center><h2><b>Enter New <%=request.getParameter("field") %></b></h2>
<br></br>
<center><form action="ChangeField">
<tr> <td><b><%=request.getParameter("field") %></b></td><td><input type="text" name="newfield"></td></tr>
	<br></br>
	<tr><td><input type="submit" class="w3-btn w3-red w3-round-xxlarge w3-large" name="submit" value="Submit"></td>
	<br></br>
	</form>
</div>
</body>
</html>