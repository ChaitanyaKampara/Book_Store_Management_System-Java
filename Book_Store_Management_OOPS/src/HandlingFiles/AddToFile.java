package HandlingFiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import BookClass.BookInfo;

public class AddToFile {
	public  static int CheckBookInfile(String id,String filename) throws IOException
	{
		try
		{
			List<String> data= Files.readAllLines(Paths.get(filename));
			   String[] Arra;
			   for(int i=0;i<data.size();i++)
			   {
				   Arra=data.get(i).split(",");
				   if(Arra[0].equals(id))
				   {
					   return 0;
				   }
			   }
			   return 1;
			
		}
		catch(Exception e)
		{
			e.getLocalizedMessage();
			return -1;
		}
	   
	   
	}
	public static int addtofile(String filename,BookInfo b) throws IOException
	{
		int temp=AddToFile.CheckBookInfile(b.getBook_Id(), filename);
		if(temp==1)
		{
			try {
				PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(filename,true)));
				String add=b.getBook_Id()+","+b.getTitle()+","+b.getAuthor()+","+b.getGenre()+","+b.getPrice()+","+b.getNo_of_Copies();
				pw.println(add);
				pw.close();
				return 1;
			}
			catch(Exception e)
			{
				return -1;
			}
		}
		else if(temp==0)
		{
			System.out.println("Book is already Present");
			return 0;
		}
		else
		{
			System.out.println("Error Occured");
			return -1;
		}
	}

}
