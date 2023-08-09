package server;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import base.weather.WeatherForecastResponse;
import base.weather.WeatherGrpc.WeatherImplBase;
import enmu.ServiceInfoEnum;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import util.DataUtil;
import util.PropertiesUtil;

public class WeatherServiceImpl extends WeatherImplBase {

	public static void main(String[] args) throws InterruptedException, IOException {
//		WeatherServiceImpl weatherServiceImpl = new WeatherServiceImpl();
//
//		int port = 50053;
//
//		Server server = ServerBuilder.forPort(port).addService(weatherServiceImpl).build().start();
//
//		System.out.println("Service-Weather started, listening on " + port);
//
//		server.awaitTermination();

		try {
			// Create a jmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			int port = Integer.parseInt(PropertiesUtil.getProperty(PropertiesUtil.SERVER_PORT_3));

			// Define the service information for the gRPC service
			ServiceInfo serviceInfo = ServiceInfo.create(ServiceInfoEnum.WEATHER.getType(),
					ServiceInfoEnum.WEATHER.getName(), port, ServiceInfoEnum.WEATHER.getDescription());

			// Register the service with jmDNS
			jmdns.registerService(serviceInfo);

			System.out.println("Service registered with jmDNS: " + serviceInfo);

			// Start the gRPC server
			WeatherServiceImpl weatherServiceImpl = new WeatherServiceImpl();

			Server server = ServerBuilder.forPort(port).addService(weatherServiceImpl).build().start();

			System.out.println("gRPC Service-Weather started, listening on " + port);

			// Wait for the server to finish
			server.awaitTermination();

			// Unregister the service before exiting
			jmdns.unregisterAllServices();
			jmdns.close();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

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
		builder.setLatitude(latitude);
		builder.setLongitude(longitude);
		builder.setTemperature(DataUtil.getRandomDoubleInRange(-10, 30));
		builder.setHumidity(DataUtil.getRandomDoubleInRange(0.3, 0.6));
		builder.setWindSpeed(Math.round(DataUtil.getRandomDoubleInRange(0, 10)));
		builder.setPrecipitation(Math.round(DataUtil.getRandomDoubleInRange(0, 4)));

		WeatherForecastResponse response = builder.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

}
