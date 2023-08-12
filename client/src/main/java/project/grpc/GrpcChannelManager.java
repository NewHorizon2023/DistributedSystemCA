package project.grpc;

import java.util.concurrent.TimeUnit;

import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import project.jmdns.JmDnsServiceDiscovery;

public class GrpcChannelManager {
	private static ManagedChannel channel;

	private GrpcChannelManager() {
		// Private constructor to ensure that the instance can only be obtained through the getInstance() method
	}

	public static synchronized ManagedChannel getInstance() {
		if (channel == null || channel.isShutdown()) {
			// Create channels
			try {
				channel = Grpc
						.newChannelBuilder(JmDnsServiceDiscovery.discoverTarget(), InsecureChannelCredentials.create())
						.build();
			} catch (InterruptedException e) {
				// Auto-generated catch block
				e.printStackTrace();
			}

			// Add hook to close channel when JVM shuts down
			Runtime.getRuntime().addShutdownHook(new Thread(() -> {
				if (channel != null) {
					try {
						channel.shutdown().awaitTermination(300, TimeUnit.SECONDS);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}));
		}

		return channel;
	}
}
