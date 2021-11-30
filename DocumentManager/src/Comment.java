
public class Comment {
	private User currUser;
	private String comment;
	
	public Comment(User currUser, String comment) {
		this.currUser = currUser;
		this.comment = comment;
	}
	
	public String toString()
	{
		return currUser.toString() + "\n" + comment;
	}
}
