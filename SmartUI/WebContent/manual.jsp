<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="bean.User;"%>
<html>
<link rel="icon" href="http://localhost/SmartUI/favicon.ico" type="image/x-icon"/>
<link rel="stylesheet" type="text/css" href="css/style.css">
<head>
<title>
&nbsp;Manual
</title>
</head>
<link rel="stylesheet" type="text/css" href="css/operate.css">
<body>
<div id="page">
<%@ include file="nav_header.jsp" %>
<div id="content">
<div id="title">
Manual
</div>
<div id="info">
<h1>1.Choose time slot</h1>
<h1>2.Upload execution file (.imn)</h1>
<h1>3.Save</h1>
<h1>4.Get result file when it is available</h1>
<h1>Note: If upload file is not *.imn, it will execute
 <a href=Download?filename=WelcomeToSCORE.imn>default file</a>.</h1>
<h1>SmartGrid Emulator Manual: <a href=Download?filename=Manual.pdf> Manual.pdf</a></h1>
</div>


</div>
</div>
<%@ include file="bot_footer.jsp" %>
</body>
</html>