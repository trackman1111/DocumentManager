import java.util.*;

public class User {

	private String name;
	private Calendar dateOfBirth;
	private List<Document> history;
	
	public User(String name, Calendar dateOfBirth) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}
	
	//Search Based on Document Title(not file name)
	public String searchName(Scanner sc) {
		String search = sc.nextLine();
		return search;
	}
	
	//Search Based on Document Tags
	public String searchTags(Scanner sc) {
		String search = sc.nextLine();
		return search;
	}
	
	public void download() {
		//download here
	}
	
	//Print User Info
	public String toString()
	{
		return "User: " + name + " DOB: " + dateOfBirth.getTime();
	}
}
