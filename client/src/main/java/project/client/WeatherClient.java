package project.client;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import base.weather.WeatherForecastRequest;
import base.weather.WeatherForecastResponse;
import base.weather.WeatherGrpc;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.stub.MetadataUtils;
import project.jmdns.JmDnsServiceDiscovery;
import project.util.AuthenticationUtil;

public class WeatherClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherClient.class);

	public static void getWeatherForecastInvoke(double latitude, double longitude, ManagedChannel channel,
			String token) {
		WeatherGrpc.WeatherBlockingStub service = WeatherGrpc.newBlockingStub(channel);
		WeatherForecastRequest.Builder builder = WeatherForecastRequest.newBuilder();
		builder.setLatitude(latitude).setLongitude(longitude);
		WeatherForecastRequest request = builder.build();

		// Call the RPC method with the request and metadata
		WeatherForecastResponse response = service
				.withInterceptors(MetadataUtils.newAttachHeadersInterceptor(AuthenticationUtil.headersBuild(token)))
				.getWeatherForecast(request);

		LOGGER.info("Response received: " + response);
		LOGGER.info("Humidity: " + response.getHumidity());

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO For test.
		ManagedChannel channel = Grpc
				.newChannelBuilder(JmDnsServiceDiscovery.discoverTarget(), InsecureChannelCredentials.create()).build();
		try {
			getWeatherForecastInvoke(1, 2, channel, "");

			channel.awaitTermination(120, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			channel.shutdown();
		}
	}

}
