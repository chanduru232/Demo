package edu.functionalconcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Open_MRS_Delete {
	public class Open_MRS_update {
		public WebDriver driver;
		@Test
		public void login() throws InterruptedException
		{
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		
		driver.findElementByXPath("//input[@id='username']").sendKeys("Admin");
		driver.findElementByXPath("//input[@id='password']").sendKeys("Admin123");
		driver.findElementByXPath("//li[@id='Isolation Ward']").click();
		driver.findElementByXPath("//input[@id='loginButton']").click();
		
		//Serarch
		driver.findElementById("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension").click();
		driver.findElementById("patient-search").sendKeys("v chandan chandru",Keys.ENTER);
		
		Thread.sleep(3000);
		
		Actions act=new Actions(driver);
		WebElement select1= driver.findElementByXPath("//tr[@class='odd']/..");
		act.moveToElement(select1).click().build().perform();
		
		Thread.sleep(3000);
		WebElement click1= driver.findElementByXPath("(//div[@class='col-11 col-lg-10'])[8]/..");
		act.moveToElement(click1).click().build().perform();
		driver.findElementById("delete-reason").sendKeys("Have another Account");
		driver.findElementByXPath("(//button[@class='confirm right'])[6]").click();
		}
	}}
