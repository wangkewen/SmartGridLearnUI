/*
 *   Display schedule
 */

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.ReserveInfo;
import bean.ScheduleDAO;

public class ShowSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;

   	public ShowSchedule() {
        	super();
    	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ScheduleDAO sd = new ScheduleDAO();
		Gson gson = new Gson();
		String data= gson.toJson(sd.getSchedules());
		out.write(data);
		out.flush();
		out.close();
		
	}

}
