package track.service;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import track.controlPanel.ControlPanelGrpc.ControlPanelImplBase;

public class ControlPanel extends ControlPanelImplBase {

	public static void main(String[] args) throws InterruptedException, IOException {
		ControlPanel controlPanel = new ControlPanel();

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
	public void setDeviceStatus(track.controlPanel.DeviceStatusRequest request,
			io.grpc.stub.StreamObserver<track.controlPanel.DeviceStatusResponse> responseObserver) {

		// asyncUnimplementedUnaryCall(getSetDeviceStatusMethod(), responseObserver);

	}

	/**
	 * <pre>
	 * RPC Method 2: GetDeviceStatus
	 * </pre>
	 */
	public void getDeviceStatus(track.controlPanel.DeviceIdentifier request,
			io.grpc.stub.StreamObserver<track.controlPanel.DeviceStatusResponse> responseObserver) {
		// asyncUnimplementedUnaryCall(getGetDeviceStatusMethod(), responseObserver);
	}

	/**
	 * <pre>
	 * RPC Method 3: StreamDeviceLogs
	 * </pre>
	 */
	public io.grpc.stub.StreamObserver<track.controlPanel.DeviceIdentifier> streamDeviceLogs(
			io.grpc.stub.StreamObserver<track.controlPanel.DeviceLog> responseObserver) {

		// return asyncUnimplementedStreamingCall(getStreamDeviceLogsMethod(),
		// responseObserver);
		return null;
	}

}
