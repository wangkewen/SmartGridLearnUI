/*
 *   The operation of schedule information
 */

package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScheduleDAO {
	private ReserveInfo[] schedules=null;
	
	public ReserveInfo[] getSchedules(){
		querySchedule();
		return schedules;
	}
	
	public Integer findScheduleId(String begintime){
		String sql="select id from schedule where begintime=?";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Integer id=null;
		conn = (new DbConn()).getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, begintime);
			rs=ps.executeQuery();
			while(rs.next())
				id=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return id;
	}
	
        /**  
         *  to display all schedule information
         */
	private void querySchedule(){		
		List<ReserveInfo> plan= new ArrayList<ReserveInfo>();
		String sql="select id,begintime, endtime, title, body from schedule";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		conn = (new DbConn()).getConnection();
		int begin=0;
		int end=0;
		String monBegin=null;
		String monEnd=null;
		try {
			 ps = conn.prepareStatement(sql);
			 rs=ps.executeQuery();
		while(rs.next()){
			ReserveInfo info=null;
		        String[] begindate=rs.getString(2).split(" ")[0].split("-");
			String[] begintime=rs.getString(2).split(" ")[1].substring(0, 8).split(":");
			String[] enddate=rs.getString(3).split(" ")[0].split("-");
			String[] endtime=rs.getString(3).split(" ")[1].substring(0,8).split(":");
			
			begin=(begindate[1].charAt(0)-48)*10+(begindate[1].charAt(1)-48);		
			if(begin<=10) monBegin="0"+(begin-1);
			else monBegin=""+(begin-1);
			end=(enddate[1].charAt(0)-48)*10+(enddate[1].charAt(1)-48);
		        if(end<=10) monEnd="0"+(end-1);
		        else monEnd=""+(end-1);
			info= new ReserveInfo(rs.getInt(1),begindate[0],monBegin,begindate[2],begintime[0],begintime[1],
					        enddate[0],monEnd,enddate[2],endtime[0],endtime[1],rs.getString(4),rs.getString(5));
			if(info!=null)   
			plan.add(info);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
			}catch(SQLException e){
				System.out.println(e);
			}
		}
		int len=plan.size();
		if(len==0)
			schedules=null;
		else{
			schedules=new ReserveInfo[len];
			for(int i=0; i<len; i++)
				schedules[i]=plan.get(i);
		}
		
	}
	
        /**  
         *  to check if this schedule time slot conficts with previous ones
         */
	public boolean checkConflict(String begin,String end){
		String sql="select begintime,endtime from schedule where NOT (begintime>=?  OR endtime<=?)";
		Connection conn=null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		Boolean flag=false;
		conn = (new DbConn()).getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, end);
			ps.setString(2, begin);
			rs=ps.executeQuery();
			if(rs.next()) flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
			}catch(SQLException e){
				System.out.println(e);
			}
		}
		return flag;
	}
	
        /**  
         *  add new schedule
         */
        public void addSchedule(Schedule schedule){
        	String sql="insert into schedule(id,begintime,endtime,userid,username,title,body,filepath,filename)" +
        		"values(?,?,?,?,?,?,?,?,?)";
        	PreparedStatement ps=null;
        	Connection conn=null;
        	conn=(new DbConn()).getConnection();
        	try{
        	ps=conn.prepareStatement(sql);
        	ps.setInt(1, schedule.getId());
        	ps.setString(2, schedule.getBegintime());
        	ps.setString(3, schedule.getEndtime());
       		ps.setInt(4, schedule.getUserid());
        	ps.setString(5, schedule.getUsername());
        	ps.setString(6, schedule.getTitle());
        	ps.setString(7, schedule.getBody());
        	ps.setString(8, schedule.getFilepath());
        	ps.setString(9, schedule.getFilename());
        	ps.executeUpdate();
        	}catch(SQLException e){
        		System.out.println("SQL Exception..." + e);
        	}finally{
		    try{
			if(ps!=null)
			    ps.close();
			if(conn!=null)
		            conn.close();
			}catch(SQLException e){
		            System.out.println("SQL exception...2..." + e);
			}
		}
   	}
    
        /**  
         *  check user schedule by userid
         */
   	public String checkSchedule(Integer userid){
        	String sql="select date_format(begintime,'%Y-%m-%d %H:%i'),date_format(endtime,'%Y-%m-%d %H:%i') from schedule where"
                            + "userid=? order by begintime";
       		PreparedStatement ps=null;
        	Connection conn=null;
        	ResultSet rs=null;
        	String result=null;
        	int i=1;
        	conn=(new DbConn()).getConnection();
        	try{
        	ps=conn.prepareStatement(sql);
        	ps.setInt(1, userid);
        	rs=ps.executeQuery();
        	while(rs.next())
       		 	if(result==null)
       		 	result=(i++)+". "+rs.getString(1)+" ---> "+rs.getString(2)
                               +"  <a href=\"download/outputfile\">ResultFile</a>" + "<br><br> ";
        		else
        		result=result+(i++)+". "+rs.getString(1)+" ---> "+rs.getString(2)
                               +"  <a href=\"download/outputfile\">ResultFile</a>" + " <br><br> ";
        	}catch(SQLException e){
        		System.out.println("SQLException..." + e);
        	}finally{
        		try{
        			if(ps!=null)
        				ps.close();
        			if(conn!=null)
        				conn.close();
        		}catch(SQLException e){
        			System.out.println("SQL exception...1.." + e);
        		}
       		 }
        	if(result==null)
       		 	result="Your schedule information is null,please reserve first.";
    		return result;
    	}

        /**  
         *  check user schedule by begintime
         */
    	public String checkSchedule(String date){
    		String result=null;
    		int i=1;
    		String sql="select date_format(begintime,'%Y-%m-%d %H:%i'),date_format(endtime,'%Y-%m-%d %H:%i') from schedule where"
                           + "begintime>='"+date+"' order by begintime";
    		System.out.println(date);
    		Connection conn=null;
    		PreparedStatement ps=null;
    		ResultSet rs=null;
    		conn=(new DbConn()).getConnection();
    		try{
    		ps=conn.prepareStatement(sql);
    		rs=ps.executeQuery();
    		while(rs.next())
    			if(result==null)
    				result=(i++)+". "+rs.getString(1)+" ---> "+rs.getString(2)+" <br><br> ";
    			else
    				result=result+(i++)+". "+rs.getString(1)+" ---> "+rs.getString(2)+" <br><br> ";
    		}catch(SQLException e){
    			System.out.println("SQL Exception..." + e);
    		}finally{
    			try{
    			ps.close();
    			conn.close();
    			}catch(SQLException e){
    				System.out.println("SQLException..."+e);
    			}
    		}
    		if(result==null)
    			result="All time available from now.";
    		return result;
   	 }
   
}
