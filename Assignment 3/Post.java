import java.util.Date;

public class Post {

	protected Date timestamp;
	protected String user;
	protected String postcontent;
	
	public Post (String auser, String content) {
		user = auser;
		postcontent = content;
		timestamp = new Date(); 
	}

	public Date getDate() {
		return timestamp;
	
	}	

}