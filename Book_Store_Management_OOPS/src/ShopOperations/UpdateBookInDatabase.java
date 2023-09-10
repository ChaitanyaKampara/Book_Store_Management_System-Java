package ShopOperations;

import java.sql.SQLException;


import BookClass.BookDbms;

public class UpdateBookInDatabase {
	private static BookDbms b=new BookDbms();
//	public static void updateBook(List<BookInfo> list,String Tablename) throws SQLException
//	{
//	  if(list!=null)
//	  {
//		  for(BookInfo bd:list)
//		  {
//			  b.DeleteBook(bd.getBook_Id(), Tablename);
//		  }
//		  for(BookInfo bd:list)
//		  {
//			  b.createBook(bd, Tablename);
//		  }
//		  System.out.println("Updated "+list.size()+" rows");
//	  }
//	}
	public static void updateBook(String args[], String TableName) throws SQLException {
		b.updateBook(args, TableName);
	}

}
