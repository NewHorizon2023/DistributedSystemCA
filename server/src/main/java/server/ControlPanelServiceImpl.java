package server;

import java.io.IOException;

import base.controlPanel.ControlPanelGrpc.ControlPanelImplBase;
import base.controlPanel.DeviceIdentifier;
import base.controlPanel.DeviceLog;
import base.controlPanel.DeviceStatusResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import util.PropertiesUtil;
import util.TimeUtil;

public class ControlPanelServiceImpl extends ControlPanelImplBase {

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

			@Override
			public void onNext(DeviceIdentifier value) {
				System.out.println("recieved client data.");
				DeviceStatusResponse.Builder builder = DeviceStatusResponse.newBuilder();
				builder.setDeviceId(value.getDeviceId());
				builder.setStatus(deviceStatus);
				DeviceStatusResponse response = builder.build();
				responseObserver.onNext(response);
				responseObserver.onCompleted();
			}

			@Override
			public void onError(Throwable t) {

			}

			@Override
			public void onCompleted() {

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
				System.out.println("Server 1 value is: " + value);
				DeviceLog.Builder builder = DeviceLog.newBuilder();
				builder.setLogMessage(
						deviceStatus ? "The device is running normally." : "The device has stopped running.");
				builder.setTimestamp(TimeUtil.getTimeNow());

				DeviceLog response = builder.build();
				responseObserver.onNext(response);
				responseObserver.onCompleted();
				System.out.println("The server has finished receiving");

			}

			@Override
			public void onError(Throwable t) {

			}

			@Override
			public void onCompleted() {
			}

		};
	}

}
