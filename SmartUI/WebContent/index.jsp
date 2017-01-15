<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<html>
<link rel="icon" href="http://localhost/SmartUI/favicon.ico" type="image/x-icon"/>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/checkwindow.js"></script>
<head>

<title>&nbsp;Home</title>
</head>
<body>

<div id="page">
<%@ include file="nav_header.jsp" %>
<div id="content">
<h1>Smart-grid Common Research Emulator (SCORE)</h1>
<p>The Smart-Grid Common Open Research Emulator (SCORE) is a platform
for emulating Smart Grid Environment in real time. It captures the dynamic 
behaviors of communication network, power network as well as the
interactions between them so that it can be employed to study the sensing,
computation, communication and control strategies within Smart Grid. It
provides an environment for running and testing real Smart Grid applications
by taking advantages of the virtualization techniques supported by Linux
operating system. Also, it enables large-scale emulations by distributed execution.</p>
<p><img src="pic/score.PNG"/><img src="pic/gui.PNG" /></p>
<p>Our design of SCORE takes advantage of CORE's structure. The first figure provides an 
abstract overview of SCORE's architecture and our integration approach. And the second figure 
is GUI of SCORE.
As shown, SCORE consists of GUI, Service Layer, Communication
Module and Power Module. The GUI provides an easily drag-and-draw environment 
for the users to set up the emulations. Configuration parameters
for the emulated nodes, power lines, communication links and distributed
emulation servers can all be specified. Interacting with GUI through Start-
UP daemon, the service layer are python frameworks that is responsible for
creating emulation sessions, instantiating the virtual nodes, communication
links and power lines, etc. </p>
<p>The service layer also wraps up the low level 
implementations from communication module and power module as various Smart
Grid services. Those services can all be employed or customized by the users
to build up their own Smart Grid applications. More importantly, Linux
network namespaces is employed for Linux containers support so that each
emulated node can have its own instance of virtual or real network devices,
network protocol stack and process space while sharing the file system of emulation
 server with other nodes. This light-weighted virtualization approach
enables the scalability of SCORE.</p>

</div>
<div>
</div>
<%@ include file="bot_footer.jsp" %>
</div>
</body>
</html>