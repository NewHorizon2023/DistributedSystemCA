package project.jmdns;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import util.RepoPropertiesUtil;

public class JmDnsServiceDiscovery {
	private static final Logger LOGGER = LoggerFactory.getLogger(JmDnsServiceDiscovery.class);

	private static ServiceInfo serviceInfo = null;
	private static String locGrpc = "";
	private static JmDNS jmdns = null;

	private static class SampleListener implements ServiceListener {
		@Override
		public void serviceAdded(ServiceEvent event) {
			serviceInfo = event.getInfo();
			locGrpc = serviceInfo.getName().split("_", 1)[0];
			LOGGER.info("Service added: " + serviceInfo);
		}

		@Override
		public void serviceRemoved(ServiceEvent event) {
			serviceInfo = event.getInfo();
			locGrpc = serviceInfo.getName().split("_", 1)[0];
			LOGGER.info("Service removed: " + serviceInfo);
		}

		@Override
		public void serviceResolved(ServiceEvent event) {
			serviceInfo = event.getInfo();
			locGrpc = serviceInfo.getName().split("_", 1)[0];
			LOGGER.info("Service resolved: " + serviceInfo);
		}
	}

	public static void find(String service) throws InterruptedException {
		try {
			// Create a JmDNS instance
			jmdns = JmDNS.create(InetAddress.getLocalHost());

			// Add a service listener
			jmdns.addServiceListener(service, new SampleListener());
			LOGGER.info("Listening services");

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Discover locGrpc for client channel
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public static String discoverTarget() throws InterruptedException {
		// Service discovery part (Where's the gRPC server running?)
		find(RepoPropertiesUtil.getProperty(RepoPropertiesUtil.GRPC_SERVER)); // service name

		// wait for the service to be discovered
		while (locGrpc.length() < 2) {
			LOGGER.info("jmDnsServiceDiscovery: " + locGrpc);
		}

		return locGrpc;
	}
}