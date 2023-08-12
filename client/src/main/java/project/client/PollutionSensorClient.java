package project.client;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import base.pollutionSensor.PollutionHistoryRequest;
import base.pollutionSensor.PollutionHistoryResponse;
import base.pollutionSensor.PollutionLocation;
import base.pollutionSensor.PollutionReading;
import base.pollutionSensor.PollutionSensorGrpc;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.stub.MetadataUtils;
import project.jmdns.JmDnsServiceDiscovery;
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
	 */
	public static void getPollutionLevelInvoke(double latitude, double longitude, ManagedChannel channel,
			String token) {
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
			// TODO show these data on gui.
			double pollutionLevel = pollution.getPollutionLevel();
			String timestamp = pollution.getTimestamp();
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
		// TODO show data on gui

		return response.getPollutionReadingsList();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO For test.
		ManagedChannel channel = Grpc
				.newChannelBuilder(JmDnsServiceDiscovery.discoverTarget(), InsecureChannelCredentials.create()).build();
		try {
			getPollutionLevelInvoke(1, 2, channel, "");
			getPollutionHistoryInvoke(1, 2, "2023-08-09 20:00:00", "2023-08-09 21:00:00", channel, "");

			channel.awaitTermination(120, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			channel.shutdown();
		}
	}

}
