<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>

	<link rel='stylesheet' type='text/css' href='eventcalendar/assets/css/reset.css' />
	<link rel='stylesheet' type='text/css' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/start/jquery-ui.css' />
	<link rel='stylesheet' type='text/css' href='eventcalendar/assets/css/jquery.weekcalendar.css' />
	<link rel='stylesheet' type='text/css' href='eventcalendar/assets/css/demo.css' />
	
	<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js'></script>
	<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/jquery-ui.min.js'></script>
	<script type='text/javascript' src='eventcalendar/assets/js/jquery.weekcalendar.js'></script>
	<script type='text/javascript' src='eventcalendar/assets/js/demo.js'></script>
	<script type='text/javascript' src='eventcalendar/assets/js/ajaxfileupload.js'></script>

</head>
<body> 
	<h1>Time Slot Reserve</h1>
	<div id='calendar'></div>
	<div id="event_edit_container">
		<form>
			<input type="hidden" />
			<ul>
				<li>
					<span>Date: </span><span class="date_holder"></span> 
				</li>
				<li>
					<label for="start">Start Time: </label><select name="start"><option value="">Select Start Time</option></select>
				</li>
				<li>
					<label for="end">End Time: </label><select name="end"><option value="">Select End Time</option></select>
				</li>
				<li>
					<label for="title">Title: </label><input type="text" name="title" />
				</li>
				<li>
					<label for="body">Body: </label><textarea name="body"></textarea>
				</li>
                <li id="filedownload">
                
                </li>
				
			</ul>
		</form>
		<form id="fileup">
			
		</form>
	</div>
	
	
</body>
</html>

