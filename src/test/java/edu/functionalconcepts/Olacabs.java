package edu.functionalconcepts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import kotlin.collections.ArrayDeque;

public class Olacabs {
	WebDriver driver;

	@Test
	public void olaPickup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.olacabs.com/");

		Actions aObj = new Actions(driver);
		//Moving to OutStation
		WebElement outstation = driver.findElementByXPath("//a[text()='Outstation']");
		aObj.moveToElement(outstation).click().build().perform();
		//Current Location
		driver.switchTo().frame(0);

		WebElement submitBUtton = driver.findElementByXPath("//div[@class='middle h-full text value']/..");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//for click
		jse.executeScript("arguments[0].click();", submitBUtton);
		
		WebElement click1= driver.findElementByXPath("//div[@class='middle h-full text value']/..");
		aObj.moveToElement(click1).click().build().perform();
		driver.findElementById("addressInput").sendKeys("chennai one");
		
		WebElement droup= driver.findElementByXPath("//div[@class='address']/..");
		aObj.moveToElement(droup).click().build().perform();
		
		driver.findElementByXPath("//div[@class='middle h-full text placeholder']/..").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@id='addressInput']").sendKeys("Bangalore");
		WebElement droup1= driver.findElementByXPath("//div[@class='middle text']/..");
		aObj.moveToElement(droup1).click().build().perform();
		
		Thread.sleep(3000);
		//search outstation cabes
		driver.findElementByXPath("//div[@class='ow-button-container']").click();
		Set<String> windowHandles=  driver.getWindowHandles();
		List<String> list=new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
	}

	
}