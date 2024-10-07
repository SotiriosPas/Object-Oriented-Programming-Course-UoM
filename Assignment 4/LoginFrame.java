import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.Serializable;

public class LoginFrame extends JFrame{

	private JPanel panel;
	private JTextField nameField;
	private JButton EnterButton;
	private JButton BackButton;
	
	public LoginFrame() {
		
		panel = new JPanel();
		nameField = new JTextField(12);	
		EnterButton = new JButton("Enter");
		BackButton = new JButton("Back");
		
		panel.add(nameField);
		panel.add(EnterButton);
		panel.add(BackButton);
		
		ButtonListener listener = new ButtonListener();
		EnterButton.addActionListener(listener);
		BackButton.addActionListener(listener);
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setTitle("Είσοδος Χρήστη");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == EnterButton) {
			
				String name = nameField.getText();
				User x = Registry.logincheck(name);
				if(x!=null){
					dispose();
					new UserFrame(x);
				}
				else{
					new LogInFailFrame(name);
				}
			}
			else {
				dispose();
				new WelcomePage();
			}	
		}
	}	
}
