package CustomerClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ConnectionToSql.DataBaseConnect;
import ProjectHelp.Help;

public class UpdateDatabase {
	public static void updateBookforInt(String c,int val1,String Att,String val2, String tableName) throws SQLException
	{
		Connection con=DataBaseConnect.connect();
		String query = "update " + tableName + " set " +  Help.ShortForm(c)  + " = ?" +  " where " + Help.ShortForm(Att) +  " = " + "?";
        try(PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, Integer.valueOf(val1));
            ps.setString(2, val2);
           int upd = ps.executeUpdate();
           System.out.println(upd + " rows have been updated");
            con.close();
        }
        catch(Exception e){
            e.getLocalizedMessage();
        }
	}

}
