/*
 * Check User Schedule infomation by userid
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

import bean.ScheduleDAO;

public class ResultCheck implements Filter {

        public ResultCheck() {
        }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		HttpSession session=req.getSession();
    		String scheduleinfo=null;
    		Integer userid=(Integer)session.getAttribute("userId");
    		ScheduleDAO sd=new ScheduleDAO();
    		scheduleinfo=sd.checkSchedule(userid);
    		session.setAttribute("myscheduleinfo", scheduleinfo);
		chain.doFilter(req, resp);
		req.getRequestDispatcher("operate.jsp").forward(req, resp);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
