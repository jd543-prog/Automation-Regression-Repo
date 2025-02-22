package GeneralStore;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TestCase extends Base {
	
	private static TouchAction touch; 
	private static AndroidDriver<AndroidElement> driver;
	private double sum =0;
	
	@Test(priority = 0)
	public void formFillUp() throws MalformedURLException, InterruptedException {
		
		driver = Capability();
		//touch = new TouchAction(driver);
	Thread.sleep(3000);	
	driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))");
	driver.findElementByAndroidUIAutomator("text(\"Argentina\")").click();
	driver.findElementByAndroidUIAutomator("text(\"Let's  Shop\")").click();
	
	String toastName = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
	System.out.println(toastName);
	
    driver.findElement(By.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("JhonDiggle");
    driver.hideKeyboard();
    driver.findElementByAndroidUIAutomator("text(\"Male\")").click();
    driver.findElementByAndroidUIAutomator("text(\"Let's  Shop\")").click();
	}
	
	@Test(priority = 1)
	public void addToCart() {
//product1:-		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Air Jordan 9 Retro\").instance(0))"));	
		
		int size = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
	for(int i=0;i<size;i++) {
		
		String ProductName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
		System.out.println(ProductName);
    if(ProductName.equalsIgnoreCase("Air Jordan 9 Retro")) {
			
			driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
			break;
		}	
		
	}
	
//product-2:-
	
	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));	
	
	
	
  for(int i=0;i<size;i++) {
	
	String ProductName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
	System.out.println(ProductName);
if(ProductName.equalsIgnoreCase("Jordan 6 Rings")) {
		
		driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
		break;
	}	
	
}

	
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	}
	
	@Test(priority = 2)
	public void mainCart() {
		
		int size = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		
		for(int i=0;i<size;i++) {
			
		String individualProductValue = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText().substring(1);
		double productItem = Double.parseDouble(individualProductValue);
		System.out.println(productItem);
		sum = sum + productItem;
		
		}
		
		double productSum = sum;
		System.out.println("TotalProductSUM="+productSum);
		
		String productPrice = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(2);
		double totalPurchaseAmount = Double.parseDouble(productPrice);
		System.out.println("TotalPurchaseAmount="+totalPurchaseAmount);
		
		Assert.assertEquals(productSum, totalPurchaseAmount);
		
	}
	
	@Test(priority=3)
	public void visitWebsite() {
		
		driver.findElementByClassName("android.widget.CheckBox").click();
		driver.findElementByAndroidUIAutomator("text(\"Visit to the website to complete purchase\")").click();
	}
	
	@Test(priority=4)
	public void contextHandles() throws InterruptedException {
		
		
	Thread.sleep(10000);
		
		
		for(String contextName : driver.getContextHandles()) {
			
			System.out.println(contextName);  
			
			driver.context(contextName);
		}
		
		

		driver.findElement(By.name("q")).sendKeys("ARROW");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		//driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		for(String contextName : driver.getContextHandles()) {
			
			System.out.println(contextName);  
			
			driver.context(contextName);
		}
		
		
	}
}























