import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<User> commonfriendslist;
		User u1 = new User("Makis", "it1698@uom.edu.gr");
		User u2 = new User("Petros", "it1624@ uom.edu.gr");
		User u3 = new User("Maria", "it16112@uom.edu.gr"); 
		User u4 = new User("Gianna", "it16133@uom.edu.gr");
		User u5 = new User("Nikos", "it1658@uom.edu.gr"); 
		User u6 = new User("Babis", "it16104@uom.edu.gr"); 
		User u7 = new User("Eleni", "eleni1986@gmail.com");
		
		Group g1 = new Group("WebGurus","A group for web passionates"); 
		ClosedGroup g2 = new ClosedGroup("ExamSolutions","Solutions to common exam questions");
		
		u1.addfriend(u2);
		u1.addfriend(u5);
		u5.addfriend(u6);
		u3.addfriend(u4);
		u3.addfriend(u2);
		u4.addfriend(u6);
		u5.addfriend(u3);
		u1.addfriend(u6);
		u5.addfriend(u2);
		
		commonfriendslist = u5.printcommonfriends(u4);
		commonfriendslist = u1.printcommonfriends(u5);
		
		u1.printallfriends();
		u3.printallfriends();
		
		g1.joingroup(u4);
		g1.joingroup(u3);
		g1.joingroup(u2);
		g2.joingroup(u4);
		g2.joingroup(u5);
		g2.joingroup(u6);
		g2.joingroup(u5);
		
		u4.printusersgroups();
		
		g1.printmembers();
		g2.printmembers();

	}


}