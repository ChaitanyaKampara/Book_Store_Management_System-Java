package ShopOperations;

import java.util.Iterator;
import java.util.List;

import BookClass.BookInfo;

public class PrintingBooks 
{
	public static void PrintBooks(List<BookInfo>list)
	{
		String temp[] = new String[] { "Book_id", "Title", "Author", "Genre", "Price", "Copies" };
		System.out.printf("+%8s+%29s+%30s+%14s+%10s+%10s+", "-----------", "-----------------------------",
				"------------------------------", "--------------------", "--------------",
				"-----------");
		System.out.println();
		System.out.printf("|%10s|%30s|%30s|%20s|%14s|%11s|", temp[0], temp[1], temp[2], temp[3], temp[4],
				temp[5]);
		System.out.println();
		System.out.printf("+%8s+%29s+%30s+%14s+%10s+%10s+", "-----------", "-----------------------------",
				"------------------------------", "--------------------", "--------------",
				"-----------");
		System.out.println();
		Iterator<BookInfo> itr = list.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());
		System.out.printf("+%8s+%29s+%30s+%14s+%10s+%10s+", "-----------", "-----------------------------",
				"------------------------------", "--------------------", "--------------",
				"-----------");
		System.out.println();
	}

}
