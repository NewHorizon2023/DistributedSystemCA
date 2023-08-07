package service;

import java.io.IOException;

import base.controlPanel.ControlPanelGrpc.ControlPanelImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class ControlPanelServiceImpl extends ControlPanelImplBase {

	public static void main(String[] args) throws InterruptedException, IOException {
		ControlPanelServiceImpl controlPanel = new ControlPanelServiceImpl();

		int port = 50051;

		Server server = ServerBuilder.forPort(port).addService(controlPanel).build().start();

		System.out.println("Service-Weather started, listening on " + port);

		server.awaitTermination();
	}

	/**
	 * <pre>
	 * RPC Method 1: SetDeviceStatus
	 * </pre>
	 */
	public void setDeviceStatus(base.controlPanel.DeviceStatusRequest request,
			io.grpc.stub.StreamObserver<base.controlPanel.DeviceStatusResponse> responseObserver) {
		
		String deviceId = request.getDeviceId();
		System.out.println("device id is: " + deviceId);
		System.out.println("device status is: " + request.getStatus());
		base.controlPanel.DeviceStatusResponse.Builder builder = base.controlPanel.DeviceStatusResponse.newBuilder();
		
		builder.setDeviceId("nci-001");
		builder.setStatus(true);
		
		base.controlPanel.DeviceStatusResponse response = builder.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();

		// asyncUnimplementedUnaryCall(getSetDeviceStatusMethod(), responseObserver);

	}

	/**
	 * <pre>
	 * RPC Method 2: GetDeviceStatus
	 * </pre>
	 */
	public void getDeviceStatus(base.controlPanel.DeviceIdentifier request,
			io.grpc.stub.StreamObserver<base.controlPanel.DeviceStatusResponse> responseObserver) {
		// asyncUnimplementedUnaryCall(getGetDeviceStatusMethod(), responseObserver);
		String deviceId = request.getDeviceId();
		// System.out.println("Request device id is: " + deviceId);
		for (int i = 0; i < 5; i++) {
			base.controlPanel.DeviceStatusResponse.Builder builder = base.controlPanel.DeviceStatusResponse.newBuilder();
			builder.setDeviceId(Integer.toString(i));
			builder.setStatus(false);
			base.controlPanel.DeviceStatusResponse build = builder.build();
			responseObserver.onNext(build);
			System.out.println("server device id is: " + i);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		responseObserver.onCompleted();
		
	}

	/**
	 * <pre>
	 * RPC Method 3: StreamDeviceLogs
	 * </pre>
	 */
	public io.grpc.stub.StreamObserver<base.controlPanel.DeviceIdentifier> streamDeviceLogs(
			io.grpc.stub.StreamObserver<base.controlPanel.DeviceLog> responseObserver) {

		// return asyncUnimplementedStreamingCall(getStreamDeviceLogsMethod(),
		// responseObserver);
		return null;
	}

}
