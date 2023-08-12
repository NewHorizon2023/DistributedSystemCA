package project.client;

import base.login.LoginGrpc;
import base.login.LoginRequest;
import base.login.LoginResponse;
import io.grpc.ManagedChannel;

public class LoginClient {

	/**
	 * Login method
	 * 
	 * @param username
	 * @param password
	 * @param channel
	 * @return
	 */
	public static LoginResponse login(String username, String password, ManagedChannel channel) {
		LoginGrpc.LoginBlockingStub service = LoginGrpc.newBlockingStub(channel);
		LoginRequest.Builder builder = LoginRequest.newBuilder();
		builder.setUsername(username).setPassword(password);
		LoginRequest request = builder.build();

		return service.login(request);
	}

}
