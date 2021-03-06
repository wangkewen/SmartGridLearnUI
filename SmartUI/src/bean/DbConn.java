/*
 *   Database connection
 */

package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
  
public class DbConn { 
   private final String url = "jdbc:mysql://localhost:3306/smart";
   private final String user = "root";
   private final String password = "******";
   private Connection conn = null;
   
   public DbConn(){
	   try{
	   Class.forName("com.mysql.jdbc.Driver"); 
	   conn = DriverManager.getConnection(url,user,password);
	   }catch(SQLException e){
		   System.out.println("Connection Failure...");
	   }catch(ClassNotFoundException e){
		   System.out.println("ClassForName error...");
	   }
   }
   
   public Connection getConnection(){
	   return conn;
   }
  
}

