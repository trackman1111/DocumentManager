import java.io.FileNotFoundException;
import java.util.*;

public class InterfaceManager {
	
	private static List<Document> documents;

	public static void main(String[] args) throws FileNotFoundException
	{
		//Initialize Documents and Scanner
		documents = createDocuments();
		Scanner sc = new Scanner(System.in);
		
		
		//Create User Account
		System.out.print("Enter a username: ");
		String username = sc.nextLine();
		System.out.print("Enter month of birth(number): " );
		int month = sc.nextInt();		
		System.out.print("Enter day of birth(number): " );
		int day = sc.nextInt();		
		System.out.print("Enter year of birth(number): " );
		int year = sc.nextInt();	
		String option = "None";
		Calendar birthday = Calendar.getInstance();
		birthday.set(Calendar.YEAR, year);
		birthday.set(Calendar.DATE, day);
		birthday.set(Calendar.MONTH, month - 1);
		User currentUser = new User(username, birthday);		
		System.out.println("\nCreated User:\n" + currentUser);
		sc.nextLine();
		
		//Loop Through Options
		while (!option.equals("q")){
			System.out.println("\nEnter an option: \n1:Search by name\n2:Search by tag\n3:Display Documents(id)\n4:Display all Documents" );
			option = sc.nextLine();
			if (option.equals("1"))
			{
				System.out.println("Enter a title to search for: ");
				displaySearch(currentUser.searchName(sc));
			}
			else if (option.equals("2"))
			{
				System.out.println("Enter a tag to search for: ");
				displayTagged(currentUser.searchTags(sc));
			}
			else if (option.equals("4"))
			{
				System.out.println("All Documents: ");
				displayDocs(documents);
			}
			else {
				System.out.println("Invalid Option...");
			}
			
		}
		System.out.println("Exited");
		sc.close();
		
	}
	
	public static void displayTagged(String tag) {
		List<Document> foundDocs = new ArrayList<Document>();
		for (Document doc : documents) {
			if(Arrays.asList(doc.getTags()).contains(tag))
			{
				foundDocs.add(doc);
			}
		}
		displayDocs(foundDocs);
	}
	
	public static void displaySearch(String name) {
		List<Document> foundDocs = new ArrayList<Document>();
		for (Document doc : documents) {
			if(doc.getTitle().contains(name))
			{
				foundDocs.add(doc);
			}
		}
		displayDocs(foundDocs);
	}
	
	private static void displayDocs(List<Document> foundDocs) {
		for ( Document doc : foundDocs ) {
			System.out.println(doc.getId() + ": " + doc.getTitle());
		}
		
	}

	//Create Document List
	public static List<Document> createDocuments() throws FileNotFoundException
	{
		Document docOne = new Document("/Users/brandonmorrell/Desktop/SoftwareModeling/DocumentManager/DocumentOne.txt", true, 1);
		Document docTwo = new Document("/Users/brandonmorrell/Desktop/SoftwareModeling/DocumentManager/DocumentTwo.txt", true, 2);
		//Document docThree = new Document("/Users/brandonmorrell/Desktop/SoftwareModeling/DocumentManager/DocumentThree.txt", false);
		Document[] documents = {docOne, docTwo};
		return Arrays.asList(documents);
	}
}
