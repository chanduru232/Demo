package edu.functionalconcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization_test {
	@Parameters({"username,passward"})
	@Test
	public void naukri(String username1,String passward2)
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.linkedin.com/login");
		driver.findElementById("username").sendKeys("uname");
		driver.findElementById("password").sendKeys("Pcode");
		driver.findElementByXPath("//button[@class='btn__primary--large from__button--floating']").click();
	
	}
}
