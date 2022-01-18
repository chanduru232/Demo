package edu.functionalconcepts;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG {
	
	public RemoteWebDriver driver;
	
	@BeforeMethod
	public void add()
	{
		
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	WebDriverManager.chromedriver().setup();
	//driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	driver.get("https://www.linkedin.com/login");
	driver.findElementById("join_now").click();
	
}
	@Test
public void ExecuteTest() {
		String localvalue = driver.findElementByClassName("page-help-link__link").getText();
		System.out.println(localvalue);
		
		
}
}
