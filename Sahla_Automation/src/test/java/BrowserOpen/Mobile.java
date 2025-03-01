package BrowserOpen;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Mobile extends Basechrome {

	public static void main(String[] args) throws MalformedURLException {
		
AndroidDriver<AndroidElement> driver = capability();
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		
		driver.findElement(By.xpath("(//a[@href='/angularAppdemo/products'])[1]")).click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)" , "");
		
		String text = driver.findElement(By.xpath("(//a[@class='mt-0 font-weight-bold mb-2'])[3]")).getText();
		
		Assert.assertEquals(text, "Devops");

	}

}
