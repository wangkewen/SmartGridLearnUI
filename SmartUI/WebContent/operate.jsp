<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="bean.User;"%>
<html>
<link rel="icon" href="http://localhost/SmartUI/favicon.ico" type="image/x-icon"/>
<link rel="stylesheet" type="text/css" href="css/style.css">
<head>
<title>
Operate
</title>
</head>
<link rel="stylesheet" type="text/css" href="css/operate.css">
<body>
<div id="page">
<%@ include file="nav_header.jsp" %>
<div id="content">
<div id="title">
<%=session.getAttribute("userName")%> 
Schedule Information
</div>
<div id="info">
<%=session.getAttribute("myscheduleinfo")%>

</div>
<div id="form">
<ul id="button"><li><span></span></li>
</ul>   
</div>

</div>
</div>
<%@ include file="bot_footer.jsp" %>
</body>
</html>