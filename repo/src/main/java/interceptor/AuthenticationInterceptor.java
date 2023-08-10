package interceptor;

import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;

/**
 * token verification
 */
public class AuthenticationInterceptor implements ServerInterceptor {

	public static final Key<String> AUTHORIZATION_HEADER_KEY = Key.of("Authorization",
			Metadata.ASCII_STRING_MARSHALLER);

	public static String AUTHORIZATION_TOKEN = "";

	/**
	 * Intercept the client's request and verify the token
	 */
	@Override
	public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers,
			ServerCallHandler<ReqT, RespT> next) {
		String token = headers.get(AUTHORIZATION_HEADER_KEY);
		System.out.println("Server token is: " + token);

		if (AUTHORIZATION_TOKEN.equals(token)) {
			System.out.println("Authorization success!");
			return next.startCall(call, headers);
		} else {
			call.close(Status.UNAUTHENTICATED.withDescription("Invalid credentials"), headers);
			return new ServerCall.Listener<ReqT>() {
			};
		}
	}
}
