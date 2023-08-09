package gui;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class LoginGui {

	public static void main(String[] args) {
		loginGui();
	}

	public static void loginGui() {
		JFrame jf = new JFrame("Login");
		jf.setSize(400, 250);
		jf.setLocationRelativeTo(null);
		jf.setLayout(new FlowLayout(FlowLayout.LEFT));

		JLabel nameLable = new JLabel("Username:");
		JTextField text = new JTextField("Please input username...", 30);
		jf.add(nameLable);
		jf.add(text);

		JLabel pwdLable = new JLabel("Password:");
		JPasswordField jp = new JPasswordField("Please input password...", 30);
		jf.add(pwdLable);
		jf.add(jp);

		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}
}
