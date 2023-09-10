package BookClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import ConnectionToSql.DataBaseConnect;
import MainApplication.BookStoreManagement;

public class Library {

    ArrayList<BookInfo> BList = new ArrayList<>();

    public void importFromDb() throws SQLException{
   	    Connection con=DataBaseConnect.connect();

         PreparedStatement stm=con.prepareStatement("select *from books");
         ResultSet rs=stm.executeQuery();

         while(rs.next()){
       	  BookInfo bookinf=new BookInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6));
             BookStoreManagement.lib.BList.add(bookinf);
         }         
    }


 public void printBooks(){
              Iterator<BookInfo> itr=BookStoreManagement.lib.BList.iterator();

              while(itr.hasNext())
              System.out.println(itr.next());
               
         }

         
}