package util;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Various methods to generate simulated data.
 */
public class DataUtil {

	/**
	 * Get random double value in range.
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public static double getRandomDoubleInRange(double min, double max) {
		if (min >= max) {
			throw new IllegalArgumentException("min must be less than max");
		}

		// Create a random number generator.
		Random random = new Random();

		// Use the nextDouble method to generate a random double number in the range [0, 1)
		double randomNumber = random.nextDouble();

		// maps random double numbers to the specified range
		double result = min + randomNumber * (max - min);

		// Use DecimalFormat to keep two decimal places.
		DecimalFormat df = new DecimalFormat("#.##");
		return Double.parseDouble(df.format(result));
	}
}
