import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserFrame extends JFrame{

	private JPanel panel;
	private JButton backtologin;
	private JButton post;
	private JTextField postfield;
	private JTextField frontpage;
	
	
	public UserFrame(User user) {
		
		user.createfrontpage();
		String allposts = "";
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		for(Post post : user.frontpage){
			java.util.Date tempdate = post.timestamp;
			String tempname = post.user;
			String temppost = post.postcontent;
			String tempdatestr = df.format(tempdate);
			allposts.concat(tempname);
			allposts.concat(",");
			allposts.concat(tempdatestr);
			allposts.concat(",");
			allposts.concat(temppost);
			allposts.concat("\n");	
		}
		
		frontpage = new JTextField(allposts, 50);
		panel = new JPanel();
		backtologin = new JButton("Back to Login");
		post = new JButton("Post");
		postfield = new JTextField(30);
		postfield.setPreferredSize(new Dimension(400, 200));
		
		panel.add(backtologin);
		panel.add(post);
		panel.add(postfield);
		panel.add(frontpage);
		
		ButtonListener listener = new ButtonListener(user);
		backtologin.addActionListener(listener);
		post.addActionListener(listener);
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setTitle("Σελίδα Χρήστη");
		this.setSize(900, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener {
		public User temp;
		public ButtonListener(User user) {
			super();
			User temp = user;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == backtologin) {
				dispose();
				new LoginFrame();
		}
			else{
				String postcontent = postfield.getText();
				temp.createpost(postcontent);
				temp.createfrontpage();
			}
		}
	}
}