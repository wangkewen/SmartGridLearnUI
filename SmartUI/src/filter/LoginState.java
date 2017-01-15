/*
 * Check User Login status
 */

package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginState implements Filter {

 
        public LoginState() {
       
        }
	public void destroy() {
		System.out.println("Filter Destroy.");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
	
	    	if(session.getAttribute("userName") != null){
	    		chain.doFilter(req, resp);
	    	}else{
	    		req.getRequestDispatcher("login.jsp").forward(req, resp);
	    	}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter Init.");
	}

}
