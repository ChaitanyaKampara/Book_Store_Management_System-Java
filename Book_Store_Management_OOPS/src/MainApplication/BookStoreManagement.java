package MainApplication;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import BookClass.Book;
import BookClass.BookDbms;
import BookClass.BookInfo;
import BookClass.Library;
import CustomerClass.Customer;
import ProjectHelp.Help;
import ShopOperations.CreateBook;
import ShopOperations.DeleteBookFromDatabase;
import ShopOperations.DeleteData;
import ShopOperations.PrintingBooks;
import ShopOperations.SearchingOperations;
import ShopOperations.SortBooks;
import ShopOperations.UpdateBook;



public class BookStoreManagement {
	public static Library lib = new Library();
	public static SearchingOperations so=new SearchingOperations();

	public static void main(String[] args) throws IOException, SQLException {
		BookDbms bd=new BookDbms();
		System.out.println("----------Welcome to Bookstore-----------");
		try {
			switch (args[0]) 
			{
			case "-create": {
				switch (args[1]) {
				case "-b": {
					CreateBook.create(args, Book.getFilename(), Book.getTablename());
					break;
				}
				}
				break;

			}
			case "-Delete":{
				switch(args[1])
				{
				case "-all":
				{
					DeleteData.deletedata(Book.getTablename(),Book.getFilename());
					break;
				}
				case "-byAtt":
				{
					DeleteBookFromDatabase.delete(args,Book.getFilename(),Book.getTablename());
					break;
				}
				}
				break;
			}
			case "-Search":
			{
				switch(args[1])
				{
				case "-byId":
				{
				  so.search_ById(args[2],Book.getTablename());	//args[2]=value of id that you want
					break;
				}
				case "-byPrice":
				{
					List<BookInfo> ls=new ArrayList<BookInfo>();
					ls=so.search_ByPrice(args[2],Book.getTablename());
					PrintingBooks.PrintBooks(ls);
					
					break;
				}
				case "-byAtt":
				{
					List<BookInfo> ls=new ArrayList<BookInfo>();
					ls=so.search_ByAttribute(Help.ShortForm(args[2]),args[3],Book.getTablename());
					PrintingBooks.PrintBooks(ls);
					break;
					
				}
				case "-byPartTit":
				{
					List<BookInfo> ls=new ArrayList<BookInfo>();
					ls=so.seach_by_partialTitle(args[2],Book.getTablename());
					PrintingBooks.PrintBooks(ls);
					break;
					
				}
				}
				break;
			}
			case "-Update":
			{
					UpdateBook.update(args, Book.getFilename(),Book.getTablename());
					break;	
			}
			case "-UpdateInt":
			{
				bd.updateBookforInt(args,Book.getTablename());
				break;
			}
			
			case "-Sort":
			{
				SortBooks.Sort(args,Book.getTablename());
				break;
			}
			case "-print":
			{
				lib.importFromDb();
				switch (args[1]) {
				case "books":
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
					lib.printBooks();
					System.out.printf("+%8s+%29s+%30s+%14s+%10s+%10s+", "-----------", "-----------------------------",
							"------------------------------", "--------------------", "--------------",
							"-----------");
					System.out.println();
					break;
				
				}
				break;
			}
			
			case "-Customer":
			{
				Customer.SellBook();
				break;
			}
			case "-Credits":
			{
				System.out.println("Contributors: \n");
		        System.out.println("Jayam.Phani Naga Preetham ,");
		        System.out.println("Abhinav Mars ,");
		        System.out.println("Putta. Narasimha ,");
		        System.out.println("Kamapara.Chaitanya ,");
		        System.out.println("Shruthi\n\n\n");
		        break;
			}
			default:
				System.out.println("oops! syntax error");
				break;
				
			
			}
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Unknown error occured! (Could be Wrong number of inputs)\n");

		}

	}
}
