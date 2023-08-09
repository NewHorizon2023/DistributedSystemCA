package pojo;

/**
 * Pollution data.
 */
public class PollutionPojo {

	private double latitude;

	private double longitude;

	private double pollutionLevel;

	private String timestamp;

	public PollutionPojo(double latitude, double longitude, double pollutionLevel, String timestamp) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.pollutionLevel = pollutionLevel;
		this.timestamp = timestamp;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getPollutionLevel() {
		return pollutionLevel;
	}

	public void setPollutionLevel(double pollutionLevel) {
		this.pollutionLevel = pollutionLevel;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "PollutionPojo [latitude=" + latitude + ", longitude=" + longitude + ", pollutionLevel=" + pollutionLevel
				+ ", timestamp=" + timestamp + "]";
	}

}
