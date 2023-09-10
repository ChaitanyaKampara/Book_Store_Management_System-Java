package CustomerClass;

import java.sql.Connection;
import java.sql.PreparedStatement;

import BookClass.BookInfo;
import ConnectionToSql.DataBaseConnect;

public class CreateCustomerInDatabase {
	public static void createCustomer(Customer c,BookInfo b,String Tablename)
	{
		Connection con=DataBaseConnect.connect();
		String Query="Insert into "+Tablename +" values(?,?,?,?,?,?)";
		try(PreparedStatement ps=con.prepareStatement(Query))
		{
			ps.setInt(1, c.getCust_Id());
			ps.setString(2, c.getName());
			ps.setString(3, c.getPhNo());
			ps.setString(4,c.getPlace());
			ps.setString(5,b.getBook_Id());
			ps.setString(6,b.getTitle());
			int upd=ps.executeUpdate();
			System.out.println(upd+" rows have been effeceted");
			con.close();
		}
		catch(Exception e)
		{
			e.getLocalizedMessage();
		}
	}
}
