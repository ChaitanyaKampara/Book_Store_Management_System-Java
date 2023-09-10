package ShopOperations;

import java.sql.SQLException;
import java.util.List;

import BookClass.BookDbms;
import BookClass.BookInfo;
import ProjectHelp.Help;

public class SortBooks {
	public static void Sort(String[] args,String Tablename) throws SQLException
	{
		if(args[1].equals("id")||args[1].equals("Tit")||args[1].equals("Aut")||args[1].equals("Gen")||args[1].equals("p") )
		{
			if(args[2].equals("i")|| args[2].equals("d"))
			{
				BookDbms bd=(new BookDbms());
				List<BookInfo> b=bd.sortBookByAtt(Help.ShortForm(args[1]), Help.ShortForm(args[2]), Tablename);
				if(b!=null)
				{
					PrintingBooks.PrintBooks(b);
				}
				else
				{
					System.out.println("Entered wrong arguements args[2]");
				}
			}
			else
			{
				System.out.println("Entered wrong arguements args[1]");
				
			}
		}
		else
		{
			Help.PrintSortHelp();
		}
	}

}
