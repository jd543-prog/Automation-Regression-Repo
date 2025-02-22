package TutorialMavenProject.Practice;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Revise5  extends Base {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = Capability();
		
		driver.findElementByXPath("//android.widget.TextView[@text = 'Views']").click();
		
		TouchAction touch = new TouchAction(driver);
		
		WebElement dgdp = driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")");
		touch.tap(tapOptions().withElement(element(dgdp))).perform();
		
	WebElement source =	driver.findElements(By.className("android.view.View")).get(0);
	WebElement destination = driver.findElements(By.className("android.view.View")).get(1);
	
	touch.longPress(element(source)).moveTo(element(destination)).release().perform();
	
		
	}

}
