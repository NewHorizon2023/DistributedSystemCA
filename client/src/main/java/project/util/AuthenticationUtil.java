package project.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import interceptor.AuthenticationInterceptor;
import io.grpc.Metadata;
import project.client.LoginClient;

public class AuthenticationUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationUtil.class);

	/**
	 * Build headers to transfor token.
	 * 
	 * @return
	 */
	public static Metadata headersBuild() {
		Metadata headers = new Metadata();
		LOGGER.info("Client token is: " + LoginClient.token);
		// TODO Use other way to get token.
		headers.put(AuthenticationInterceptor.AUTHORIZATION_HEADER_KEY, LoginClient.token);
		return headers;
	}

}
