package project.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelGui {
	public static void main(String[] args) {
		panel();
	}

	public static void panel() {
		JFrame frame = new JFrame("gRPC Control Panel");
		frame.setSize(600, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 1));

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

		// PollutionSensor
		JPanel pollutionSensorPanel = new JPanel();
		pollutionSensorPanel.setBorder(BorderFactory.createTitledBorder("Pollution Sensor Service"));
		JButton getPollutionLevelBtn = new JButton("Get Pollution Level");
		JButton getPollutionHistoryBtn = new JButton("Get Pollution History");
		pollutionSensorPanel.add(getPollutionLevelBtn);
		pollutionSensorPanel.add(getPollutionHistoryBtn);

		// Weather
		JPanel weatherPanel = new JPanel();
		weatherPanel.setBorder(BorderFactory.createTitledBorder("Weather Service"));
		JButton getWeatherForecastBtn = new JButton("Get Weather Forecast");
		weatherPanel.add(getWeatherForecastBtn);

		// Adding panels to frame
		frame.add(controlPanel);
		frame.add(pollutionSensorPanel);
		frame.add(weatherPanel);

		frame.setVisible(true);

		// Adding action listeners for buttons
		setDeviceStatusBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Call SetDeviceStatus gRPC method here
				String selectedDeviceId = (String) deviceIdDropdown.getSelectedItem();
				// TODO: Call SetDeviceStatus method with selectedDeviceId
			}
		});

		getDeviceStatusBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Call GetDeviceStatus gRPC method here
				String selectedDeviceId = (String) deviceIdDropdown.getSelectedItem();
				// TODO: Call GetDeviceStatus method with selectedDeviceId
			}
		});

		streamDeviceLogsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Call GetDeviceStatus gRPC method here
				String selectedDeviceId = (String) deviceIdDropdown.getSelectedItem();
				// TODO: Call GetDeviceStatus method with selectedDeviceId
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
}
