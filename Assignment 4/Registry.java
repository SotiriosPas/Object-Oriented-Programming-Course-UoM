import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Registry {

	private static ArrayList<User> registry;
	private static User loggedinuser;
	private static ArrayList<Group> allgroups;
	
	public Registry(){
	}
	
	public static void createreg(){
		registry = new ArrayList<>();
		allgroups = new ArrayList<>();
	}
	
	public static void addgroupinlist(Group group){
		allgroups.add(group);
	}
	
	public static void userloggedin(User user){
		loggedinuser = user;
	}
	
	public static void addtoReg(User auser){
		registry.add(auser);
	}
	
	public static User logincheck(String name) {
		for (User auser : registry) {
			if(name.equals(auser.name)) return auser;
		}
		return null;
	}
	
	public static void createnewuser(String aname,String anemail){
		boolean flag1 = true;
		for(User auser : registry){
			if(auser.name.equals(aname)){
				new SignUpNameFailFrame(aname);
				flag1 = false;
				break;
			}
		}
		if (flag1==true) {
			User temp = new User(aname, anemail);
			if (temp.name.equals(aname)) {
				registry.add(temp);
				System.out.println("success!");
				new SignUpSuccessFrame(aname);
			}
		}
	}
	
	public static User addfriendfunction(String aname){
		User flag = null;
		for (User x : registry){
			if(x.name.equals(aname)){
			flag = x;	
			return flag;
			}
		}
		if (flag==null) 
			new AddFriendErrorFrame3();
			return flag;
	}

	public static ArrayList<Group> getgroups() {
		return allgroups;
	}
	
	public static void Serialization1(){
		try {
			FileOutputStream fileOut = new FileOutputStream("registry.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(registry);
			out.close();
			fileOut.close();		
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		finally {
			System.out.println("First Serialization Attempted...");
		}
	}
	
	public static void Serialization2(){
		try {
			FileOutputStream fileOut = new FileOutputStream("groups.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(allgroups);
			out.close();
			fileOut.close();		
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		finally {
			System.out.println("Second Serialization Attempted...");
		}
	}
	
	public static void Deserializing1() {
		try {
			FileInputStream fileIn = new FileInputStream("registry.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Registry.registry = (ArrayList<User>) in.readObject();
			in.close();
			fileIn.close();		
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		finally {
			System.out.println("First De-Serialization Attempted...");
		}
		
	}
	
	public static void Deserializing2() {
		try {
			FileInputStream fileIn = new FileInputStream("groups.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Registry.allgroups = (ArrayList<Group>) in.readObject();
			in.close();
			fileIn.close();		
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		finally {
			System.out.println("Second De-Serialization Attempted...");
		}
		
	}
		
}