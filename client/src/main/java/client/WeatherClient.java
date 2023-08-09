package client;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.CompletableFuture;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;

import base.weather.WeatherForecastRequest;
import base.weather.WeatherForecastResponse;
import base.weather.WeatherGrpc;
import enmu.ServiceInfoEnum;
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
			System.out.println("Humidity: " + weatherForecast.getHumidity());

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			channel.shutdown();
		}
		
//		try {
//		    JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
//
//		    CompletableFuture<Void> grpcCallFuture = new CompletableFuture<>();
//
//		    // Add a service listener to listen for available services
//		    jmdns.addServiceListener(ServiceInfoEnum.WEATHER.getType(), new ServiceListener() {
//		        @Override
//		        public void serviceAdded(ServiceEvent event) {
//		            System.out.println("Service added: " + event.getInfo());
//
//		            // Here, you can extract the service information and use it to create a gRPC channel
//		            InetAddress hostAddress = event.getInfo().getInetAddresses()[0]; // Get the first address
//		            int port = event.getInfo().getPort();
//
//		            // Create a gRPC channel to connect to the service
//		            ManagedChannel channel = ManagedChannelBuilder.forAddress(hostAddress.getHostAddress(), port)
//		                    .usePlaintext().build();
//
//		            try {
//		                WeatherGrpc.WeatherBlockingStub service = WeatherGrpc.newBlockingStub(channel);
//		                WeatherForecastRequest.Builder builder = WeatherForecastRequest.newBuilder();
//		                builder.setLatitude(latitude).setLongitude(longitude);
//		                WeatherForecastRequest request = builder.build();
//		                // TODO: Show weather forecast data on GUI
//		                WeatherForecastResponse weatherForecast = service.getWeatherForecast(request);
//
//		                System.out.println("Weather Forecast ///////////////: " + weatherForecast);
//
//		                grpcCallFuture.complete(null); // Mark the gRPC call as completed
//		            } catch (Exception e) {
//		                e.printStackTrace();
//		                grpcCallFuture.completeExceptionally(e); // Mark the gRPC call as completed with exception
//		            } finally {
//		                channel.shutdown();
//		            }
//		        }
//
//				@Override
//				public void serviceRemoved(ServiceEvent event) {
//					// TODO Auto-generated method stub
//					
//				}
//
//				@Override
//				public void serviceResolved(ServiceEvent event) {
//					// TODO Auto-generated method stub
//					
//				}
//
//		        // ... (other methods)
//
//		    });
//
//		    // Wait for the gRPC call to complete before closing JmDNS
//		    grpcCallFuture.join();
//
//		    jmdns.close();
//		} catch (IOException e) {
//		    e.printStackTrace();
//		}

	}

	public static void main(String[] args) {
		getWeatherForecastInvoke(1, 2);
	}

}
