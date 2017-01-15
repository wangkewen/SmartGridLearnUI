/*
 *   User registration
 */

package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import bean.UserDAO;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

  	public Register() {
                super();
    	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String realname=request.getParameter("realname");
		String college=request.getParameter("college");
		String type="user";
		User user=new User(0,name,pwd,email,realname,college,type,0);
		UserDAO ud=new UserDAO();
		ud.addUser(user);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
