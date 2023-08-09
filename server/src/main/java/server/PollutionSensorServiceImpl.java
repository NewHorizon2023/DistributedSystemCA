package server;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import util.TimeUtil;
import base.pollutionSensor.PollutionReading;
import base.pollutionSensor.PollutionSensorGrpc.PollutionSensorImplBase;

public class PollutionSensorServiceImpl extends PollutionSensorImplBase {

	public static void main(String[] args) throws InterruptedException, IOException {
		PollutionSensorServiceImpl pollutionSensorServiceImpl = new PollutionSensorServiceImpl();

		int port = 50052;

		Server server = ServerBuilder.forPort(port).addService(pollutionSensorServiceImpl).build().start();

		System.out.println("Service-Weather started, listening on " + port);

		server.awaitTermination();
	}

	/**
	 * <pre>
	 * RPC Method 1: GetPollutionLevel
	 * </pre>
	 */
	public void getPollutionLevel(base.pollutionSensor.PollutionLocation request,
			io.grpc.stub.StreamObserver<base.pollutionSensor.PollutionReading> responseObserver) {
		// TODO Try to use these 2 parameters.
		double latitude = request.getLatitude();
		double longitude = request.getLongitude();
		// TODO Build a pollution data
		PollutionReading.Builder builder = PollutionReading.newBuilder();
		builder.setPollutionLevel(getPollutionLevel());
		builder.setTimestamp(TimeUtil.getTimeNow());

		PollutionReading response = builder.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	/**
	 * <pre>
	 * RPC Method 2: SubscribeToPollutionUpdates
	 * </pre>
	 */
	public void subscribeToPollutionUpdates(base.pollutionSensor.PollutionLocation request,
			io.grpc.stub.StreamObserver<base.pollutionSensor.PollutionReading> responseObserver) {

		// TODO Response data through stream
		for (int i = 0; i < 10; i++) {
			PollutionReading.Builder builder = PollutionReading.newBuilder();
			// TODO Give pollution level a real value
			builder.setPollutionLevel(i);
			builder.setTimestamp(TimeUtil.getTimeNow());
			PollutionReading response = builder.build();
			responseObserver.onNext(response);

			try {
				// Give a 1 second gap to response
				Thread.sleep(1000);
			} catch (Exception e) {
				e.getStackTrace();
			}

		}
		responseObserver.onCompleted();
	}

	/**
	 * <pre>
	 * RPC Method 3: GetPollutionHistory
	 * </pre>
	 */
	public void getPollutionHistory(base.pollutionSensor.PollutionHistoryRequest request,
			io.grpc.stub.StreamObserver<base.pollutionSensor.PollutionHistoryResponse> responseObserver) {
		// asyncUnimplementedUnaryCall(getGetPollutionHistoryMethod(),
		// responseObserver);
	}

	/**
	 * Simulate to obtain pollution level.
	 * 
	 * @return
	 */
	private static double getPollutionLevel() {
		return getRandomDoubleInRange(1, 5);

	}

	/**
	 * Get random double value in range.
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	private static double getRandomDoubleInRange(double min, double max) {
		if (min >= max) {
			throw new IllegalArgumentException("min must be less than max");
		}

		// Create a random number generator.
		Random random = new Random();

		// Use the nextDouble method to generate a random double number in the range [0, 1)
		double randomNumber = random.nextDouble();

		// maps random double numbers to the specified range
		double result = min + randomNumber * (max - min);

		// Use DecimalFormat to keep two decimal places.
		DecimalFormat df = new DecimalFormat("#.##");
		return Double.parseDouble(df.format(result));
	}

}
