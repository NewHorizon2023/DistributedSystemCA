package project.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import base.controlPanel.ControlPanelGrpc;
import base.controlPanel.DeviceIdentifier;
import base.controlPanel.DeviceLog;
import base.controlPanel.DeviceStatusRequest;
import base.controlPanel.DeviceStatusResponse;
import io.grpc.ManagedChannel;
import io.grpc.stub.MetadataUtils;
import io.grpc.stub.StreamObserver;
import project.callback.CallBack;
import project.util.AuthenticationUtil;
import util.TimeUtil;

public class ControlPanelClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(ControlPanelClient.class);

	/**
	 * Set device status.
	 * 
	 * @param channel
	 * @param token
	 * @param status
	 * @return
	 */
	public static String setDeviceStatusInvoke(ManagedChannel channel, String token, String statusStr) {
		ControlPanelGrpc.ControlPanelBlockingStub controlPanleService = ControlPanelGrpc.newBlockingStub(channel);
		DeviceStatusRequest.Builder builder = DeviceStatusRequest.newBuilder();
		builder.setDeviceId("0000-1");
		builder.setStatus(Boolean.parseBoolean(statusStr));
		DeviceStatusRequest request = builder.build();
		// Send a request with interceptor validation.
		DeviceStatusResponse response = controlPanleService
				.withInterceptors(MetadataUtils.newAttachHeadersInterceptor(AuthenticationUtil.headersBuild(token)))
				.setDeviceStatus(request);
		String deviceId = response.getDeviceId();
		boolean status = response.getStatus();
		LOGGER.info(deviceId + ", " + status);

		return "Set device status success, device id is: " + deviceId + ", and status is: " + status;
	}

	/**
	 * Get device status.
	 * 
	 * @param channel
	 * @param token
	 * @param callBack
	 * @throws InterruptedException
	 */
	public static void getDeviceStatusInvoke(ManagedChannel channel, String token, CallBack callBack)
			throws InterruptedException {
		ControlPanelGrpc.ControlPanelStub controlPanelStub = ControlPanelGrpc.newStub(channel);
		// Send a request with interceptor validation.
		StreamObserver<DeviceIdentifier> respoonse = controlPanelStub
				.withInterceptors(MetadataUtils.newAttachHeadersInterceptor(AuthenticationUtil.headersBuild(token)))
				.getDeviceStatus(new StreamObserver<DeviceStatusResponse>() {

					@Override
					public void onNext(DeviceStatusResponse value) {
						// Show the response data on the GUI board.
						callBack.show(TimeUtil.getTimeNow() + " The device id is: " + value.getDeviceId()
								+ ", and status is: " + value.getStatus());
						LOGGER.info("method 2 gets a response, value is: " + value);
					}

					@Override
					public void onError(Throwable t) {
						LOGGER.error("Error on client is: ", t);
					}

					@Override
					public void onCompleted() {
						LOGGER.info("Client recieves completed info from server.");
					}
				});

		for (int i = 0; i < 2; i++) {
			DeviceIdentifier.Builder builder = DeviceIdentifier.newBuilder();
			builder.setDeviceId("0000-" + i);
			DeviceIdentifier request = builder.build();
			respoonse.onNext(request);
//			Thread.sleep(1000);
		}

		respoonse.onCompleted();
	}

	/**
	 * Get device logs.
	 * 
	 * @param channel
	 * @param token
	 * @param callBack
	 * @throws InterruptedException
	 */
	public static void streamDeviceLogsInvoke(ManagedChannel channel, String token, CallBack callBack)
			throws InterruptedException {
		ControlPanelGrpc.ControlPanelStub controlPanelStub = ControlPanelGrpc.newStub(channel);
		// Send a request with interceptor validation.
		StreamObserver<DeviceIdentifier> response = controlPanelStub
				.withInterceptors(MetadataUtils.newAttachHeadersInterceptor(AuthenticationUtil.headersBuild(token)))
				.streamDeviceLogs(new StreamObserver<DeviceLog>() {

					@Override
					public void onNext(DeviceLog value) {
						// Show the response data on the GUI board.
						callBack.show(value.getLogMessage());
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

		for (int i = 0; i < 2; i++) {
			DeviceIdentifier.Builder builder = DeviceIdentifier.newBuilder();
			builder.setDeviceId("0000-" + i);
			DeviceIdentifier request = builder.build();
			response.onNext(request);

		}

		response.onCompleted();
	}

}
