package server;

import java.io.IOException;

import base.login.LoginGrpc.LoginImplBase;
import base.login.LoginResponse;
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
		boolean result = PropertiesUtil.getProperty(PropertiesUtil.USERNAME_STRING).equals(request.getUsername())
				&& PropertiesUtil.getProperty(PropertiesUtil.PASSWORD_STRING).equals(request.getPassword());

		LoginResponse.Builder builder = LoginResponse.newBuilder();

		builder.setSuccess(result);
		// Set prompt information.
		builder.setMessage(result ? "Login successful" : "Username or password is wrong, please try again.");

		LoginResponse response = builder.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

}
