package Weather;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;

import java.io.IOException;

import Weather.WeatherGrpc.WeatherImplBase;
import ds.service4.Service4;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class Weather extends WeatherImplBase{
	
	public static void main(String[] args) throws InterruptedException, IOException {
		Service4 service1 = new Service4();

		int port = 50051;

		Server server = ServerBuilder.forPort(port)
				.addService(service1)
				.build()
				.start();

		System.out.println("Service-4 started, listening on " + port);

		server.awaitTermination();
	}
	
	@Override
	public void getTemperature(Weather.WeatherLocation request,
	        io.grpc.stub.StreamObserver<Weather.TemperatureResponse> responseObserver) {
	      asyncUnaryCall(
	          getChannel().newCall(getGetTemperatureMethod(), getCallOptions()), request, responseObserver);
	    }

}
