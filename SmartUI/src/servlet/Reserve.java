package servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.Schedule;
import bean.ScheduleDAO;
import bean.User;


public class Reserve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	public Reserve() {
     	  	super();
    	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String[] begininfo=new String[2];
		String[] endinfo=new String[2];
		String command=null;
    		Process process=null;
    		String begintime=null;
		String endtime=null;
                begininfo=begintime.split(" ");
		endinfo=endtime.split(" ");
		begintime=begininfo[1]+" "+begininfo[0];
		endtime=endinfo[1]+" "+endinfo[0];
		System.out.println("begintime:"+begintime+" endtime:"+endtime);
		command="sh /home/smart/schedule.sh " + begintime + " " + endtime;
    	        System.out.println("command:" +command);
	}

}
