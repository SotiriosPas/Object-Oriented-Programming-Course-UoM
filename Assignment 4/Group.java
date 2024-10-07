import java.util.ArrayList;
import java.io.Serializable;

public class Group implements java.io.Serializable{

	protected String name;
	protected String description;
	protected ArrayList<User> members;
	
	public Group(String aname, String desc) {
		name = aname;
		description = desc;
		members = new ArrayList<User>();
	}
	
	public boolean ismember(User auser){
		for (User members : members){
			if(members.name.equals(auser.name) && members.email.equals(auser.email))
				return true;
		}
		return false;
	}
	
	public void joingroup(User auser){
		boolean x = ismember(auser);
		if (!x) {
			members.add(auser); 
			auser.joinedgroups.add(this);
			System.out.println(auser.name + " has been successfully enrolled in group " + name);
			new JoinGroupSuccessFrame();
		}
		else{
			new JoinGroupErrorFrame1();
		}
		
	}
	
	public void printmembers() {
		System.out.println("*******************************");
		System.out.println("Members of group " + name);
		System.out.println("*******************************");
		User temp = null;
		for (int x = 0; x < members.size(); x++){
			temp = members.get(x);
			System.out.println((x+1) + ": " + temp.name);
		}
		System.out.println("-----------------------------");
	}

}