package edu.functionalconcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Practice_Snapdeal {
	
	
	@Test
	public void title()
	{
		//Browser
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		
		//click womens fashion
	driver.findElementByXPath("(//span[@class='catText'])[2]").click();
	
	Actions actionObj = new Actions(driver);
	WebElement SpecificCourse = driver.findElementByXPath("//span[@class='headingText']");
	actionObj.moveToElement(SpecificCourse).click().build().perform();
		
		
	}

}
