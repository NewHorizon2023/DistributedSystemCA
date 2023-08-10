package project.client;

import base.login.LoginGrpc;
import base.login.LoginRequest;
import base.login.LoginResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class LoginClient {

	/**
	 * TODO Used to store tokens, expedient
	 */
	public static String token;

	/**
	 * Login method
	 * 
	 * @param username
	 * @param password
	 * @throws InterruptedException
	 */
	public static void login(String username, String password) throws InterruptedException {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50050).usePlaintext().build();
		LoginGrpc.LoginBlockingStub service = LoginGrpc.newBlockingStub(channel);
		LoginRequest.Builder builder = LoginRequest.newBuilder();
		builder.setUsername(username).setPassword(password);
		LoginRequest request = builder.build();
		// TODO Use this response data.
		LoginResponse response = service.login(request);
		// TODO how to store token?
		if (response.getSuccess()) {
			token = response.getToken();
			System.out.println("token is: " + response.getToken());
		}

		Thread.sleep(1000000);
	}

	public static void main(String[] args) throws InterruptedException {
		login("admin", "123456");
	}

}
