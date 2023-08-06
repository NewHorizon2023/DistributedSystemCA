package client;

import base.controlPanel.ControlPanelGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientTest {
	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
		try {
			ControlPanelGrpc.ControlPanelBlockingStub controlPanleService = ControlPanelGrpc.newBlockingStub(channel);
			base.controlPanel.DeviceStatusRequest.Builder builder = base.controlPanel.DeviceStatusRequest.newBuilder();
			builder.setDeviceId("0000");
			builder.setStatus(false);
			base.controlPanel.DeviceStatusRequest request = builder.build();
			base.controlPanel.DeviceStatusResponse response = controlPanleService.setDeviceStatus(request);
			String deviceId = response.getDeviceId();
			boolean status = response.getStatus();
			System.out.println(deviceId + ", " + status);
		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
			channel.shutdown();
		}

	}
}
