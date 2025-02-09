import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class Document {

	private String title;
	private String publisher;
	private String publishedCity;
	private double averageRating;
	private String description;
	private int numPages;
	private String text;
	private String[] tags;
	private List<Comment> comments = new ArrayList<Comment>();
	private int totalRating;
	private int numRatings;
	private boolean isPublic;
	private int id;
	
	
	public Document(String filepath, boolean isPublic, int id) throws FileNotFoundException
	{
		File file = new File(filepath);
		Scanner sc = new Scanner(file);
		title = sc.nextLine();
		publisher = sc.nextLine();
		publishedCity = sc.nextLine();
		description = sc.nextLine();
		tags = sc.nextLine().split(",");
		this.isPublic = isPublic;
		numPages = sc.nextInt();
		sc.nextLine();
		text = "";
		this.id = id;
		
		while (sc.hasNext()) 
		{
			text += sc.nextLine() + "\n";
		}
		totalRating = 0;
		numRatings = 0;
		sc.close();
	}
	
	//display file based on filename(in console)
	public void displayFile()
	{
		System.out.print(text);
	}
	
	//make document accessible
	public void makePublic()
	{
		isPublic = true;
	}
	
	public boolean getIsPublic()
	{
		return isPublic;
	}
	
	//return tags on a document
	public String[] returnTags()
	{
		return tags;
		
	}
	
	public void recieveRating(int rating)
	{
		numRatings++;
		totalRating += rating;
		averageRating = totalRating/numRatings;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String[] getTags()
	{
		return tags;
	}

	public int getId() {
		return id;
	}

	public String getText() {
		// TODO Auto-generated method stub
		return text;
	}

	public void addComment(String comment, User currentUser) {
		comments.add(new Comment(comment, currentUser));
		
	}

	public List<Comment> getComments() {
		// TODO Auto-generated method stub
		return comments;
	}
}
