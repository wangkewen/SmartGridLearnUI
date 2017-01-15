<div id="nav_header">
<div id="logo"><a href="index.jsp"><img src="pic/logo.png" alt="Logo"/></a></div>
<ul>
<li id="nav_topic_login"><span>|</span><%if(session.getAttribute("userName")!=null){%>
                      <%=session.getAttribute("userName")%>
                      <%}else {%>
                      <a href="login.jsp" >Login</a> 
                      <%} %></li> 

<li id="nav_topic_home"><span>|</span><a href="index.jsp">Home</a></li>
<li id="nav_topic_contact"><span>|</span><a href="contact.jsp">Contact</a></li>
<li id="nav_topic_logout"><%if(session.getAttribute("userName")!=null){%>
                      <span>|</span><a href="Logout">Logout</a>
                      <%} %></li> 
</ul>
</div>

<div id="nav_bar">
<ul>
<li id="nav_topic_manual"><span>|</span><a href="manual.jsp">Manual</a></li>
<li id="nav_topic_schedule"><span>|</span><a href="about.jsp">Schedule</a></li>
</ul>
</div>
