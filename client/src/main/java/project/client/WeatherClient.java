package project.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import base.weather.WeatherForecastRequest;
import base.weather.WeatherForecastResponse;
import base.weather.WeatherGrpc;
import io.grpc.ManagedChannel;
import io.grpc.stub.MetadataUtils;
import project.util.AuthenticationUtil;

public class WeatherClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherClient.class);

	/**
	 * Get weather infomation.
	 * 
	 * @param latitude
	 * @param longitude
	 * @param channel
	 * @param token
	 * @return
	 */
	public static WeatherForecastResponse getWeatherForecastInvoke(double latitude, double longitude,
			ManagedChannel channel, String token) {
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

		return response;
	}

}
