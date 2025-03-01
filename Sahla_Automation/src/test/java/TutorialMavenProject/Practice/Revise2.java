package TutorialMavenProject.Practice;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.touch.TouchActions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Revise2 extends Base {

	public static void main(String[] args) throws MalformedURLException {
		
		driver = Base.Capability();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	TouchAction touch = new TouchAction(driver);
	
	WebElement view = driver.findElementByAndroidUIAutomator("text(\"Views\")");
	//driver.findElementByXPath("//android.widget.TextView[@text='Views']");
	
	touch.tap(tapOptions().withElement(element(view))).perform();

	WebElement expandable = driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
	//driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']"));
	touch.tap(tapOptions().withElement(element(expandable))).perform();
	
	WebElement ca = driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")"); 
	//driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']"));
	touch.tap(tapOptions().withElement(element(ca))).perform();
	
	WebElement pn = driver.findElementByAndroidUIAutomator("text(\"People Names\")"); 
	//driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
	touch.longPress(longPressOptions().withElement(element(pn)).withDuration(Duration.ofSeconds(2))).release().perform();
	
	}

}
