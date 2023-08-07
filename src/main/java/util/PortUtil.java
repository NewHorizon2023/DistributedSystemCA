package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PortUtil {
	public static final String SERVER_PORT_1 = "server.port1";
	public static final String SERVER_PORT_2 = "server.port2";
	public static final String SERVER_PORT_3 = "server.port3";

	private static final String PROPERTIES_FILE = "config.properties";
	private static Properties properties;

	static {
		// Load properties file in static code block
		properties = new Properties();
		try (InputStream inputStream = PortUtil.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int getPort(String key) {
		return Integer.parseInt(properties.getProperty(key));
	}
}
