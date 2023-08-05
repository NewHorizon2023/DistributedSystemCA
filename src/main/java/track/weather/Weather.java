package track.weather;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import track.weather.WeatherGrpc.WeatherImplBase;

public class Weather extends WeatherImplBase {

	public static void main(String[] args) throws InterruptedException, IOException {
		Weather weather = new Weather();

		int port = 50053;

		Server server = ServerBuilder.forPort(port).addService(weather).build().start();

		System.out.println("Service-Weather started, listening on " + port);

		server.awaitTermination();
	}

	/**
	 * <pre>
	 * RPC Method 1: GetTemperature
	 * </pre>
	 */
	public void getTemperature(track.weather.WeatherLocation request,
			io.grpc.stub.StreamObserver<track.weather.TemperatureResponse> responseObserver) {
		// asyncUnimplementedUnaryCall(getGetTemperatureMethod(), responseObserver);
	}

	/**
	 * <pre>
	 * RPC Method 2: GetHumidity
	 * </pre>
	 */
	public void getHumidity(track.weather.WeatherLocation request,
			io.grpc.stub.StreamObserver<track.weather.HumidityResponse> responseObserver) {
		// asyncUnimplementedUnaryCall(getGetHumidityMethod(), responseObserver);
	}

	/**
	 * <pre>
	 * RPC Method 3: GetWeatherForecast
	 * </pre>
	 */
	public void getWeatherForecast(track.weather.WeatherForecastRequest request,
			io.grpc.stub.StreamObserver<track.weather.WeatherForecastResponse> responseObserver) {
		// asyncUnimplementedUnaryCall(getGetWeatherForecastMethod(), responseObserver);
	}

}
