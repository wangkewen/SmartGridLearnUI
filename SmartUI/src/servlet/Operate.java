/*
 *   Jump to "operate.jsp" page
 */

package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ScheduleDAO;
import bean.User;


public class Operate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	public Operate() {
     	   super();
   	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		System.out.println("doget");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();

    	String scheduleinfo=null;  	
    	Integer userid=(Integer)session.getAttribute("userId");	
    	request.getRequestDispatcher("operate.jsp").forward(request, response);
	}
}
