package ShopOperations;

import BookClass.BookDbms;
import ProjectHelp.Help;

public class DeleteBookFromDatabase {
	public static void delete(String args[],String filename,String TableName)
	{
		BookDbms b=new BookDbms();
		if(args.length==4)
		{
			if(args[2].equals("id")||args[2].equals("Tit")||args[2].equals("Aut")||args[2].equals("Gen")||args[2].equals("p") )
			{
				
				//Deletes in database
				b.DeleteBookFromAttribute(Help.ShortForm(args[2]),args[3], TableName);
				System.out.println("Present Count of Books : "+b.BooksCount(TableName));
			}
			else
			{
				System.out.println("Entred Wrong attribute");
			}
		}
		else
		{
			Help.PrintDeleteHelp();
		}
	}
	

}
