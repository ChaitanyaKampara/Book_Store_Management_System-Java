package ShopOperations;

import java.io.IOException;

import BookClass.BookDbms;
import BookClass.BookInfo;
import HandlingFiles.AddToFile;
import HandlingFiles.CsvToDatabaseInsert;
import ProjectHelp.Help;
public class CreateBook {
	public static int create(String args[],String filename,String Tablename) throws IOException
	{
		BookDbms bd=new BookDbms();
		if(args.length==2)
		{
			CsvToDatabaseInsert.InsertData();
			System.out.println("Present Books Count is:"+bd.BooksCount(Tablename));
		}
		else if(args.length==8)
		{
			BookInfo b=new BookInfo(args[2],args[3],args[4],args[5],Double.valueOf(args[6]),Integer.valueOf(args[7]));
			bd.createBook(b, Tablename);	
			int result= AddToFile.addtofile(filename, b);
			if(result==1)
			{
				System.out.println("In Table "+Tablename+" "+b.getTitle()+" has been inserted");
				
			}
			System.out.println("Present Count: "+bd.BooksCount(Tablename));
		}
		else 
		{
			System.out.println("Arguements are not sufficient to insert");
			Help.PrintCreateHelp();
		}
		return 0;
	}

}
