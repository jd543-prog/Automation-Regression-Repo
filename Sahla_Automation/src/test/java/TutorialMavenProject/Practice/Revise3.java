package TutorialMavenProject.Practice;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Revise3 extends Base{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	
	AndroidDriver<AndroidElement> driver = Capability();
	
	TouchAction touch = new TouchAction(driver);     //("text(\"Date Widgets\")");
	
	WebElement view = driver.findElementByXPath("//android.widget.TextView[@text = 'Views']");
	touch.tap(tapOptions().withElement(element(view))).perform();
	
	WebElement date = driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")");
	touch.tap(tapOptions().withElement(element(date))).perform();
	
	WebElement inline = driver.findElementByAndroidUIAutomator("text(\"2. Inline\")");
	touch.tap(tapOptions().withElement(element(inline))).perform();
Thread.sleep(3000);																		//("//*[@content-desc = '9']"
	WebElement time = driver.findElementByXPath("//*[@content-desc = '9']");
	touch.tap(tapOptions().withElement(element(time))).perform();
	
	WebElement source =  driver.findElementByXPath("//*[@content-desc = '15']");
	WebElement target = driver.findElementByXPath("//*[@content-desc = '45']");
	
	touch.longPress(longPressOptions().withElement(element(source)).withDuration(ofSeconds(2)))
	.moveTo(element(target)).release().perform();
	
	}

}
