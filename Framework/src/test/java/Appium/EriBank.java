package Appium;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class EriBank {
	
	private String UserName = "company";
	private String Password = "company";
	
	private String reportDirectory = "C:\\Test\\AppiumReports";
	private String reportFormat = "xml";
	private String testName = "BankApp.html";
	
	protected AndroidDriver driver = null;

	@BeforeClass
	public void setUp() throws MalformedURLException
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("reportDirectory", reportDirectory);
		dc.setCapability("reportFormat", reportFormat);
		dc.setCapability("testName", testName);
		dc.setCapability("noreset", true);
		dc.setCapability(MobileCapabilityType.UDID, "F5AZFG26K774");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
		driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	 @Test
	    public void EribTest() throws InterruptedException
	    {
	    	 String myBalance;

	    	 driver.findElement(By.id("usernameTextField")).sendKeys(UserName);
	         driver.findElement(By.id("passwordTextField")).sendKeys(Password);
	         driver.findElement(By.id("loginButton")).click();    
	         Thread.sleep(1000);
	         driver.findElement(By.id("makePaymentButton")).click();
	         driver.findElement(By.id("phoneTextField")).sendKeys("0541234567");
	         driver.findElement(By.id("nameTextField")).sendKeys("Yoni");
	         driver.findElement(By.id("amountTextField")).sendKeys("1");	         
	         driver.findElement(By.id("countryButton")).click();
	         driver.findElement(By.name("Greenland")).click();
	         driver.findElement(By.id("sendPaymentButton")).click();   
	         driver.findElement(By.id("button1")).click();                  
	         driver.findElement(By.id("logoutButton")).click();
	    	 driver.findElement(By.id("usernameTextField")).sendKeys(UserName);
	         driver.findElement(By.id("passwordTextField")).sendKeys(Password);
	         driver.findElement(By.id("loginButton")).click();    
	         Thread.sleep(1000);
	         myBalance = ((WebElement) driver.findElements(By.className("android.view.View")).get(0)).getAttribute("name");	         
	         System.out.println(myBalance);
	          
	    }
}
