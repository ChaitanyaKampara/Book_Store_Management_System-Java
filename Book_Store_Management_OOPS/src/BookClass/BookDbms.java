package BookClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import ConnectionToSql.DataBaseConnect;
import ProjectHelp.Help;


public class BookDbms implements DatabaseOperations {
	public void createBook(BookInfo b,String Tablename)
	{
		Connection con=DataBaseConnect.connect();
		String Query="Insert into "+Tablename +" values(?,?,?,?,?,?)";
		try(PreparedStatement ps=con.prepareStatement(Query))
		{
			ps.setString(1, b.getBook_Id());
			ps.setString(2, b.getTitle());
			ps.setString(3, b.getAuthor());
			ps.setString(4,b.getGenre());
			ps.setDouble(5,b.getPrice());
			ps.setInt(6, b.getNo_of_Copies());
			int upd=ps.executeUpdate();
			System.out.println(upd+" rows have been effeceted");
			con.close();
		}
		catch(Exception e)
		{
			e.getLocalizedMessage();
		}
		
	}
	public List<BookInfo> PrintBooks(String TableName) throws SQLException
	{
		Connection con=DataBaseConnect.connect();
		String Query="Select * from "+TableName;
		try(PreparedStatement ps=con.prepareStatement(Query))
		{
			ResultSet rs=ps.executeQuery();
			List<BookInfo> bi=new ArrayList<BookInfo>();
			while(rs.next())
			{
				BookInfo bookinf=new BookInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6));
				bi.add(bookinf);
			}
			return bi;
		}
		catch(Exception e)
		{
			e.getLocalizedMessage();
			return null;
		}
		
	}
	public int BooksCount(String TableName) {
		Connection con=DataBaseConnect.connect();
		String Query = "select count(*) from " + TableName;
        ResultSet rs;
        int tmp = 0;
        try(PreparedStatement ps = con.prepareStatement(Query)){
            rs = ps.executeQuery(Query);
            rs.next();
            tmp = rs.getInt(1);
            rs.close();
            con.close();
        }
        catch(Exception e){
            e.getLocalizedMessage();
        }
        return (tmp);
	}

		
		
		
	
	public void DeleteBook(String id,String TableName) throws SQLException
	{
		Connection con=DataBaseConnect.connect();
		String Query="Delete from "+TableName+" where Book_id=?";
		try(PreparedStatement ps=con.prepareStatement(Query))
		{
			ps.setString(1, id);
			ps.executeUpdate();
			System.out.println("Deleted the book with id "+id+" succesfully");
			con.close();
		}
		catch(Exception e)
		{
			e.getLocalizedMessage();
		}
		
	}
	//This method takes parameter as any attribute and data then deletes the book from that attribute
	public void DeleteBookFromAttribute(String Attribute, String data, String TableName)
	{
		Connection con=DataBaseConnect.connect();
		String Query="Delete from "+TableName+ " where "+Attribute+"= ?";
		try(PreparedStatement ps = con.prepareStatement(Query)){
            ps.setString(1, data);
            ps.executeUpdate();
            System.out.println("Deleted the book with  "+Attribute +"="+data+" succesfully");
            con.close();
        }catch(Exception e){
            e.getLocalizedMessage();
        }
		
	}
	public void updateBook(String args[], String tableName) throws SQLException
	{
		Connection con=DataBaseConnect.connect();
		String query = "update " + tableName + " set " + Help.ShortForm(args[1])  + " = ?" +  " where " + Help.ShortForm(args[4]) +  " = " + "?";
        try(PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1, args[2]);
            ps.setString(2, args[5]);
           int upd = ps.executeUpdate();
           System.out.println(upd + " rows have been updated");
            con.close();
        }
        catch(Exception e){
            e.getLocalizedMessage();
        }
	}
	public void updateBookforInt(String args[], String tableName) throws SQLException
	{
		Connection con=DataBaseConnect.connect();
		String query = "update " + tableName + " set " + Help.ShortForm(args[1])  + " = ?" +  " where " + Help.ShortForm(args[4]) +  " = " + "?";
        try(PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, Integer.valueOf(args[2]));
            ps.setString(2, args[5]);
           int upd = ps.executeUpdate();
           System.out.println(upd + " rows have been updated");
            con.close();
        }
        catch(Exception e){
            e.getLocalizedMessage();
        }
	}
	@Override
	public void truncateTable(String TableName) throws SQLException
	{
		Connection con=DataBaseConnect.connect();
        String Query = "truncate table " + TableName;
        try(PreparedStatement ps = con.prepareStatement(Query)){
            ps.executeUpdate();
            System.out.println("Table " + TableName + " has been truncated");
            con.close();
        }catch(Exception e){
            e.getLocalizedMessage();
        } 
		
	}
	@Override
	public List<BookInfo> sortBookByAtt(String Attribute, String order, String TableName) throws SQLException {
		List<BookInfo> b=new ArrayList<>();
		Connection con=DataBaseConnect.connect();
		final String Query="Select * from "+TableName+" order by "+Attribute+" "+order;
		try(PreparedStatement ps=con.prepareStatement(Query))
		{
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				BookInfo bookinf=new BookInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6));
				b.add(bookinf);
			   	
			}
			con.close();
			return b;
		}
		catch(SQLException e)
		{
			e.getLocalizedMessage();
		}
		return b;
	}
	

}
