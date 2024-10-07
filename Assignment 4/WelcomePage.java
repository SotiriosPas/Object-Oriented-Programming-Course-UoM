import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.Serializable;


public class WelcomePage extends JFrame{	

	private JPanel panel;
	private JTextField username;
	private JTextField email;
	private JButton signup;
	private JButton login;
	private JButton savestate;
	
	public WelcomePage() {
	
	panel = new JPanel();
	email = new JTextField("email χρήστη");
	username = new JTextField("όνομα χρήστη");
	signup = new JButton("Δημιουργία Χρήστη");
	login = new JButton("Είσοδος Χρήστη");
	savestate = new JButton("Αποθήκευση PamakBook");
	
	ButtonListener listener = new ButtonListener();
	signup.addActionListener(listener);
	login.addActionListener(listener);
	savestate.addActionListener(listener);
	
	panel.add(signup);
	panel.add(username);
	panel.add(email);
	panel.add(login);
	panel.add(savestate);
	
	this.setContentPane(panel);
	
	this.setVisible(true);
	this.setTitle("Κεντρική Σελίδα");
	this.setSize(335,160);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == login) {
				dispose();
				new LoginFrame();
			}
			else if (e.getSource() == signup) {
				String aname = username.getText();
				String anemail = email.getText();
				Registry.createnewuser(aname, anemail);
				
			}
			else {
				Registry.Serialization1();
				Registry.Serialization2();
			}
		}
	}
}