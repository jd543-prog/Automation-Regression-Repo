package GeneralStore;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {

	static AndroidDriver<AndroidElement> driver;
	
	public static AndroidDriver<AndroidElement> Capability() throws MalformedURLException {
		
		File f = new File("src\\test\\java");
		File fs = new File(f , "General-Store.apk");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus5Emulator5554");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		
		 driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub") , cap);
		
		return driver;
	}
	
	
	
}
