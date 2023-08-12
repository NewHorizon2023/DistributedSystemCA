package project.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import base.controlPanel.ControlPanelGrpc.ControlPanelImplBase;
import base.controlPanel.DeviceIdentifier;
import base.controlPanel.DeviceLog;
import base.controlPanel.DeviceStatusResponse;
import io.grpc.stub.StreamObserver;
import util.TimeUtil;

public class ControlPanelServiceImpl extends ControlPanelImplBase {
	private static final Logger LOGGER = LoggerFactory.getLogger(ControlPanelServiceImpl.class);

	/**
	 * The status of sencor device which works normally only when it is "true".
	 */
	public static boolean deviceStatus = true;

	/**
	 * <pre>
	 * RPC Method 1: SetDeviceStatus
	 * </pre>
	 */
	@Override
	public void setDeviceStatus(base.controlPanel.DeviceStatusRequest request,
			io.grpc.stub.StreamObserver<base.controlPanel.DeviceStatusResponse> responseObserver) {

		String deviceId = request.getDeviceId();
		LOGGER.info("parameter of method 1 is: " + deviceId);
		deviceStatus = request.getStatus();

		DeviceStatusResponse.Builder builder = DeviceStatusResponse.newBuilder();
		builder.setDeviceId(deviceId);
		builder.setStatus(deviceStatus);

		DeviceStatusResponse response = builder.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();

	}

	/**
	 * <pre>
	 * RPC Method 2: GetDeviceStatus
	 * </pre>
	 */
	@Override
	public io.grpc.stub.StreamObserver<base.controlPanel.DeviceIdentifier> getDeviceStatus(
			io.grpc.stub.StreamObserver<base.controlPanel.DeviceStatusResponse> responseObserver) {
		return new StreamObserver<DeviceIdentifier>() {

			String deviceId;

			@Override
			public void onNext(DeviceIdentifier value) {
				deviceId = value.getDeviceId();
				LOGGER.info("Server 1 method 2 value is: " + deviceId + ", and device status is: " + deviceStatus);

			}

			@Override
			public void onError(Throwable t) {
				LOGGER.error("Server error is: ", t);
			}

			@Override
			public void onCompleted() {
				DeviceStatusResponse.Builder builder = DeviceStatusResponse.newBuilder();
				builder.setDeviceId(deviceId);
				builder.setStatus(deviceStatus);
				DeviceStatusResponse response = builder.build();
				responseObserver.onNext(response);
				responseObserver.onCompleted();
			}
		};
	}

	/**
	 * <pre>
	 * RPC Method 3: StreamDeviceLogs
	 * </pre>
	 */
	@Override
	public io.grpc.stub.StreamObserver<base.controlPanel.DeviceIdentifier> streamDeviceLogs(
			io.grpc.stub.StreamObserver<base.controlPanel.DeviceLog> responseObserver) {
		return new io.grpc.stub.StreamObserver<base.controlPanel.DeviceIdentifier>() {

			@Override
			public void onNext(DeviceIdentifier value) {
				LOGGER.info("Server 1 method 3 value is: " + value);
				DeviceLog response1 = DeviceLog.newBuilder()
						.setLogMessage(deviceStatus ? TimeUtil.getTimeNow() + ": The device is running normally."
								: TimeUtil.getTimeNow() + ": The device has stopped running.")
						.setTimestamp(TimeUtil.getTimeNow()).build();
				responseObserver.onNext(response1);

				DeviceLog response2 = DeviceLog.newBuilder()
						.setLogMessage(deviceStatus ? TimeUtil.getTimeNow() + ": The device is running normally."
								: TimeUtil.getTimeNow() + ": The device has stopped running.")
						.setTimestamp(TimeUtil.getTimeNow()).build();
				responseObserver.onNext(response2);

				DeviceLog response3 = DeviceLog.newBuilder()
						.setLogMessage(deviceStatus ? TimeUtil.getTimeNow() + ": The device is running normally."
								: TimeUtil.getTimeNow() + ": The device has stopped running.")
						.setTimestamp(TimeUtil.getTimeNow()).build();
				responseObserver.onNext(response3);

			}

			@Override
			public void onError(Throwable t) {
				LOGGER.error("Server error is: ", t);
			}

			@Override
			public void onCompleted() {

				DeviceLog response1 = DeviceLog.newBuilder()
						.setLogMessage(deviceStatus ? TimeUtil.getTimeNow() + ": The device is running normally."
								: TimeUtil.getTimeNow() + ": The device has stopped running.")
						.build();
				responseObserver.onNext(response1);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				DeviceLog response2 = DeviceLog.newBuilder()
						.setLogMessage(deviceStatus ? TimeUtil.getTimeNow() + ": The device is running normally."
								: TimeUtil.getTimeNow() + ": The device has stopped running.")
						.build();
				responseObserver.onNext(response2);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				DeviceLog response3 = DeviceLog.newBuilder()
						.setLogMessage(deviceStatus ? TimeUtil.getTimeNow() + ": The device is running normally."
								: TimeUtil.getTimeNow() + ": The device has stopped running.")
						.build();
				responseObserver.onNext(response3);

				responseObserver.onCompleted();
				LOGGER.info("Server 3 method 3 is completed.");
			}

		};
	}

}
