package client;

import java.util.Iterator;
import java.util.List;

import base.pollutionSensor.PollutionHistoryRequest;
import base.pollutionSensor.PollutionHistoryResponse;
import base.pollutionSensor.PollutionLocation;
import base.pollutionSensor.PollutionReading;
import base.pollutionSensor.PollutionSensorGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class PollutionSensorClient {

	/**
	 * Get pollution level infomation.
	 * 
	 * @param latitude
	 * @param longitude
	 */
	public static void getPollutionLevelInvoke(double latitude, double longitude) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
		try {
			PollutionSensorGrpc.PollutionSensorBlockingStub service = PollutionSensorGrpc.newBlockingStub(channel);
			PollutionLocation.Builder builder = PollutionLocation.newBuilder();
			builder.setLatitude(latitude);
			builder.setLongitude(longitude);
			PollutionLocation request = builder.build();
			Iterator<PollutionReading> pollutionLevelIterator = service.getPollutionLevel(request);

			// Get pollution level infomation
			while (pollutionLevelIterator.hasNext()) {
				PollutionReading pollution = pollutionLevelIterator.next();
				// TODO show these data on gui.
				double pollutionLevel = pollution.getPollutionLevel();
				String timestamp = pollution.getTimestamp();
			}

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			channel.shutdown();
		}
	}

	/**
	 * Get pollution history data.
	 * 
	 * @param latitude
	 * @param longitude
	 * @param startDate
	 * @param endDate
	 */
	public static void getPollutionHistoryInvoke(double latitude, double longitude, String startDate, String endDate) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
		try {
			PollutionSensorGrpc.PollutionSensorBlockingStub service = PollutionSensorGrpc.newBlockingStub(channel);
			PollutionHistoryRequest.Builder builder = PollutionHistoryRequest.newBuilder();
			builder.setLatitude(latitude).setLongitude(longitude).setStartDate(startDate).setEndDate(endDate);

			PollutionHistoryRequest request = builder.build();
			PollutionHistoryResponse response = service.getPollutionHistory(request);
			// TODO show data on gui
			List<PollutionReading> pollutionReadingList = response.getPollutionReadingsList();

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			channel.shutdown();
		}

	}
}
