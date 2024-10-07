import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class SignUpEmailFailFrame extends JFrame{
	
	private JPanel panel;
	private JLabel label1;
	private JButton button;
	
	public SignUpEmailFailFrame(String anemail) {

		panel = new JPanel();
		label1 = new JLabel("The email address " + anemail + " is not accepted. The only email addresses accepted are those provided by Pamak.");
		button = new JButton("OK");
		
		panel.add(label1);
		panel.add(button);
		
		ButtonListener listener = new ButtonListener();
		button.addActionListener(listener);
		
		this.setContentPane(panel);
	
		this.setVisible(true);
		this.setTitle("Error!");
		this.setSize(900, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			dispose();
		}
	}
}