import java.util.ArrayList;

public class ClosedGroup extends Group {

	public ClosedGroup(String aname, String desc){
		super(aname,desc);
		members = new ArrayList<User>();
	}
	
	public void joingroup(User auser){
		if (members.size()==0) {
			members.add(auser);
			auser.joinedgroups.add(this);
			System.out.println(auser.name + " has been successfully enrolled in group " + name);
		}
		else {
			User temp = null;
			for (int i = 0; i < members.size(); i++){
				temp = members.get(i);
				boolean x = auser.friendcheck(temp);
				if (x) {
					members.add(auser);
					System.out.println(auser.name + " has been successfully enrolled in group " + name);
					auser.joinedgroups.add(this);
					return;
				}
			}
			System.out.println("FAILED: " + auser.name + " cannot be enrolled in group " + name);
		}
	
	}
			
		
}