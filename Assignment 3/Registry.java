import java.util.ArrayList;

public class Registry {

	private static ArrayList<User> registry;
	
	public Registry() {
		registry = new ArrayList<User>();
	}
	
	public void addtoReg(User auser){
		registry.add(auser);
	}
	
	public static User logincheck(String name) {
		for (User auser : registry) {
			if(name.equals(auser.name)) return auser;
		}
		return null;
	}
}