package edu.functionalconcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class WorkingWindow {
	@Test
	public void naukri()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");
		List<WebElement> window= driver.findElementsByTagName("a");
		int count=window.size();
		System.out.println(count);
		for(WebElement singleElement:window)
		{
			System.out.println(singleElement.getText());
		}
	}
	

}



