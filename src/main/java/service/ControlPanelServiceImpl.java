package service;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import base.controlPanel.ControlPanelGrpc.ControlPanelImplBase;

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
