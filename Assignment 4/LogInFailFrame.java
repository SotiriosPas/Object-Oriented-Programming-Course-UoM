import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class LogInFailFrame extends JFrame{
	
	private JPanel panel;
	private JLabel label1;
	private JButton button;
	
	public LogInFailFrame(String name) {

		panel = new JPanel();
		label1 = new JLabel("User " + name + " not found.");
		button = new JButton("OK");
		
		panel.add(label1);
		panel.add(button);
		
		ButtonListener listener = new ButtonListener();
		button.addActionListener(listener);
		
		this.setContentPane(panel);
	
		this.setVisible(true);
		this.setTitle("Message");
		this.setSize(200, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//System.exit(0);
			dispose();
		}
	}
}