package HandlingFiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class DeleteAllInCSVFile {
	public static void deleteeverything(String filename)
	{
		try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
            printWriter.println(" ");
            System.out.println("Deleted all data in csv");
            printWriter.close();
        } 
        catch(Exception e)
        {
        e.getLocalizedMessage();
        }	
	}

}
