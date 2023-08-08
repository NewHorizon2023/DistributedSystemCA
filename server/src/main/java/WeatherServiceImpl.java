

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
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
	 * RPC Method 1: GetTemperature
	 * </pre>
	 */
	public void getTemperature(base.weather.WeatherLocation request,
			io.grpc.stub.StreamObserver<base.weather.TemperatureResponse> responseObserver) {
		// asyncUnimplementedUnaryCall(getGetTemperatureMethod(), responseObserver);
	}

	/**
	 * <pre>
	 * RPC Method 2: GetHumidity
	 * </pre>
	 */
	public void getHumidity(base.weather.WeatherLocation request,
			io.grpc.stub.StreamObserver<base.weather.HumidityResponse> responseObserver) {
		// asyncUnimplementedUnaryCall(getGetHumidityMethod(), responseObserver);
	}

	/**
	 * <pre>
	 * RPC Method 3: GetWeatherForecast
	 * </pre>
	 */
	public void getWeatherForecast(base.weather.WeatherForecastRequest request,
			io.grpc.stub.StreamObserver<base.weather.WeatherForecastResponse> responseObserver) {
		// asyncUnimplementedUnaryCall(getGetWeatherForecastMethod(), responseObserver);
	}

}
