package project.client;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import base.controlPanel.ControlPanelGrpc;
import base.controlPanel.DeviceIdentifier;
import base.controlPanel.DeviceLog;
import base.controlPanel.DeviceStatusRequest;
import base.controlPanel.DeviceStatusResponse;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;
import project.jmdns.JmDnsServiceDiscovery;

public class ControlPanelClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(ControlPanelClient.class);

	/**
	 * Set device status.
	 * 
	 * @param channel
	 */
	public static void setDeviceStatusInvoke(ManagedChannel channel) {
		ControlPanelGrpc.ControlPanelBlockingStub controlPanleService = ControlPanelGrpc.newBlockingStub(channel);
		DeviceStatusRequest.Builder builder = DeviceStatusRequest.newBuilder();
		builder.setDeviceId("0000");
		builder.setStatus(false);
		DeviceStatusRequest request = builder.build();
		DeviceStatusResponse response = controlPanleService.setDeviceStatus(request);
		String deviceId = response.getDeviceId();
		boolean status = response.getStatus();
		LOGGER.info(deviceId + ", " + status);
	}

	/**
	 * Get device status.
	 * 
	 * @param channel
	 * @throws InterruptedException
	 */
	public static void getDeviceStatusInvoke(ManagedChannel channel) throws InterruptedException {
		ControlPanelGrpc.ControlPanelStub controlPanelStub = ControlPanelGrpc.newStub(channel);
		StreamObserver<DeviceIdentifier> reqObserver = controlPanelStub
				.getDeviceStatus(new StreamObserver<DeviceStatusResponse>() {

					@Override
					public void onNext(DeviceStatusResponse value) {
						// TODO show device status on client
						LOGGER.info("method 2 gets a response, value is: " + value);

					}

					@Override
					public void onError(Throwable t) {
//							logger.debug("Error happend on client!!!!");
//							logger.debug("Error on client is: ", t);
					}

					@Override
					public void onCompleted() {
						LOGGER.info("Client recieves completed info from server.");
					}
				});

		// TODO set data through client here
		for (int i = 0; i < 10; i++) {
			DeviceIdentifier.Builder builder = DeviceIdentifier.newBuilder();
			// TODO set device id here
			builder.setDeviceId("0000-" + i);
			DeviceIdentifier request = builder.build();
			reqObserver.onNext(request);
			Thread.sleep(1000);
		}

		reqObserver.onCompleted();
	}

	/**
	 * Get device logs.
	 * 
	 * @param channel
	 * @throws InterruptedException
	 */
	public static void streamDeviceLogsInvoke(ManagedChannel channel) throws InterruptedException {
		ControlPanelGrpc.ControlPanelStub controlPanelStub = ControlPanelGrpc.newStub(channel);
		StreamObserver<DeviceIdentifier> requestObserver = controlPanelStub
				.streamDeviceLogs(new StreamObserver<DeviceLog>() {

					@Override
					public void onNext(DeviceLog value) {
						LOGGER.info("Client 1 value is: " + value);
					}

					@Override
					public void onError(Throwable t) {

					}

					@Override
					public void onCompleted() {
						LOGGER.info("Client 1 is complated");
					}
				});

		for (int i = 0; i < 10; i++) {
			DeviceIdentifier.Builder builder = DeviceIdentifier.newBuilder();
			builder.setDeviceId("0000-" + i);
			DeviceIdentifier request = builder.build();
			requestObserver.onNext(request);

			Thread.sleep(1000);
		}

		requestObserver.onCompleted();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO For test.
		ManagedChannel channel = Grpc
				.newChannelBuilder(JmDnsServiceDiscovery.discoverTarget(), InsecureChannelCredentials.create()).build();
		try {
			setDeviceStatusInvoke(channel);
			getDeviceStatusInvoke(channel);
			streamDeviceLogsInvoke(channel);

			channel.awaitTermination(120, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			channel.shutdown();
		}
	}

}
