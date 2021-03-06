/*
 * Check User Schedule infomation by begintime
 */

package filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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


public class ScheduleCheck implements Filter {

    	public ScheduleCheck() {
        
   	}

	public void destroy() {	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		HttpSession session=req.getSession();
		String scheduleinfo=null;
	        String time= (new SimpleDateFormat("yyyy-MM-dd HH:mm")).format(new Date(System.currentTimeMillis()));
		ScheduleDAO sdao=new ScheduleDAO();
		scheduleinfo=sdao.checkSchedule(time);
		session.setAttribute("scheduleinfo", scheduleinfo);
		chain.doFilter(req, resp);
		req.getRequestDispatcher("schedule.jsp").forward(req, resp);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
