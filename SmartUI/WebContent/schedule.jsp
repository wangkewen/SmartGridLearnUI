<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<html>
<link rel="icon" href="http://localhost/SmartUI/favicon.ico" type="image/x-icon"/>
<link rel="stylesheet" type="text/css" href="css/style.css">
<head>
<title>
Schedule
</title>
</head>
<link rel="stylesheet" type="text/css" href="css/schedule.css">
<body>
<div id="page">
<%@ include file="nav_header.jsp" %>
<div id="content">
<div id="title1">
Time Slot Allocated
</div>
<div id="info">
<%=session.getAttribute("scheduleinfo")%>
</div>
<div id="title2">
Schedule Reserve
</div>
<div id="form">
<form id="reserve" action="Reserve" method="post" enctype="multipart/form-data">
<ul id="list">
<li><span class="txt">Begin time</span>
    <input type="text" name="begintime" id="begintime"/><span id="begintimeE" class="check"></span></li>
<li><span class="txt">End time</span>
    <input type="text" name="endtime" id="endtime"/><span id="endtimeE" class="check"></span></li>
<li><span class="txt">Upload File</span>
    <input type="file" name="file"/></li>
</ul>
<ul id="button"><li><span><input type="submit" value="Reserve"></span>
        <span><input type="reset" value="Reset"></span></li>
</ul>   
</form>
</div>
</div>
</div>
<%@ include file="bot_footer.jsp" %>
</body>
</html>