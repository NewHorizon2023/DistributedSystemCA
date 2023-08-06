package service;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
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
	public void getPollutionLevel(track.pollutionSensor.PollutionLocation request,
			io.grpc.stub.StreamObserver<track.pollutionSensor.PollutionReading> responseObserver) {
		// asyncUnimplementedUnaryCall(getGetPollutionLevelMethod(), responseObserver);
	}

	/**
	 * <pre>
	 * RPC Method 2: SubscribeToPollutionUpdates
	 * </pre>
	 */
	public void subscribeToPollutionUpdates(track.pollutionSensor.PollutionLocation request,
			io.grpc.stub.StreamObserver<track.pollutionSensor.PollutionReading> responseObserver) {
		// asyncUnimplementedUnaryCall(getSubscribeToPollutionUpdatesMethod(),
		// responseObserver);
	}

	/**
	 * <pre>
	 * RPC Method 3: GetPollutionHistory
	 * </pre>
	 */
	public void getPollutionHistory(track.pollutionSensor.PollutionHistoryRequest request,
			io.grpc.stub.StreamObserver<track.pollutionSensor.PollutionHistoryResponse> responseObserver) {
		// asyncUnimplementedUnaryCall(getGetPollutionHistoryMethod(),
		// responseObserver);
	}

}
