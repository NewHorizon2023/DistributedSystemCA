package project.util;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class TokenUtil {

	/**
	 * Generate token for authentication
	 * 
	 * @param userId
	 * @return
	 */
	public static String generateToken(String username) {
		Date expirationDate = new Date(System.currentTimeMillis()
				+ Long.parseLong(PropertiesUtil.getProperty(PropertiesUtil.TOMEN_EXPIRATION_TIME)));

		return JWT.create().withSubject(username).withExpiresAt(expirationDate)
				.sign(Algorithm.HMAC256(PropertiesUtil.TOKEN_SECRET_KEY));
	}
}
