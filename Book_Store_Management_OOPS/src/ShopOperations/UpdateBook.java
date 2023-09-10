package ShopOperations;

import java.io.IOException;
import java.sql.SQLException;

import ProjectHelp.Help;

public class UpdateBook {
	public static void update(String args[], String fileName, String tableName) throws SQLException, IOException {
		
		if(args.length==6 && args[3].equals("where"))
		{
			if((args[1].equals("id") ||args[1].equals("Tit")||args[1].equals("Aut")||args[1].equals("Gen")||args[1].equals("p"))
					&&(args[4].equals("id") ||args[4].equals("Tit")||args[4].equals("Aut")||args[4].equals("Gen")||args[4].equals("p")))
			{    
					UpdateBookInDatabase.updateBook(args, tableName);
					
			}
			
		}
		else
		{
			Help.PrintUpdateHelp();
		}
	}

}
