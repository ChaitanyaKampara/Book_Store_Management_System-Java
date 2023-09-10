package ShopOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BookClass.BookInfo;
import ConnectionToSql.DataBaseConnect;

abstract class Searching {
	abstract void search_ById(String id, String TableName);

	abstract List<BookInfo> search_ByPrice(String Price, String TableName);

	abstract List<BookInfo> search_ByAttribute(String Attribute, String value, String TableName);

	abstract List<BookInfo> seach_by_partialTitle(String Title, String Tablename);
}

public class SearchingOperations extends Searching {
	public SearchingOperations() {

	}

	@Override
	public void search_ById(String id, String TableName) {
		Connection con = DataBaseConnect.connect();
		String Query = "select * from " + TableName + " where Book_Id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(Query);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println("Details of book is:");
				System.out.println("Book Id: " + rs.getString("Book_Id"));
				System.out.println("Title : " + rs.getString("Title"));
				System.out.println("Author : " + rs.getString("Author"));
				System.out.println("Genre : " + rs.getString("Genre"));
				System.out.println("Price : " + rs.getDouble("Price"));
				System.out.println("Copies Available : " + rs.getInt("No_of_Copies"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("finally")
	@Override
	public List<BookInfo> search_ByPrice(String Price, String TableName) {
		Connection con = DataBaseConnect.connect();
		List<BookInfo> bl = new ArrayList<BookInfo>();
		String Query = "select * from " + TableName + " where Price =?";
		try {
			PreparedStatement stmt = con.prepareStatement(Query);
			stmt.setDouble(1, Double.valueOf(Price));
			ResultSet rs = stmt.executeQuery();

			int i = 0;
			while (rs.next()) {
				BookInfo b = new BookInfo();
				b.setBook_Id(rs.getString(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setGenre(rs.getString(4));
				b.setPrice(rs.getDouble(5));
				b.setNo_of_Copies(rs.getInt(6));
				bl.add(i, b);
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return bl;
		}

	}

	
	@SuppressWarnings("finally")
	@Override
	public List<BookInfo> search_ByAttribute(String Attribute, String value, String TableName) {
		Connection con = DataBaseConnect.connect();
		List<BookInfo> bl = new ArrayList<BookInfo>();
		String Query = "select * from " + TableName + " where " + Attribute + "=?";
		try {
			PreparedStatement stmt = con.prepareStatement(Query);
			stmt.setString(1, value);
			ResultSet rs = stmt.executeQuery();

			int i = 0;
			while (rs.next()) {
				BookInfo b = new BookInfo();
				b.setBook_Id(rs.getString(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setGenre(rs.getString(4));
				b.setPrice(rs.getDouble(5));
				b.setNo_of_Copies(rs.getInt(6));
				bl.add(i, b);
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return bl;
		}

	}


	@SuppressWarnings("finally")
	@Override
	public List<BookInfo> seach_by_partialTitle(String Title, String Tablename) {
		Connection con = DataBaseConnect.connect();
		List<BookInfo> bl = new ArrayList<BookInfo>();
		String query = "Select * from " + Tablename;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String str = rs.getString(2);
				int flag = 0;

				for (int i = 0; i < str.length(); i++) {
					for (int j = i + 1; j <= str.length(); j++) {

						if (str.substring(i, j).toUpperCase().equals(Title.toUpperCase()))
							flag = 1;

					}
				}
				int i=0;
				if(flag==1)
				{
					BookInfo b = new BookInfo();
					b.setBook_Id(rs.getString(1));
					b.setTitle(rs.getString(2));
					b.setAuthor(rs.getString(3));
					b.setGenre(rs.getString(4));
					b.setPrice(rs.getDouble(5));
					b.setNo_of_Copies(rs.getInt(6));
					bl.add(i, b);
					i++;
					
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			return bl;
		}
	}

}
