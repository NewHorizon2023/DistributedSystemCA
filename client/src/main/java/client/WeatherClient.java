package client;

import base.weather.WeatherForecastRequest;
import base.weather.WeatherForecastResponse;
import base.weather.WeatherGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class WeatherClient {

	public static void getWeatherForecastInvoke(double latitude, double longitude) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
		try {
			WeatherGrpc.WeatherBlockingStub service = WeatherGrpc.newBlockingStub(channel);
			WeatherForecastRequest.Builder builder = WeatherForecastRequest.newBuilder();
			builder.setLatitude(latitude).setLongitude(longitude);
			WeatherForecastRequest request = builder.build();
			// TODO Show weather forecast data on gui.
			WeatherForecastResponse weatherForecast = service.getWeatherForecast(request);

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			channel.shutdown();
		}
	}

	public static void main(String[] args) {

	}

}
