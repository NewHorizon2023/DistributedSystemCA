package server;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import util.DataUtil;
import base.weather.WeatherForecastResponse;
import base.weather.WeatherGrpc.WeatherImplBase;

public class WeatherServiceImpl extends WeatherImplBase {

	public static void main(String[] args) throws InterruptedException, IOException {
		WeatherServiceImpl weatherServiceImpl = new WeatherServiceImpl();

		int port = 50053;

		Server server = ServerBuilder.forPort(port).addService(weatherServiceImpl).build().start();

		System.out.println("Service-Weather started, listening on " + port);

		server.awaitTermination();
	}

	/**
	 * <pre>
	 * RPC Method: GetWeatherForecast
	 * </pre>
	 */
	@Override
	public void getWeatherForecast(base.weather.WeatherForecastRequest request,
			io.grpc.stub.StreamObserver<base.weather.WeatherForecastResponse> responseObserver) {

		double latitude = request.getLatitude();
		double longitude = request.getLongitude();

		WeatherForecastResponse.Builder builder = WeatherForecastResponse.newBuilder();

		// Create weather data.
		builder.setTemperature(DataUtil.getRandomDoubleInRange(-10, 30));
		builder.setHumidity(DataUtil.getRandomDoubleInRange(0.3, 0.6));
		builder.setWindSpeed(Math.round(DataUtil.getRandomDoubleInRange(0, 10)));
		builder.setPrecipitation(Math.round(DataUtil.getRandomDoubleInRange(0, 4)));

		WeatherForecastResponse response = builder.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

}
