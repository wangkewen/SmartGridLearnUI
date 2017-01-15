/*
 *   Login status validation
 */

package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ScheduleDAO;
import bean.User;
import bean.UserDAO;


public class LoginValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	public LoginValidate() {
        	super();
    	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String scheduleinfo=null;
		PrintWriter out=null;
		boolean nameExist=false;
		String sign=null;
		System.out.println(this.getServletContext().getRealPath("/"));
		out=response.getWriter();
		String uName = request.getParameter("userName");
		String uPassword = request.getParameter("userPassword");
		User user = new User(uName,uPassword);
		UserDAO ud = new UserDAO();
		Integer uid=ud.isExist(user);
		nameExist=ud.isNameExist(uName);
		if(uid != null){
			session.setAttribute("userName",uName);
			session.setAttribute("userId",uid);
			sign="Permitted";
		}else if(!nameExist) sign="Name not exists";
		else sign="Password error";
		out.write(sign);
		out.flush();
		out.close();
	}
}
