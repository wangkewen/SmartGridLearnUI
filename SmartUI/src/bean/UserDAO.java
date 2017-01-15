/*
 *  The operation of user information like registration
 */

package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    
	public void addUser(User user){
		String sql="insert into userinfo (id,name,password,email,realname,college," +
				"type,logincount) values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps=null;
		Connection conn=null;
		conn=(new DbConn()).getConnection();
		try{ 
		ps=conn.prepareStatement(sql);
		ps.setInt(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getEmail());
		ps.setString(5, user.getRealname());
		ps.setString(6, user.getCollege());
		ps.setString(7, user.getType());
		ps.setInt(8, user.getLogincount());
		ps.executeUpdate();
		}catch(SQLException e){
			System.out.println("SQL exception...1...");
		}finally{
			try{
			if(ps!=null)
			ps.close();
			if(conn!=null)
			conn.close();
			}catch(SQLException e){
				System.out.println("SQL exception...2...");
			}
		}
	}
	
	public boolean isNameExist(String name){
		String sql="select * from userinfo where name=?";
		boolean flag=false;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		conn=(new DbConn()).getConnection();
		try{
		ps=conn.prepareStatement(sql);
		ps.setString(1, name);
		rs = ps.executeQuery();
		if(rs.next()) flag=true;
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			try{
				ps.close();
				conn.close();
			}catch(SQLException e){
				System.out.println(e);
			}
		}	
		return flag;
	}
	
    	public Integer isExist(User user){
    	 	Integer id = null;
    	 	String sql = "select * from userinfo where name=? and password=?";
    	 	PreparedStatement ps = null;
    	 	ResultSet rs = null;
    	 	Connection conn = null;
    	 	conn = (new DbConn()).getConnection();
    	 	try{
    	 	ps = conn.prepareStatement(sql);
    	 	ps.setString(1, user.getName());
    	 	ps.setString(2, user.getPassword());
    	 	rs = ps.executeQuery();
    	 	if(rs.next())
    			 id=rs.getInt(1);
    	 	}catch(SQLException e){
    			 System.out.print("SQL error...");
    	 	}finally{
        		 try{
        		 if(ps!=null) 
        		 ps.close();
    			 if(conn!=null)
        		 conn.close();
        		 }catch(SQLException e){
        			 System.out.println("SQL Exception...");
        		 }
    	 	}
    	 	return id;
     	}  
}
