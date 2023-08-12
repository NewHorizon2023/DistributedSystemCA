package project.grpc;

import java.util.concurrent.TimeUnit;

import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import project.jmdns.JmDnsServiceDiscovery;

public class GrpcChannelManager {
	private static ManagedChannel channel;

	private GrpcChannelManager() {
		// 私有构造函数，确保只能通过 getInstance() 方法获取实例
	}

	public static synchronized ManagedChannel getInstance() {
		if (channel == null || channel.isShutdown()) {
			// 创建 channel
			try {
				channel = Grpc
						.newChannelBuilder(JmDnsServiceDiscovery.discoverTarget(), InsecureChannelCredentials.create())
						.build();
			} catch (InterruptedException e) {
				// Auto-generated catch block
				e.printStackTrace();
			}

			// 添加钩子，在 JVM 关闭时关闭 channel
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
