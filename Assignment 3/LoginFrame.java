import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginFrame extends JFrame{

	private JPanel panel;
	private JTextField nameField;
	private JButton EnterButton;
	
	public LoginFrame() {
		
		panel = new JPanel();
		nameField = new JTextField("Please enter your name", 12);	
		EnterButton = new JButton("Enter");
		
		panel.add(nameField);
		panel.add(EnterButton);
		
		ButtonListener listener = new ButtonListener();
		EnterButton.addActionListener(listener);
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setTitle("Είσοδος Χρήστη");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = nameField.getText();
			User x = Registry.logincheck(name);
			if(x!=null){
				dispose();
				new UserFrame(x);
			}
			else{
				new ErrorFrame(name);
			}
		}
	}
	
		
}
