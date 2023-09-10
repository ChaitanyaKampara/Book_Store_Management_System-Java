package ProjectHelp;

public class Help {
	public static String ShortForm(String s){
        String Attribute = null;
        switch(s){
            case "id":
            Attribute = "Book_Id";
            break;
            case "Tit":
            Attribute = "Title";
            break;
            case "Aut":
            Attribute = "Author";
            break;
            case "Gen":
            Attribute = "Genre";
            break;
            case "p":
            Attribute = "price";
            break;
            case "c":
            Attribute="No_of_Copies";
            break;
            case "gt":
            Attribute = ">";
            break;
            case "lt":
            Attribute = "<";
            break;
            case "eq":
            Attribute = "=";
            break;
            case "i":
            Attribute = "ASC";
            break;
            case "d":
            Attribute = "DESC";
            break;
        }
        return Attribute;
    }
	public static void PrintCreateHelp()
	{
		System.out.println("Command Line creation Help");
		System.out.println("Simply enter -create -b followed by arguements");
		System.out.println(" ID  Title AUTHOR GENRE PRICE NoOfCopies");
	}
	public static void PrintDeleteHelp()
	{
		System.out.println("Command Line Deletion Help");	
		System.out.println("Enter -Delete then");
		System.out.println(" for complete deletion enter -all then run");
		System.out.println("Else -b Attribute(Inshort) value then run");
	}
	public static void PrintUpdateHelp()
	{
		System.out.println("Command Line Updation Help");	
		System.out.println("Enter -Update followed by ");
		System.out.println("new Att(Inshort),new Value,where,old Att,old Value");
	}
	public static void PrintSortHelp()
	{
		System.out.println("Command Line Sorting Books Help");	
		System.out.println("Enter -Sort followed by ");
		System.out.println("Attribute(Inshort), 'i' or 'd'");
	}
	
}
