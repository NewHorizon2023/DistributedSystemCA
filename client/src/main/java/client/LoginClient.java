package client;

import base.login.LoginGrpc;
import base.login.LoginRequest;
import base.login.LoginResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class LoginClient {

	/**
	 * Login method
	 * 
	 * @param username
	 * @param password
	 */
	public static void login(String username, String password) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50050).usePlaintext().build();
		LoginGrpc.LoginBlockingStub service = LoginGrpc.newBlockingStub(channel);
		LoginRequest.Builder builder = LoginRequest.newBuilder();
		builder.setUsername(username).setPassword(password);
		LoginRequest request = builder.build();
		// TODO Use this response data.
		LoginResponse response = service.login(request);
	}

	public static void main(String[] args) {

	}

}
