package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Preference {

public Preference(AppiumDriver driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);  // it supports both android and ios
	}

	@FindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")
	public WebElement preferenceDependency;
	
}
