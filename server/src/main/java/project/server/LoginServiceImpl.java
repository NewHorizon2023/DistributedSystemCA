package project.server;

import java.io.IOException;

import base.login.LoginGrpc.LoginImplBase;
import base.login.LoginResponse;
import interceptor.AuthenticationInterceptor;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import project.util.ServerPropertiesUtil;
import project.util.TokenUtil;

public class LoginServiceImpl extends LoginImplBase {

	public static void main(String[] args) throws IOException, InterruptedException {
		LoginServiceImpl logInService = new LoginServiceImpl();
		int port = Integer.parseInt(ServerPropertiesUtil.getProperty(ServerPropertiesUtil.SERVER_PORT_0));
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
		boolean success = ServerPropertiesUtil.getProperty(ServerPropertiesUtil.USERNAME_STRING).equals(request.getUsername())
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
