package BookClass;

public class Book extends BookInfo {
	private static final String FileName = "books.csv";
    private static final String TableName = "Books";
	public static String getFilename() {
		return FileName;
	}
	public static String getTablename() {
		return TableName;
	}
	public Book(String book_Id, String title, String author, String genre, double price, int copies) {
		super(book_Id, title, author, genre, price, copies);
		
	}
    

}
