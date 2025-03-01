package ServerOpen;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Emulator extends StartServer2{


	
public static void startEmulator() throws IOException, InterruptedException {
		
		Runtime.getRuntime().exec("D:\\Mobile Automation Project-2021\\Practice\\src\\test\\java\\resources\\StartEmulator.bat");
		Thread.sleep(6000);
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		
		StartServer2.startServer();
		
		
		File appDir = new File("src\\test\\java");
		File apkFile = new File(appDir ,"ApiDemos-debug.apk");  // parent , child 
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		startEmulator();
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME , "Nexus5Emulator");
		
		cap.setCapability(MobileCapabilityType.APP , apkFile.getAbsolutePath());
		
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME , "uiautomator2");  // uiautomator2 -> current android driver
		
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

}
