package ServerOpen;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class StartServer1 {

	
	private AppiumDriverLocalService service;

	@BeforeClass
	public void setUp() throws Exception {

		service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("D:\\Android-2021\\Appium_Server_NodeJS\\node.exe"))
						.withAppiumJS(new File("D:\\Android-2021\\Appium_Server_NodeJS\\node_modules\\npm\\node_modules\\dotenv\\lib\\main.js"))
						.withIPAddress("127.0.0.1").usingPort(4723));
		service.start();
	}

	@Test
	public void getAppiumStatus() {

		System.out.println("server is running............");
	}

	@AfterClass
	public void tearDown() {
		
		 service.stop();
	}
}
