package BookClass;
import java.util.Iterator;
import java.util.List;

//This is the main Book Class 
public class BookInfo {
	private String Book_Id;
	private String Title;
	private String Author;
	private String Genre;
	private double price;
    private int No_of_Copies;
	public int getNo_of_Copies() {
		return No_of_Copies;
	}

	public void setNo_of_Copies(int no_of_Copies) {
		No_of_Copies = no_of_Copies;
	}

	public String getBook_Id() {
		return Book_Id;
	}

	public void setBook_Id(String book_Id) {
		Book_Id = book_Id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
    public BookInfo()
    {
    	
    }
	public BookInfo(String book_Id, String title, String author, String genre, double price,int copies) {

		this.Book_Id = book_Id;
		this.Title = title;
		this.Author = author;
		this.Genre = genre;
		this.price = price;
		this.No_of_Copies=copies;
	}
	
	@Override
	public String toString()
	{
	   return String.format("|%10s|%30s|%30s|%20s|%14s|%11s|",Book_Id,Title,Author,Genre,price,No_of_Copies );	
	}
	public static void printBooks(List<BookInfo> lis){
        Iterator<BookInfo> itr=lis.iterator();
        while(itr.hasNext())
        System.out.println(itr.next());
         
   }
	

}
