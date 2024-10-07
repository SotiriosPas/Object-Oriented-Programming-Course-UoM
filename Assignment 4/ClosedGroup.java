import java.util.ArrayList;
import java.io.Serializable;

public class ClosedGroup extends Group {

	public ClosedGroup(String aname, String desc){
		super(aname,desc);
	}
	
	public void joingroup(User auser){
		if (members.size()==0) {
			members.add(auser);
			auser.joinedgroups.add(this);
			System.out.println(auser.name + " has been successfully enrolled in group " + name);
			new JoinGroupSuccessFrame();
		}
		else {
			User temp = null;
			boolean r;
			for (int i = 0; i < members.size(); i++){
				temp = members.get(i);
				boolean x = auser.friendcheck(temp);
				if (x) {
					if (!(r = this.ismember(auser))) {
					members.add(auser);
					System.out.println(auser.name + " has been successfully enrolled in group " + name);
					auser.joinedgroups.add(this);
					new JoinGroupSuccessFrame();
					return;
					}
					else{
						System.out.println("You have already joined this group!");
						new JoinGroupErrorFrame1();
						return;
					}
				}
			}
			System.out.println("FAILED: " + auser.name + " cannot be enrolled in group " + name);
			new JoinGroupErrorFrame2();
		}
	}
				
}