package project.client;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import base.pollutionSensor.PollutionHistoryRequest;
import base.pollutionSensor.PollutionHistoryResponse;
import base.pollutionSensor.PollutionLocation;
import base.pollutionSensor.PollutionReading;
import base.pollutionSensor.PollutionSensorGrpc;
import io.grpc.ManagedChannel;
import io.grpc.stub.MetadataUtils;
import project.callback.CallBack;
import project.util.AuthenticationUtil;

public class PollutionSensorClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(PollutionSensorClient.class);

	/**
	 * Get pollution level infomation.
	 * 
	 * @param latitude
	 * @param longitude
	 * @param channel
	 * @param token
	 * @param callBack
	 */
	public static void getPollutionLevelInvoke(double latitude, double longitude, ManagedChannel channel, String token,
			CallBack callBack) {
		PollutionSensorGrpc.PollutionSensorBlockingStub service = PollutionSensorGrpc.newBlockingStub(channel);
		PollutionLocation.Builder builder = PollutionLocation.newBuilder();
		builder.setLatitude(latitude);
		builder.setLongitude(longitude);
		PollutionLocation request = builder.build();
		Iterator<PollutionReading> pollutionLevelIterator = service
				.withInterceptors(MetadataUtils.newAttachHeadersInterceptor(AuthenticationUtil.headersBuild(token)))
				.getPollutionLevel(request);

		// Get pollution level infomation
		while (pollutionLevelIterator.hasNext()) {
			PollutionReading pollution = pollutionLevelIterator.next();
			double pollutionLevel = pollution.getPollutionLevel();
			String timestamp = pollution.getTimestamp();

			// Show the response data on the GUI board.
			callBack.show("Timestamp: " + timestamp + "      Pollution Level: " + pollutionLevel);
			LOGGER.info("pollution level: " + pollutionLevel + "time: " + timestamp);
		}

	}

	/**
	 * Get pollution history data.
	 * 
	 * @param latitude
	 * @param longitude
	 * @param startDate
	 * @param endDate
	 * @param channel
	 * @param token
	 * @return
	 */
	public static List<PollutionReading> getPollutionHistoryInvoke(double latitude, double longitude, String startDate,
			String endDate, ManagedChannel channel, String token) {
		PollutionSensorGrpc.PollutionSensorBlockingStub service = PollutionSensorGrpc.newBlockingStub(channel);
		PollutionHistoryRequest.Builder builder = PollutionHistoryRequest.newBuilder();
		builder.setLatitude(latitude).setLongitude(longitude).setStartDate(startDate).setEndDate(endDate);

		PollutionHistoryRequest request = builder.build();
		PollutionHistoryResponse response = service
				.withInterceptors(MetadataUtils.newAttachHeadersInterceptor(AuthenticationUtil.headersBuild(token)))
				.getPollutionHistory(request);

		return response.getPollutionReadingsList();
	}

}
