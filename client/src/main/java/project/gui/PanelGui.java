package project.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import base.pollutionSensor.PollutionReading;
import base.weather.WeatherForecastResponse;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import project.callback.CallBack;
import project.client.ControlPanelClient;
import project.client.PollutionSensorClient;
import project.client.WeatherClient;
import project.jmdns.JmDnsServiceDiscovery;

public class PanelGui {

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

		// Add a large JTextArea to the ControlPanel section
		JTextArea controlPanelTextArea = new JTextArea();
		controlPanelTextArea.setLineWrap(true);
		controlPanelTextArea.setWrapStyleWord(true);
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

		// Add large JTextArea for PollutionSensor part
		JTextArea pollutionSensorTextArea = new JTextArea();
		pollutionSensorTextArea.setLineWrap(true);
		pollutionSensorTextArea.setWrapStyleWord(true);
		JScrollPane pollutionSensorScrollPane = new JScrollPane(pollutionSensorTextArea);
		pollutionSensorScrollPane.setPreferredSize(new Dimension(400, 100)); // 设置首选大小
		pollutionSensorPanel.add(pollutionSensorScrollPane, BorderLayout.SOUTH);

		// Weather
		JPanel weatherPanel = new JPanel();
		weatherPanel.setBorder(BorderFactory.createTitledBorder("Weather Service"));
		JButton getWeatherForecastBtn = new JButton("Get Weather Forecast");
		weatherPanel.add(getWeatherForecastBtn);

		// Add a large JTextArea for the Weather section
		JTextArea weatherTextArea = new JTextArea();
		weatherTextArea.setLineWrap(true);
		weatherTextArea.setWrapStyleWord(true);
		JScrollPane weatherScrollPane = new JScrollPane(weatherTextArea);
		weatherScrollPane.setPreferredSize(new Dimension(400, 150));
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
				controlPanelTextArea.setText(null);
				String result = ControlPanelClient.setDeviceStatusInvoke(channel, token, stauts);
				controlPanelTextArea.append(result + "\n");
			}
		});

		getDeviceStatusBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controlPanelTextArea.setText(null);
					ControlPanelClient.getDeviceStatusInvoke(channel, token, new CallBack() {

						@Override
						public void show(String message) {
							controlPanelTextArea.append(message + "\n");
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
					controlPanelTextArea.setText(null);
					ControlPanelClient.streamDeviceLogsInvoke(channel, token, new CallBack() {

						@Override
						public void show(String message) {
							controlPanelTextArea.append(message + "\n");
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
				pollutionSensorTextArea.setText(null);
				PollutionSensorClient.getPollutionLevelInvoke(53.349805, -6.26031, channel, token, new CallBack() {

					@Override
					public void show(String result) {
						pollutionSensorTextArea.append(result + "\n");
					}
				});
			}
		});

		getPollutionHistoryBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pollutionSensorTextArea.setText(null);
				List<PollutionReading> list = PollutionSensorClient.getPollutionHistoryInvoke(53.349805, -6.26031,
						"2023-08-12 00:00:00", "2025-08-12 00:00:00", channel, token);
				for (PollutionReading pollutionReading : list) {
					pollutionSensorTextArea.append("Timestamp: " + pollutionReading.getTimestamp() + "      "
							+ "Pollution Level: " + pollutionReading.getPollutionLevel() + "\n");
				}

			}
		});

		getWeatherForecastBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WeatherForecastResponse response = WeatherClient.getWeatherForecastInvoke(53.349805, -6.26031, channel,
						token);
				weatherTextArea.setText(null);
				weatherTextArea.append("Latitude: " + response.getLatitude() + "\n");
				weatherTextArea.append("Longitude: " + response.getLongitude() + "\n");
				weatherTextArea.append("Temperature: " + response.getTemperature() + "\n");
				weatherTextArea.append("Humidity: " + response.getHumidity() + "\n");
				weatherTextArea.append("Humidity: " + response.getHumidity() + "\n");
				weatherTextArea.append("Wind Speed: " + response.getWindSpeed() + "\n");
				weatherTextArea.append("Precipitation: " + response.getPrecipitation() + "\n");
				weatherTextArea.append("Timestamp: " + response.getTimestamp() + "\n");
			}
		});

	}

}
