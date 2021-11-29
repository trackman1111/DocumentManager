import java.io.File;
import java.io.FileNotFoundException;
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
	private int totalRating;
	private int numRatings;
	private boolean isPublic;
	
	
	public Document(String filepath) throws FileNotFoundException
	{
		File file = new File(filepath);
		Scanner sc = new Scanner(file);
		title = sc.nextLine();
		publisher = sc.nextLine();
		publishedCity = sc.nextLine();
		description = sc.nextLine();
		tags = sc.nextLine().split(",");
		isPublic = false;
		numPages = sc.nextInt();
		
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
}
