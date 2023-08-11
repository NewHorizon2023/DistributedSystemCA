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

	public static void main(String[] args) {
		loginGui();
	}

	public static void loginGui() {
		JFrame jf = new JFrame("Login");
		jf.setSize(400, 250);
		jf.setLocationRelativeTo(null);
		jf.setLayout(new FlowLayout(FlowLayout.CENTER)); // 设置布局为居中对齐

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

		// 添加登录按钮点击事件监听器
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = text.getText();
				String password = new String(jp.getPassword());

				// 进行登录操作
				LoginResponse response = LoginClient.login(username, password, GrpcChannelManager.getInstance());

				if (response.getSuccess()) {
					// 登录成功，关闭当前窗口，打开新窗口
					jf.dispose(); // 关闭当前登录窗口

					// 创建并显示新窗口
					PanelGui.panel();
				} else {
					// 登录失败，弹出警告窗口
					JOptionPane.showMessageDialog(jf, "Login failed. Please check your username and password.",
							"Login Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	// 创建并显示新窗口的方法
	public static void createNewWindow() {
		JFrame newFrame = new JFrame("New Window");
		newFrame.setSize(400, 300);
		newFrame.setLocationRelativeTo(null);

		// 添加新窗口的内容和组件
		// TODO: 添加新窗口的内容

		newFrame.setVisible(true);
		newFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

}
