package BookClass;
import java.util.List;
import java.sql.SQLException;
public interface DatabaseOperations 
{
   public void createBook(BookInfo b,String TableName) throws SQLException;
   List<BookInfo> PrintBooks(String TableName) throws SQLException;
   public int BooksCount(String TableName);
   void DeleteBook(String id,String Tablename) throws SQLException;
   public void DeleteBookFromAttribute(String Attribute, String data, String TableName) ;
   void updateBook(String args[], String tableName) throws SQLException;
   public void updateBookforInt(String[] args, String tableName) throws SQLException;
   void truncateTable(String TableName) throws SQLException;
   public List<BookInfo> sortBookByAtt(String Attribute,String order,String TableName) throws SQLException;
   
   
}
