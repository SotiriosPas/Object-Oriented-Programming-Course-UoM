import java.util.ArrayList;
import java.lang.StackTraceElement;

public class User {

	String name;
	String email;
	ArrayList<User> friends;
	ArrayList<Group> joinedgroups;
	
	public User (String aname, String anemail) {
		if (anemail.startsWith("it") && anemail.matches("(.*)uom.edu.gr"))
			email = anemail;
		else {
			System.out.println("User " + aname + " has not been created. Email format is not acceptable.");
			return;
		}
		name = aname;
		friends = new ArrayList<User>();
		joinedgroups = new ArrayList<Group>();	
	}
	
	public boolean friendcheck (User auser) {
		User temp = null;
		if ((auser.name.equals(this.name)) && (auser.email.equals(this.email))) {
				System.out.println("A user cannot be friends with themselves!");
				return true;
		}
		for (int x = 0; x < this.friends.size(); x++){
			temp = this.friends.get(x);
			if ((auser.name.equals(temp.name)) && (auser.name.equals(temp.name))) {
					return true;
			}
		}
			return false;
	}
	
	public void addfriend (User auser) {
		boolean x = friendcheck(auser);
		if (x) return;
		else {
			friends.add(auser);
			auser.friends.add(this);
			System.out.println(auser.name + " and " + this.name + " are now friends!");
		}
	}
	
	public ArrayList<User> printcommonfriends(User auser) {
		ArrayList<User> commonfriends = new ArrayList<User>(); 
		User temp1 = null,temp2 = null;
		for (int x = 0; x < this.friends.size(); x++) {
			temp1 = this.friends.get(x);
			for (int i = 0; i < auser.friends.size(); i++) {
				temp2 = auser.friends.get(i);
				if (temp1.name.equals(temp2.name) && temp1.email.equals(temp2.email))
					commonfriends.add(temp1);
			}
		}
		Throwable t = new Throwable();
		StackTraceElement[] elements = t.getStackTrace(); 
		String caller = elements[1].getClassName(); 
		if (caller.equals("Main")) {
			System.out.println("**************************************");
			System.out.println("Common friends of " + this.name + " and " + auser.name);
			System.out.println("**************************************");
			for (int x = 0; x < commonfriends.size(); x++) {
				temp1 = commonfriends.get(x);
				System.out.println((x+1) + ": " + temp1.name);
			}
		System.out.println("--------------------------------------");
		}
		return commonfriends;
	}
	
	public void printallfriends() {
		User temp1 = null;
		System.out.println("************************");
		System.out.println("Friends of " + this.name);		
		System.out.println("************************");
		for (int x = 0; x < this.friends.size(); x++) {
					temp1 = this.friends.get(x);
					System.out.println(x+1 + ": " + temp1.name);
		}			
					System.out.println("-----------------------");			
	}
	
	public void printusersgroups() {
		System.out.println("**************************************");
		System.out.println("Groups that " + name + " has been enrolled in");
		System.out.println("**************************************");
		Group temp = null;
		for (int x = 0; x < joinedgroups.size(); x++){
			temp = joinedgroups.get(x);
			System.out.println((x+1) + ": " + temp.name);
		}	
		System.out.println("--------------------------------------");
	}
}