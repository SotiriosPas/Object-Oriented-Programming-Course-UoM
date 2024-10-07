import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.io.Serializable;

public class UserFrame extends JFrame{

	private JPanel panel;
	private JButton backtologin;
	private JButton post;
	private JButton addfriend;
	private JButton joingroupbutton;
	private JTextField postfield;
	private JTextField username;
	private JTextField usersemail;
	private JTextField addfriendfield;
	private DefaultListModel postsmodel;
	private DefaultListModel friendsmodel;
	private DefaultListModel groupsmodel;
	private JList frontpage;
	private JList sugfrlist;
	private JList grouplist;
	private JLabel suggestedfr;
	private JLabel recentposts;
	private ArrayList<Group> groups;
	private User loggedinuser;
	
	public UserFrame(User user) {
		
		loggedinuser = user;
		panel = new JPanel();
		backtologin = new JButton("Back to Login");
		post = new JButton("Post");
		addfriend = new JButton("Add as Friend");
		joingroupbutton = new JButton("Join Group");
		postfield = new JTextField(30);
		username = new JTextField(user.name);
		usersemail = new JTextField(user.email);
		addfriendfield = new JTextField(13);
		suggestedfr = new JLabel("Suggested Friends");
		recentposts = new JLabel("Recent Posts by Friends");
		sugfrlist = new JList();
		frontpage = new JList();
		grouplist = new JList();
		postsmodel = new DefaultListModel();
		frontpage.setModel(postsmodel);
		friendsmodel = new DefaultListModel();
		sugfrlist.setModel(friendsmodel);
		groupsmodel = new DefaultListModel();
		grouplist.setModel(groupsmodel);
		
		ButtonListener listener = new ButtonListener();
		backtologin.addActionListener(listener);
		post.addActionListener(listener);
		addfriend.addActionListener(listener);
		joingroupbutton.addActionListener(listener);
		
		Registry.userloggedin(user);
		groups = Registry.getgroups();
		
		user.createfrontpage();
		String allposts = "";
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		for(Post post : user.frontpage) {
			java.util.Date tempdate = post.timestamp;
			String tempname = post.user;
			String temppost = post.postcontent;
			String tempdatestr = df.format(tempdate);
			allposts = allposts.concat(tempname);
			allposts = allposts.concat(", ");
			allposts = allposts.concat(tempdatestr);
			allposts = allposts.concat(", ");
			allposts = allposts.concat(temppost);
			postsmodel.add(0, allposts);
			allposts = "";
		}
		
		user.findsuggestedfriends();
		for(String friend : user.suggestedfriends) {
			friendsmodel.addElement(friend);
			}
		
		for (Group group : groups){
			groupsmodel.addElement(group.name);
		}
		
		panel.add(username);
		panel.add(usersemail);
		panel.add(backtologin);
		panel.add(recentposts);
		panel.add(frontpage);
		panel.add(postfield);
		panel.add(post);
		panel.add(suggestedfr);
		panel.add(sugfrlist);
		panel.add(addfriendfield);
		panel.add(addfriend);
		panel.add(grouplist);
		panel.add(joingroupbutton);
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setTitle("Σελίδα Χρήστη");
		this.setSize(800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == backtologin) {
				dispose();
				postsmodel.clear();
				friendsmodel.clear();
				new LoginFrame();
		}
			else if(e.getSource() == addfriend) {
				String aname = addfriendfield.getText();
				User flag = Registry.addfriendfunction(aname);
				if (loggedinuser.name.equals(aname) && flag!=null) {
						System.out.println("A user cannot be friends with themselves!");
						new AddFriendErrorFrame1();
						flag = null;
				}
				if (flag!=null){
				for (int x = 0; x < loggedinuser.friends.size(); x++){
					User temp = loggedinuser.friends.get(x);
					if ((aname.equals(temp.name))) {
						System.out.println("You are already friends with this person!");	
						new AddFriendErrorFrame2();
						flag = null;
						break;
					}
				}
			}
				if (flag!=null){
					loggedinuser.addfriend(flag);
					new AddFriendSuccessFrame(aname);
				}
		}
			else if(e.getSource() == joingroupbutton){
			String groupchosen = (String) grouplist.getSelectedValue();
			for (Group group : groups){
				if (group.name.equals(groupchosen)) {
					group.joingroup(loggedinuser);
				}		
			}
		}
			else{
				String postcontent = postfield.getText();
				loggedinuser.createfrontpage();
				loggedinuser.createpost(postcontent);
				String apost = "";
				Date timestamp = new Date(); 
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				java.util.Date tempdate = timestamp;
				String tempname = loggedinuser.name;
				String temppost = postcontent;
				String tempdatestr = df.format(tempdate);
				apost = apost.concat(tempname);
				apost = apost.concat(", ");
				apost = apost.concat(tempdatestr);
				apost = apost.concat(", ");
				apost = apost.concat(temppost);
				postsmodel.add(0, apost);
			}
		}
	}
}