package TutorialMavenProject.Practice;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Revise4  extends Base{

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = Capability();
		
		TouchAction touch = new TouchAction(driver);
		
		WebElement view = driver.findElementByAndroidUIAutomator("text(\"Views\")");
		touch.tap(tapOptions().withElement(element(view))).perform();
		
		//WebElement webView = driver.findElementByAndroidUIAutomator("text(\"WebView\")");
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");

	}							//.scrollIntoView(text(\"WebView\"))
								//new UiScrollable(new UiSelector())

}
