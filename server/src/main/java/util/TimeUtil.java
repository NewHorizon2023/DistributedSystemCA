package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

	public static final String TIME_PATTERN_STRING = "yyyy-MM-dd HH:mm:ss";

	/**
	 * Get the current time of the system and return
	 * 
	 * @return
	 */
	public static String getTimeNow() {
		// Create a SimpleDateFormat object to specify the date and time format
		SimpleDateFormat sdf = new SimpleDateFormat(TIME_PATTERN_STRING);

		// Format datetime using SimpleDateFormat
		String formattedDateTime = sdf.format(new Date());

		return formattedDateTime;
	}

}
