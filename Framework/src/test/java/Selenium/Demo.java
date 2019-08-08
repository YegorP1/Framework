package Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class Demo {
 
private static WebDriver driver;
	
	@BeforeMethod
	
	public static void openBrowser()
	{	
		System.setProperty("webdriver.chrome.driver", "C:/Automation/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("http://seleniumhq.org/");
	}
	
	@Test
	public void test1() throws InterruptedException
	{	
		Thread.sleep(2000);
	}
		
	@AfterMethod
	public static void closeBrowser()
	{
		driver.quit();
	}
}
