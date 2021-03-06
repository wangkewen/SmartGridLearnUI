/*
 *   Check duplicate name
 */

package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserDAO;


public class RegNameCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

    	public RegNameCheck() {
    	    super();
    	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=null;
		UserDAO ud=null;
		String name=null;
		out=response.getWriter();
		ud=new UserDAO();
		name=request.getParameter("username");
		if(ud.isNameExist(name)) out.write("Name Exists");
		out.flush();
		out.close();
	}

}
