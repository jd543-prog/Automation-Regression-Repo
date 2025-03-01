package TutorialMavenProject.Practice;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import PageObject.HomePage;
import PageObject.Preference;
import PageObject.PreferenceDependencies;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Revise1 extends Base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		driver = Base.Capability();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	
	
	//driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
	new HomePage(driver).preference.click();
	
	
	//driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
	new Preference(driver).preferenceDependency.click();
	
	
	//driver.findElementById("android:id/checkbox").click();
	
	new PreferenceDependencies(driver).wifiCheckBox.click();
	
	//driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
	
	new PreferenceDependencies(driver).wifiSetting.click();
	
	//driver.findElementByClassName("android.widget.EditText").sendKeys("wifi");
	
	new PreferenceDependencies(driver).wifiTextBox.sendKeys("honor123");
	
	//driver.findElementsByClassName("android.widget.Button").get(1).click();
	
	new PreferenceDependencies(driver).okButton.get(1).click();	
	

	}

}
