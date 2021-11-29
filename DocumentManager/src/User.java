import java.util.*;

public class User {

	private String name;
	private Calendar dateOfBirth;
	private List<Document> history;
	private List<Document> available;
	
	public User(String name, Calendar dateOfBirth, List<Document> availableDocs) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.available = availableDocs;
	}
	
	//Search Based on Document Title(not file name)
	public List<Document> searchName(String name) {
		List<Document> foundDocs = new ArrayList<Document>();
		for (Document doc : available) {
			if(doc.getTitle().contains(name))
			{
				foundDocs.add(doc);
			}
		}
		return foundDocs;
	}
	
	//Search Based on Document Tags
	public List<Document> searchTags(String tag) {
		List<Document> foundDocs = new ArrayList<Document>();
		for (Document doc : available) {
			if(Arrays.asList(doc.getTags()).contains(tag))
			{
				foundDocs.add(doc);
			}
		}
		return foundDocs;
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
