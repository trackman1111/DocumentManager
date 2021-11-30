
public class Comment {
	private User currUser;
	private String comment;
	
	public Comment(String comment, User currUser) {
		this.currUser = currUser;
		this.comment = comment;
	}
	
	public String toString()
	{
		return currUser.toString() + "\n" + comment;
	}
}
