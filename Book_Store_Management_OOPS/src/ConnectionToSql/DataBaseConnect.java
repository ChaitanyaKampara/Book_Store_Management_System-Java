package ConnectionToSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseConnect {
	public static Connection connect()
	{
	   
	   try {
		   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Oop_Project","root","Jayam@123");
		   return conn;
	   }
	   catch (SQLException e) 
       {
           e.printStackTrace();
       }
       
       return null;
	}
}
