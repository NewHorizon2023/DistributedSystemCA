package enmu;

/**
 * Service infomation enum.
 */
public enum ServiceInfoEnum {
	LOGIN("_login._tcp.local.", "login-service", "Login Service"),
	WEATHER("_weather._tcp.local.", "weather-service", "Weather Service"),
    POLLUTION_SENSOR("_pollution._tcp.local.", "pollution-service", "Pollution Sensor Service"),
    CONTROL_PANEL("_controlpanel._tcp.local.", "controlpanel-service", "Control Panel Service");

    private final String type;
    private final String name;
    private final String description;

    ServiceInfoEnum(String type, String name, String description) {
        this.type = type;
        this.name = name;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
