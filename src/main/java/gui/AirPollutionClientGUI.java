package gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class AirPollutionClientGUI extends JFrame{

	private static final long serialVersionUID = 8952395720478663745L;

	public AirPollutionClientGUI() {
        setTitle("Air Pollution Tracking Client");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        JTabbedPane tabbedPane = new JTabbedPane();

        // Create panels for each service
        JPanel controlPanelPanel = createControlPanelPanel();
        JPanel pollutionSensorPanel = createPollutionSensorPanel();
        JPanel weatherPanel = createWeatherPanel();

        // Add panels to the tabbed pane
        tabbedPane.addTab("Control Panel", controlPanelPanel);
        tabbedPane.addTab("Pollution Sensor", pollutionSensorPanel);
        tabbedPane.addTab("Weather", weatherPanel);

        getContentPane().add(tabbedPane);
        pack();
        setLocationRelativeTo(null);
    }

    private JPanel createControlPanelPanel() {
        // TODO: Add components and event handlers for ControlPanelService
        JPanel panel = new JPanel();
        // Add components and event handlers for SetDeviceStatus, GetDeviceStatus, StreamDeviceLogs
        // ...

        return panel;
    }

    private JPanel createPollutionSensorPanel() {
        // TODO: Add components and event handlers for PollutionSensorService
        JPanel panel = new JPanel();
        // Add components and event handlers for GetPollutionLevel, SubscribeToPollutionUpdates, GetPollutionHistory
        // ...

        return panel;
    }

    private JPanel createWeatherPanel() {
        // TODO: Add components and event handlers for WeatherService
        JPanel panel = new JPanel();
        // Add components and event handlers for GetTemperature, GetHumidity, GetWeatherForecast
        // ...

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AirPollutionClientGUI client = new AirPollutionClientGUI();
            client.setVisible(true);
        });
    }
}
