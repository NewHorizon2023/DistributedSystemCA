package project.server;

import base.login.LoginGrpc.LoginImplBase;
import base.login.LoginResponse;
import interceptor.AuthenticationInterceptor;
import project.util.ServerPropertiesUtil;
import project.util.TokenUtil;

public class LoginServiceImpl extends LoginImplBase {

	/**
	 * Login method
	 */
	@Override
	public void login(base.login.LoginRequest request,
			io.grpc.stub.StreamObserver<base.login.LoginResponse> responseObserver) {

		// Determine whether the username and password are correct
		boolean success = ServerPropertiesUtil.getProperty(ServerPropertiesUtil.USERNAME_STRING)
				.equals(request.getUsername())
				&& ServerPropertiesUtil.getProperty(ServerPropertiesUtil.PASSWORD_STRING).equals(request.getPassword());

		LoginResponse.Builder builder = LoginResponse.newBuilder();

		builder.setSuccess(success);
		// Set prompt information.
		builder.setMessage(success ? "Login successful" : "Username or password is wrong, please try again.");
		// If login success, generate a token and save.
		if (success) {
			String token = TokenUtil.generateToken(request.getUsername());
			AuthenticationInterceptor.AUTHORIZATION_TOKEN = token;
			builder.setToken(token);
		}

		LoginResponse response = builder.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

}
