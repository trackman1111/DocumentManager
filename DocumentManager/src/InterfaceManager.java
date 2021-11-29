import java.io.FileNotFoundException;
import java.util.*;

public class InterfaceManager {
	
	private static List<Document> documents;

	public static void main(String[] args) throws FileNotFoundException
	{
		//Initialize Documents and Scanner
		documents = createDocuments();
		for (Document doc : documents) {
			if(!doc.getIsPublic())
			{
				documents.remove(doc);
			}
		}
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
		User currentUser = new User(username, birthday, documents);		
		System.out.println("Created User:" + currentUser);
		
		//Loop Through Options
		while (!option.equals("q")){
			System.out.println("Enter an option(q to exit): " );
			option = sc.nextLine();
		}
		System.out.println("Exited");
		sc.close();
		
		
	}
	
	//Create Document List
	public static List<Document> createDocuments() throws FileNotFoundException
	{
		Document docOne = new Document("DocumentOne.txt");
		Document docTwo = new Document("DocumentTwo.txt");
		Document docThree = new Document("DocumentTwo.txt");
		System.out.println(docOne.getTitle());
		Document[] documents = {docOne, docTwo, docThree};
		return Arrays.asList(documents);
	}
}
