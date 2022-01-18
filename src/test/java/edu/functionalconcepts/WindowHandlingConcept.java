package edu.functionalconcepts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class WindowHandlingConcept {

	@Test
	public void naukri() {
		// Browser lunch
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//using linkedin.com
		driver.get("https://www.linkedin.com/login");
		driver.findElementById("join_now").click();

		String localvalue = driver.findElementByClassName("page-help-link__link").getText();
		System.out.println(localvalue);

//Find a name
		String FirstWindowName = driver.getTitle();
		System.out.println("Window Titele" + FirstWindowName);

//Find ID
		String WindowName = driver.getWindowHandle();
		System.out.println("First window ID" + WindowName);

//Find link
	
		driver.findElementByClassName("page-help-link__link").click();
		Set<String> WindowHandleId = driver.getWindowHandles();
		
		
		for (String windowhandle : WindowHandleId) {
			System.out.println(windowhandle);
			
			if(!windowhandle.equals(WindowHandleId))
			{
				driver.switchTo().window(WindowName);
			}
		
	}

	}}
