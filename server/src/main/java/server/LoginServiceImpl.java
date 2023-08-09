package server;

import java.io.IOException;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import base.login.LoginGrpc.LoginImplBase;
import base.login.LoginResponse;
import interceptor.AuthenticationInterceptor;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import util.PropertiesUtil;

public class LoginServiceImpl extends LoginImplBase {

	public static void main(String[] args) throws IOException, InterruptedException {
		LoginServiceImpl logInService = new LoginServiceImpl();
		int port = Integer.parseInt(PropertiesUtil.getProperty(PropertiesUtil.SERVER_PORT_0));
		Server server = ServerBuilder.forPort(port).addService(logInService).build().start();
		server.awaitTermination();
	}

	/**
	 * Login method
	 */
	@Override
	public void login(base.login.LoginRequest request,
			io.grpc.stub.StreamObserver<base.login.LoginResponse> responseObserver) {

		// Determine whether the username and password are correct
		boolean success = PropertiesUtil.getProperty(PropertiesUtil.USERNAME_STRING).equals(request.getUsername())
				&& PropertiesUtil.getProperty(PropertiesUtil.PASSWORD_STRING).equals(request.getPassword());

		// If login successfully, generate a token and save.
		if (success) {
			AuthenticationInterceptor.AUTHORIZATION_TOKEN = generateToken(request.getUsername());
		}

		LoginResponse.Builder builder = LoginResponse.newBuilder();

		builder.setSuccess(success);
		// Set prompt information.
		builder.setMessage(success ? "Login successful" : "Username or password is wrong, please try again.");

		LoginResponse response = builder.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

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
