package HandlingFiles;

import java.io.BufferedReader;
import java.io.FileReader;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ConnectionToSql.DataBaseConnect;

public class CsvToDatabaseInsert {
	public static void InsertData()
	{
		try{
			Connection con=DataBaseConnect.connect();
			BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\Dell\\eclipse-workspace\\OOPS_Project_Java\\books.csv"));
			String line=br.readLine();
			int res = 0;
			while((line=br.readLine())!=null)
			{
				String[] data=line.split(",");
				String query="Insert into books values(?,?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1,data[0]);
				ps.setString(2,data[1]);
				ps.setString(3,data[2]);
				ps.setString(4,data[3]);
				ps.setDouble(5,Double.valueOf(data[4]));
				ps.setInt(6,Integer.valueOf(data[5]));
				res=ps.executeUpdate();
				System.out.println(res+" rows have been effected");
			}
			
			System.out.println("Data from csv file inserted into database");
			br.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		

	}

}
