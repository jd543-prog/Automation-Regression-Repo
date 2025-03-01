package BrowserOpen;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Basechrome {

	public static AndroidDriver<AndroidElement> capability() throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver;
				
				DesiredCapabilities capability = new DesiredCapabilities();
				
				capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus5Emulator");
				capability.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
				capability.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
				
				driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capability);
				
				return driver;
			}
}
