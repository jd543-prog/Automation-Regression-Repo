package ServerOpen;

import java.io.File;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Service;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class StartServer2 {

	static String nodePath = "D:\\Android-2021\\Appium_Server_NodeJS\\node.exe";
	static String appiumMain_jsPath = "C:\\Users\\HP\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js";
	
	private static AppiumDriverLocalService service;
	//private static AppiumServiceBuilder builder;
	
	
	
	@Test
	public static void startServer() {
		
		service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File(nodePath))
				.withAppiumJS(new File(appiumMain_jsPath))
				.withIPAddress("127.0.0.1").usingPort(4723));
		
		service.start();
		System.out.println("Startsver.........");
		//service.stop();
	}

}
