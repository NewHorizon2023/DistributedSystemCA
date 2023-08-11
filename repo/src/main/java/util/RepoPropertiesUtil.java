package util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RepoPropertiesUtil {
	public static final String GRPC_SERVER = "grpc.server";

	private static Properties properties;

	static {
		// Load properties file in static code block
		properties = new Properties();
		try (InputStream inputStream = RepoPropertiesUtil.class.getClassLoader()
				.getResourceAsStream("properties/repo_config.properties")) {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
}
