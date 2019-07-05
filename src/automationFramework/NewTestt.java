package automationFramework;

import java.io.IOException;
import java.net.ServerSocket;


import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.service.local.*;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class NewTestt {

	 AppiumDriverLocalService service;
	 AppiumServiceBuilder builder;
	 DesiredCapabilities cap;
	
	public void startServer() {
System.out.println("1");
		//Set Capabilities
		cap = new DesiredCapabilities();
		cap.setCapability("noReset", "false");
		System.out.println("1.1");

		//Build the Appium service
		builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1");
		System.out.println("1.2");

		builder.usingPort(4723);
		builder.withCapabilities(cap);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
		System.out.println("1.3");

		
		//Start the server with the builder
		service = AppiumDriverLocalService.buildDefaultService();
		System.out.println("1.35");

		service.start();
		System.out.println("1.4");

	}
	
	public void stopServer() {
		service.stop();
	}

	public boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}	
	
	public static void main(String[] args) {
		NewTestt appiumServer = new NewTestt();
		
		int port = 4723;
		if(!appiumServer.checkIfServerIsRunnning(port)) {
			appiumServer.startServer();
			appiumServer.stopServer();
		} else {
			System.out.println("Appium Server already running on Port - " + port);
		}
	}

	
}