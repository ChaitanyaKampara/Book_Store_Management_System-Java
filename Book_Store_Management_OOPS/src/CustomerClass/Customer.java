package CustomerClass;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import BookClass.Book;
import BookClass.BookInfo;
import ConnectionToSql.DataBaseConnect;
import HandlingFiles.AddtoCustomerCsv;
import ShopOperations.SearchingOperations;

public class Customer 
{
	private int Cust_Id;
	private String Name;
	private String phNo;
    private String place;
    private BookInfo b; //Composition
    public int getCust_Id(){
    	return Cust_Id;
    }
    public void setCust_Id(int cust_id)
    {
    	this.Cust_Id=cust_id;
    }
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhNo() {
		return phNo;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public void setBookInfo(BookInfo b)
	{
		this.b=b;
	}
	public BookInfo getBookInfo()
	{
		return b;
	}
	
	public Customer() {
		
	}
	
	public Customer(int cust_id,String name, String phNo, String place) {
		this.Cust_Id=cust_id;
		this.Name = name;
		this.phNo = phNo;
		this.place = place;
	}
	
	public static Customer customerDetails() throws SQLException
	{
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		Customer c=new Customer();
		System.out.println("Enter your name:");
		String name=sc.nextLine();
		c.setName(name);
		int idset=0;
		Connection con=DataBaseConnect.connect();
		String query="Select max(Cust_Id) from customer";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		if(rs.next())
		{
			idset=rs.getInt(1);
		    ++idset;
		}
		c.setCust_Id(idset);
		
		System.out.println("Enter your Phone Number:");
		String phno=sc.nextLine();
		c.setPhNo(phno);
		System.out.println("Enter Your place name:");
		String place=sc.nextLine();
		c.setPlace(place);
		return c;
		
		
	}
	public static BookInfo Required_Book()
	{
		BookInfo bi = null;
		SearchingOperations so=new SearchingOperations();
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the book title that you want:");
		String Title=sc.nextLine();
		List<BookInfo> bs=new ArrayList<>();
		bs=so.seach_by_partialTitle(Title,Book.getTablename());
		bi=bs.get(0);
		return bi;
	}
	
	public static void SellBook() throws SQLException, IOException
	{
		double gst=0;
		double totalPrice=0;
		Customer c=customerDetails();
		BookInfo b=Required_Book();
		c.setBookInfo(b);
		String filename="C:\\Users\\Dell\\eclipse-workspace\\OOPS_Project_Java\\customer.csv";
		CreateCustomerInDatabase.createCustomer(c, b, "customer");
		int result= AddtoCustomerCsv.addtofile(filename, b, c);
		if(result==1){
			System.out.println("In Table Customer "+c.getName()+" has been inserted");
		}
		SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		java.util.Date d=new java.util.Date();
		Calendar ca=Calendar.getInstance();
		String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };  

		if(b!=null)
		{
			System.out.println("-------------------------------------------------------INVOICE----------------------------------------------------");
			System.out.println(" \t\t\t\t\t          BookStore Mangement                  ");
			System.out.println("\t\t\t\t\t               Sricity                           ");
			System.out.println("Date: "+sd.format(d)+"  "+days[ca.get(Calendar.DAY_OF_WEEK) - 1]+"\t\t\t\t\t\t (+91) 9998887770");
			System.out.println("-------------------------------------------------------------------------------------------------------------------");
			System.out.println("Book_Id \t\t Title\t\t Name\t\t\tPhoneNo\t\t     Price");
			System.out.println(c.b.getBook_Id()+"\t\t\t"+c.b.getTitle()+"\t\t"+c.getName()+"\t\t"+c.getPhNo()+" \t     "+c.b.getPrice());
			//calculating tax
			gst=c.b.getPrice()*12/100;
			totalPrice=c.b.getPrice()+gst;
			System.out.println("\t\t\t\t\t\t\t\t\t             GST(%):"+gst);
			System.out.println("\t\t\t\t\t\t\t\t\t             Invoice Total " +totalPrice);
			System.out.println("-----------------------------------------------Thank You for Shopping!!---------------------------------------------");  
            System.out.println("\t\t\t\t\t\t    Visit Again ");
		}
		else{
			System.out.println("Book is Not present in our database");
		}
		int a=b.getNo_of_Copies()-1;
		
		UpdateDatabase.updateBookforInt("c",a,"id",b.getBook_Id(), Book.getTablename());
		
	}
	
    
}
