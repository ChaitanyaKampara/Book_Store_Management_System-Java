package ShopOperations;
import java.sql.SQLException;

import BookClass.BookDbms;
import HandlingFiles.DeleteAllInCSVFile;
public class DeleteData {
	public static void deletedata(String TableName,String filename) throws SQLException
	{
		//Delete everything from csv File
		DeleteAllInCSVFile.deleteeverything(filename);
//		From database
		(new BookDbms()).truncateTable(TableName);
		System.out.println("Deleted All Data Successfully");
	}

}
