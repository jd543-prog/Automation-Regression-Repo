package ServerOpen;

import java.io.IOException;
import java.net.ServerSocket;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
	
	public class AppiumServerJava {

		static String nodePath = "D:\\Android-2021\\Appium_Server_NodeJS\\node.exe";
		static String appiumMain_jsPath = "D:\\Android-2021\\Appium_Server_NodeJS\\node_modules\\npm\\node_modules\\dotenv\\lib\\main.js";	
		
		private AppiumDriverLocalService service;
		private AppiumServiceBuilder builder;
		private DesiredCapabilities cap;

	
		
		
		
		public void startServer() {
		//Set Capabilities
		cap = new DesiredCapabilities();
		cap.setCapability("noReset", false);

		//Build the Appium service
		builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(4723);
		builder.withCapabilities(cap);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

		//Start the server with the builder
		service = AppiumDriverLocalService.buildService(builder);
		service.start();
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
		AppiumServerJava appiumServer = new AppiumServerJava();

		int port = 4723;
		if(!appiumServer.checkIfServerIsRunnning(port)) {
		appiumServer.startServer();
		appiumServer.stopServer();
		} else {
		System.out.println("Appium Server already running on Port – " + port);
		}
		}
		}
		
	


