package project.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import base.login.LoginResponse;
import project.client.LoginClient;
import project.grpc.GrpcChannelManager;

public class LoginGui {

	public static void loginGui() {
		JFrame jf = new JFrame("Login");
		jf.setSize(400, 250);
		jf.setLocationRelativeTo(null);
		jf.setLayout(new FlowLayout(FlowLayout.CENTER));

		JLabel nameLable = new JLabel("Username:");
		JTextField text = new JTextField("admin", 30);
		jf.add(nameLable);
		jf.add(text);

		JLabel pwdLable = new JLabel("Password:");
		JPasswordField jp = new JPasswordField("123456", 30);
		jf.add(pwdLable);
		jf.add(jp);

		JButton loginButton = new JButton("Login");
		jf.add(loginButton);

		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Add login button click event listener.
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = text.getText();
				String password = new String(jp.getPassword());

				LoginResponse response = LoginClient.login(username, password, GrpcChannelManager.getInstance());
				// Login success.
				if (response.getSuccess()) {
					// close current window
					jf.dispose();

					// Create and display a new window, and set token into it.
					try {
						PanelGui.buildPanel(response.getToken());
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				} else {
					// Login failed, pop-up warning window
					JOptionPane.showMessageDialog(jf, "Login failed. Please check your username and password.",
							"Login Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

}
