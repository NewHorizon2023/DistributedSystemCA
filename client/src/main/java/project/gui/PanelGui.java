package project.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import project.callback.CallBack;
import project.client.ControlPanelClient;
import project.jmdns.JmDnsServiceDiscovery;

public class PanelGui {
	public static void main(String[] args) throws InterruptedException {
		buildPanel("");
	}

	public static void buildPanel(String token) throws InterruptedException {
		JFrame frame = new JFrame("gRPC Control Panel");
		frame.setSize(550, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 1));
		frame.setLocationRelativeTo(null);

		// ControlPanel
		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(BorderFactory.createTitledBorder("Control Panel Service"));
		JComboBox<String> deviceIdDropdown = new JComboBox<>(new String[] { "true", "false" });
		JButton setDeviceStatusBtn = new JButton("Set Device Status");
		JButton getDeviceStatusBtn = new JButton("Get Device Status");
		JButton streamDeviceLogsBtn = new JButton("Stream Device Logs");
		controlPanel.add(deviceIdDropdown);
		controlPanel.add(setDeviceStatusBtn);
		controlPanel.add(getDeviceStatusBtn);
		controlPanel.add(streamDeviceLogsBtn);

		// 添加 ControlPanel 部分的大的 JTextArea
		JTextArea controlPanelTextArea = new JTextArea();
		controlPanelTextArea.setLineWrap(true); // 设置自动换行
		controlPanelTextArea.setWrapStyleWord(true); // 设置以单词为单位换行
		JScrollPane controlPanelScrollPane = new JScrollPane(controlPanelTextArea);
		controlPanelScrollPane.setPreferredSize(new Dimension(400, 100)); // 设置首选大小
		controlPanel.add(controlPanelScrollPane, BorderLayout.SOUTH);

		// PollutionSensor
		JPanel pollutionSensorPanel = new JPanel();
		pollutionSensorPanel.setBorder(BorderFactory.createTitledBorder("Pollution Sensor Service"));
		JButton getPollutionLevelBtn = new JButton("Get Pollution Level");
		JButton getPollutionHistoryBtn = new JButton("Get Pollution History");
		pollutionSensorPanel.add(getPollutionLevelBtn);
		pollutionSensorPanel.add(getPollutionHistoryBtn);

		// 添加 PollutionSensor 部分的大的 JTextArea
		JTextArea pollutionSensorTextArea = new JTextArea();
		pollutionSensorTextArea.setLineWrap(true); // 设置自动换行
		pollutionSensorTextArea.setWrapStyleWord(true); // 设置以单词为单位换行
		JScrollPane pollutionSensorScrollPane = new JScrollPane(pollutionSensorTextArea);
		pollutionSensorScrollPane.setPreferredSize(new Dimension(400, 100)); // 设置首选大小
		pollutionSensorPanel.add(pollutionSensorScrollPane, BorderLayout.SOUTH);

		// Weather
		JPanel weatherPanel = new JPanel();
		weatherPanel.setBorder(BorderFactory.createTitledBorder("Weather Service"));
		JButton getWeatherForecastBtn = new JButton("Get Weather Forecast");
		weatherPanel.add(getWeatherForecastBtn);

		// 添加 Weather 部分的大的 JTextArea
		JTextArea weatherTextArea = new JTextArea();
		weatherTextArea.setLineWrap(true); // 设置自动换行
		weatherTextArea.setWrapStyleWord(true); // 设置以单词为单位换行
		JScrollPane weatherScrollPane = new JScrollPane(weatherTextArea);
		weatherScrollPane.setPreferredSize(new Dimension(400, 100)); // 设置首选大小
		weatherPanel.add(weatherScrollPane, BorderLayout.SOUTH);

		// Adding panels to frame
		frame.add(controlPanel);
		frame.add(pollutionSensorPanel);
		frame.add(weatherPanel);

		frame.setVisible(true);

		ManagedChannel channel = Grpc
				.newChannelBuilder(JmDnsServiceDiscovery.discoverTarget(), InsecureChannelCredentials.create()).build();

		// Adding action listeners for buttons
		setDeviceStatusBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String stauts = (String) deviceIdDropdown.getSelectedItem();
				String result = ControlPanelClient.setDeviceStatusInvoke(channel, token, stauts);
				controlPanelTextArea.setText(result);
			}
		});

		getDeviceStatusBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ControlPanelClient.getDeviceStatusInvoke(channel, token, new CallBack() {

						@Override
						public void show(String message) {
							controlPanelTextArea.setText(message);
						}
					});
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});

		streamDeviceLogsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					ControlPanelClient.streamDeviceLogsInvoke(channel, token, new CallBack() {

						@Override
						public void show(String message) {
							controlPanelTextArea.setText(message);
						}
					});
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});

		getPollutionLevelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Call GetDeviceStatus gRPC method here
				String selectedDeviceId = (String) deviceIdDropdown.getSelectedItem();
				// TODO: Call GetDeviceStatus method with selectedDeviceId
			}
		});

		getPollutionHistoryBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Call GetDeviceStatus gRPC method here
				String selectedDeviceId = (String) deviceIdDropdown.getSelectedItem();
				// TODO: Call GetDeviceStatus method with selectedDeviceId
			}
		});

		getWeatherForecastBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Call GetDeviceStatus gRPC method here
				String selectedDeviceId = (String) deviceIdDropdown.getSelectedItem();
				// TODO: Call GetDeviceStatus method with selectedDeviceId
			}
		});

	}

	private static JTextArea popupTextArea = new JTextArea();

	private static void showPopup() {
		popupTextArea.setEditable(true);
		JScrollPane scrollPane = new JScrollPane(popupTextArea);
		scrollPane.setPreferredSize(new java.awt.Dimension(300, 150));

		JOptionPane.showMessageDialog(null, scrollPane, "Popup Title", JOptionPane.PLAIN_MESSAGE);
	}

	private static void changeContent(String newContent) {
		popupTextArea.setText(newContent);
	}
}
