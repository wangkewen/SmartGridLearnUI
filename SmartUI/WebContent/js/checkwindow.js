function openwindow(){
	OpenWindow=window.open("", "newwin", "height=250, width=250,toolbar=no ,scrollbars="+scroll+",menubar=no");
	OpenWindow.document.write("<TITLE>Example</TITLE>");
	OpenWindow.document.write("<BODY BGCOLOR=#ffffff>");
	OpenWindow.document.write("<h1>Hello!</h1>");
	OpenWindow.document.write("New window opened!");
	OpenWindow.document.write("</BODY>");
	OpenWindow.document.write("</HTML>");
	OpenWindow.document.close();
}
