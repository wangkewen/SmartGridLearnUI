<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<html>
<head>
<link rel="icon" href="http://localhost/SmartUI/favicon.ico" type="image/x-icon"/>
<link rel="stylesheet" type="text/css" href="css/index.css">
<script type="text/javascript" src="js/reg.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<title>User Login</title>
</head>
<body>

<div id="content">
<div id="back"><a href="index.jsp">Home</a></div>
<div id="form">
<form id="login">
<ul id="list">
<li><span class="txt">Name</span><input type="text" name="userName" id="userName">
    <span id="nameCheck" class="check"></span></li>
<li><span class="txt">Password</span><input type="password" name="userPwd" id="userPwd">
    <span id="pwdCheck" class="check"></span></li>
</ul>
<ul id="button">
<li><span><input type="button" value="Login" onclick="check()"></span>
    <span><input type="reset" value="Reset"></span></li>
</ul>
</form>
</div>
<div id="click" onclick="isHidden('regdiv')">Register here</div>
<br>
<div style="display:none" id="regdiv">
<%@include file="register.jsp" %>
</div>
</div>
</body>
</html>