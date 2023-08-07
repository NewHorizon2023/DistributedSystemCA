package client;

import java.util.Iterator;

import base.controlPanel.ControlPanelGrpc;
import base.controlPanel.DeviceIdentifier;
import base.controlPanel.DeviceStatusResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientTest {
	public static void main(String[] args) {
		/*
		 * ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",
		 * 50051).usePlaintext().build(); // ManagedChannel channel =
		 * ManagedChannelBuilder.forAddress("192.168.0.239",
		 * 50051).usePlaintext().build(); try {
		 * ControlPanelGrpc.ControlPanelBlockingStub controlPanleService =
		 * ControlPanelGrpc.newBlockingStub(channel);
		 * base.controlPanel.DeviceStatusRequest.Builder builder =
		 * base.controlPanel.DeviceStatusRequest.newBuilder();
		 * builder.setDeviceId("0000"); builder.setStatus(false);
		 * base.controlPanel.DeviceStatusRequest request = builder.build();
		 * base.controlPanel.DeviceStatusResponse response =
		 * controlPanleService.setDeviceStatus(request); String deviceId =
		 * response.getDeviceId(); boolean status = response.getStatus();
		 * System.out.println(deviceId + ", " + status); } catch (Exception e) { throw
		 * new RuntimeException(); } finally { channel.shutdown(); }
		 */
// -----------------------------------------------------------------------------------------------------------
		ManagedChannel channel2 = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
		try {
			ControlPanelGrpc.ControlPanelBlockingStub controlPanelBlockingStub = ControlPanelGrpc.newBlockingStub(channel2);
			base.controlPanel.DeviceIdentifier.Builder builder = base.controlPanel.DeviceIdentifier.newBuilder();
			builder.setDeviceId("11111");
			base.controlPanel.DeviceIdentifier request = builder.build();
			Iterator<base.controlPanel.DeviceStatusResponse> responseIterator = controlPanelBlockingStub.getDeviceStatus(request);
			while(responseIterator.hasNext()) {
				DeviceStatusResponse next = responseIterator.next();
				System.out.println("Response- device id is: " + next.getDeviceId());
				System.out.println("Response- device status is: " + next.getStatus());
			}
			
		}catch(Exception e) {
			e.setStackTrace(null);
		}finally {
			channel2.shutdown();
		}
	}
	
}
