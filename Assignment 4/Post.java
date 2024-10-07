import java.util.Date;
import java.io.Serializable;

public class Post implements java.io.Serializable{

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