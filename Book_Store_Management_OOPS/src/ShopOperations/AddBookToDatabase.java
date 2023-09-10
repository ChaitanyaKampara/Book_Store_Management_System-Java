package ShopOperations;

import java.util.List;

import BookClass.BookDbms;
import BookClass.BookInfo;

public class AddBookToDatabase {
	
	public static void AddBook(List<BookInfo> list, String TableName) {
		if (list != null) 
		{
			for (BookInfo b : list) {
				(new BookDbms()).createBook(b, TableName);
			}
		}

	}

}
