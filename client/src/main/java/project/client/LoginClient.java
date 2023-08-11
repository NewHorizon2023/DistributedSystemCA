package project.client;

import java.util.concurrent.TimeUnit;

import base.login.LoginGrpc;
import base.login.LoginRequest;
import base.login.LoginResponse;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import project.jmdns.JmDnsServiceDiscovery;

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

	public static void main(String[] args) throws InterruptedException {
		// TODO For test.
		ManagedChannel channel = Grpc
				.newChannelBuilder(JmDnsServiceDiscovery.discoverTarget(), InsecureChannelCredentials.create()).build();
		try {
			login("admin", "123456", channel);
			channel.awaitTermination(120, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			channel.shutdown();
		}
	}

}
