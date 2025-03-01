package PageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PreferenceDependencies {

public PreferenceDependencies(AppiumDriver driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@FindBy(id="android:id/checkbox")
	public WebElement wifiCheckBox;
	
	@FindBy(xpath="(//android.widget.RelativeLayout)[2]")
	public WebElement wifiSetting;
	
	@FindBy(className="android.widget.EditText")
	public WebElement wifiTextBox;
	
	@FindBy(className="android.widget.Button")
	public List<WebElement> okButton;
}
