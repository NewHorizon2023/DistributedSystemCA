package project.server;

import base.weather.WeatherForecastResponse;
import base.weather.WeatherGrpc.WeatherImplBase;
import project.util.DataUtil;
import util.TimeUtil;

public class WeatherServiceImpl extends WeatherImplBase {
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
		builder.setLatitude(latitude);
		builder.setLongitude(longitude);
		builder.setTemperature(DataUtil.getRandomDoubleInRange(-10, 30));
		builder.setHumidity(DataUtil.getRandomDoubleInRange(0.3, 0.6));
		builder.setWindSpeed(Math.round(DataUtil.getRandomDoubleInRange(0, 10)));
		builder.setPrecipitation(Math.round(DataUtil.getRandomDoubleInRange(0, 4)));
		builder.setTimestamp(TimeUtil.getTimeNow());

		WeatherForecastResponse response = builder.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

}
