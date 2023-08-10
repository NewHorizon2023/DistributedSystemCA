package project.server;

import java.io.IOException;

import base.controlPanel.ControlPanelGrpc.ControlPanelImplBase;
import base.controlPanel.DeviceIdentifier;
import base.controlPanel.DeviceLog;
import base.controlPanel.DeviceStatusResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import project.util.PropertiesUtil;
import project.util.TimeUtil;

public class ControlPanelServiceImpl extends ControlPanelImplBase {
//	private static final Logger logger = LoggerFactory.getLogger(ControlPanelServiceImpl.class);

	public static void main(String[] args) throws InterruptedException, IOException {
		ControlPanelServiceImpl controlPanel = new ControlPanelServiceImpl();
		int port = Integer.parseInt(PropertiesUtil.getProperty(PropertiesUtil.SERVER_PORT_1));

		Server server = ServerBuilder.forPort(port).addService(controlPanel).build().start();
		System.out.println("Service-Weather started, listening on " + port);
		server.awaitTermination();
	}

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
		System.out.println("parameter of method 1 is: " + deviceId);
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
//				logger.debug("parameter of method 2 is: " + deviceId);
//				logger.debug("parameter of method 2 is: " + value);
//				DeviceStatusResponse.Builder builder = DeviceStatusResponse.newBuilder();
//				builder.setDeviceId(value.getDeviceId());
//				builder.setStatus(deviceStatus);
//				DeviceStatusResponse response = builder.build();
//				responseObserver.onNext(response);
			}

			@Override
			public void onError(Throwable t) {
//				logger.debug("Error happend on server!!!!");
//				logger.debug("Server error is: ", t);
			}

			@Override
			public void onCompleted() {
//				logger.debug("It is oprating : " + deviceId);
				DeviceStatusResponse.Builder builder = DeviceStatusResponse.newBuilder();
				builder.setDeviceId(deviceId);
				builder.setStatus(deviceStatus);
				DeviceStatusResponse response = builder.build();
				responseObserver.onNext(response);
				responseObserver.onCompleted();
//				logger.debug("Server method 2 copleted.");
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
				System.out.println("parameter of method 3 is: " + value);
				System.out.println("Server 1 value is: " + value);
//				DeviceLog.Builder builder = DeviceLog.newBuilder();
//				builder.setLogMessage(
//						deviceStatus ? "The device is running normally." : "The device has stopped running.");
//				builder.setTimestamp(TimeUtil.getTimeNow());
//
//				DeviceLog response = builder.build();
//				responseObserver.onNext(response);

				System.out.println("The server has finished receiving");

			}

			@Override
			public void onError(Throwable t) {

			}

			@Override
			public void onCompleted() {
				DeviceLog.Builder builder = DeviceLog.newBuilder();
				builder.setLogMessage(
						deviceStatus ? "The device is running normally." : "The device has stopped running.");
				builder.setTimestamp(TimeUtil.getTimeNow());

				DeviceLog response = builder.build();
				responseObserver.onNext(response);
				responseObserver.onCompleted();
				System.out.println("Method 3 is completed.");
			}

		};
	}

}
