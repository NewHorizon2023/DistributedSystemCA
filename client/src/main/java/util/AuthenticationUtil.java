package util;

import client.LoginClient;
import interceptor.AuthenticationInterceptor;
import io.grpc.Metadata;

public class AuthenticationUtil {

	/**
	 * Build headers to transfor token.
	 * 
	 * @return
	 */
	public static Metadata headersBuild() {
		Metadata headers = new Metadata();
		System.out.println("Client token is: " + LoginClient.token);
		// TODO Use other way to get token.
		headers.put(AuthenticationInterceptor.AUTHORIZATION_HEADER_KEY, LoginClient.token);
		return headers;
	}

}