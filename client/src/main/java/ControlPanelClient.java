

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import base.controlPanel.ControlPanelGrpc;
import base.controlPanel.DeviceIdentifier;
import base.controlPanel.DeviceLog;
import base.controlPanel.DeviceStatusRequest;
import base.controlPanel.DeviceStatusResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import util.PropertiesUtil;

public class ControlPanelClient {

	private static int port;

	private static String serverIP;

	static {
		serverIP = PropertiesUtil.getProperty(PropertiesUtil.SERVER_IP);
		port = Integer.parseInt(PropertiesUtil.getProperty(PropertiesUtil.SERVER_PORT_1));
	}

	public static void setDeviceStatusInvoke() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress(serverIP, port).usePlaintext().build();
		try {
			ControlPanelGrpc.ControlPanelBlockingStub controlPanleService = ControlPanelGrpc.newBlockingStub(channel);
			DeviceStatusRequest.Builder builder = DeviceStatusRequest.newBuilder();
			builder.setDeviceId("0000");
			builder.setStatus(false);
			DeviceStatusRequest request = builder.build();
			DeviceStatusResponse response = controlPanleService.setDeviceStatus(request);
			String deviceId = response.getDeviceId();
			boolean status = response.getStatus();
			System.out.println(deviceId + ", " + status);
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			channel.shutdown();
		}
	}

	public static void getDeviceStatusInvoke() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress(serverIP, port).usePlaintext().build();
		try {
			ControlPanelGrpc.ControlPanelBlockingStub controlPanelBlockingStub = ControlPanelGrpc
					.newBlockingStub(channel);
			DeviceIdentifier.Builder builder = DeviceIdentifier.newBuilder();
			builder.setDeviceId("11111");
			DeviceIdentifier request = builder.build();
			Iterator<base.controlPanel.DeviceStatusResponse> responseIterator = controlPanelBlockingStub
					.getDeviceStatus(request);
			while (responseIterator.hasNext()) {
				DeviceStatusResponse next = responseIterator.next();
				System.out.println("Response- device id is: " + next.getDeviceId());
				System.out.println("Response- device status is: " + next.getStatus());
			}

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			channel.shutdown();
		}
	}

	public static void streamDeviceLogsInvoke() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress(serverIP, port).usePlaintext().build();
		try {
			ControlPanelGrpc.ControlPanelStub controlPanelStub = ControlPanelGrpc.newStub(channel);
			StreamObserver<DeviceIdentifier> requestObserver = controlPanelStub
					.streamDeviceLogs(new StreamObserver<DeviceLog>() {

						@Override
						public void onNext(DeviceLog value) {
							System.out.println("Client 1 value is: " + value);
						}

						@Override
						public void onError(Throwable t) {

						}

						@Override
						public void onCompleted() {
							System.out.println("Client 1 is complated");
						}
					});

			for (int i = 0; i < 10; i++) {
				DeviceIdentifier.Builder builder = DeviceIdentifier.newBuilder();
				builder.setDeviceId("001");
				DeviceIdentifier request = builder.build();
				requestObserver.onNext(request);

				Thread.sleep(2000);
			}

			requestObserver.onCompleted();
			channel.awaitTermination(12, TimeUnit.MINUTES);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void main(String[] args) {
//		setDeviceStatusInvoke();
		streamDeviceLogsInvoke();
	}

}
