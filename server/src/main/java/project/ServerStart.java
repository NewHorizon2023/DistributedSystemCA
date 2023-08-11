package project;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.grpc.BindableService;
import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import project.jmdns.JmDnsServiceRegistration;
import project.server.ControlPanelServiceImpl;
import project.server.LoginServiceImpl;
import project.server.PollutionSensorServiceImpl;
import project.server.WeatherServiceImpl;
import util.RepoPropertiesUtil;

public class ServerStart {
	public static void main(String[] args) throws IOException, InterruptedException {
		final ServerStart server = new ServerStart();
		server.start();
		server.blockUntilShutdown();
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(ServerStart.class);
	static Random rand = new Random();
	private Server server;

	/**
	 * Start all these 4 servers.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	private void start() throws IOException, InterruptedException {
		/* Grpc will find a suitable port to run the services (see "0" below) */
		server = Grpc.newServerBuilderForPort(0, InsecureServerCredentials.create())
				.addService((BindableService) new LoginServiceImpl())
				.addService((BindableService) new WeatherServiceImpl())
				.addService((BindableService) new ControlPanelServiceImpl())
				.addService((BindableService) new PollutionSensorServiceImpl()).build().start();
		JmDnsServiceRegistration.register(RepoPropertiesUtil.getProperty(RepoPropertiesUtil.GRPC_SERVER),
				server.getPort());
		LOGGER.info("Server started, listening on " + server.getPort());
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				// Use stderr here since the logger may have been reset by its JVM shutdown hook.
				LOGGER.error("*** shutting down gRPC server since JVM is shutting down");
				try {
					ServerStart.this.stop();
				} catch (InterruptedException e) {
					e.printStackTrace(System.err);
				}
				LOGGER.error("*** server shut down");
			}
		});
	}

	/**
	 * Stop server.
	 * 
	 * @throws InterruptedException
	 */
	private void stop() throws InterruptedException {
		if (server != null) {
			server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
		}
	}

	/**
	 * Await termination on the main thread since the grpc library uses daemon threads.
	 */
	private void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}

}
