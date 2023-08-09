package gui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Login {

	public static void main(String[] args) {
		login();
	}

	public static void login() {
		JFrame jf = new JFrame("Login");
		jf.setSize(500, 300);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
