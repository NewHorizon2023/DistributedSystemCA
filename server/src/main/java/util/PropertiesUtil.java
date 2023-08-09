package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	public static final String SERVER_IP = "server.ip";

	public static final String SERVER_PORT_0 = "server.port0";
	public static final String SERVER_PORT_1 = "server.port1";
	public static final String SERVER_PORT_2 = "server.port2";
	public static final String SERVER_PORT_3 = "server.port3";

	public static final String USERNAME_STRING = "user.username";
	public static final String PASSWORD_STRING = "user.password";

	private static final String PROPERTIES_FILE = "config.properties";
	private static Properties properties;

	static {
		// Load properties file in static code block
		properties = new Properties();
		try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
}
