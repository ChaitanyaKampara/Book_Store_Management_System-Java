package HandlingFiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConnectionToSql.DataBaseConnect;

public class InsertBook {
	public static void Insertbook(String id,String Tit,String aut,String gen,double price,int c) throws SQLException
	{
		Connection con=DataBaseConnect.connect();
		int count=0;
			String Query="Select count(*) from books where Book_Id=?";
			PreparedStatement ps=con.prepareStatement(Query);
				ResultSet rs=ps.executeQuery(Query);
				if(rs.next())
				{
					count=rs.getInt(1);
				}
			if(count==0)
			{
				String query="Insert into books values(?,?,?,?,?,?)";
				try(PreparedStatement ps1=con.prepareStatement(query))
				{
					ps1.setString(1, id);
					ps1.setString(2, Tit);
					ps1.setString(3, aut);
					ps1.setString(4,gen);
					ps1.setDouble(5,price);
					ps1.setInt(6, c);
					int upd=ps1.executeUpdate();
					System.out.println(upd+" rows have been effeceted");
					con.close();
				}
				catch(Exception e)
				{
					e.getLocalizedMessage();
				}
			}
			
		
	}

}
