package edu.functionalconcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
public class RedBus_practice {	
	public static void main(String args[]) throws InterruptedException
	{
		
		//Browser Lounch
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");	
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		//To enter boding point
		Actions act=new Actions(driver);
		WebElement boding= driver.findElementById("src");
		act.moveToElement(boding).click().build().perform();
		boding.sendKeys("Koyambedu, Chennai"+Keys.ENTER);
		
		//To enter ending point
		WebElement end= driver.findElementByXPath("//input[@id='dest']");
		act.moveToElement(end).click().build().perform();
		end.sendKeys("Majestic, Bangalore"+Keys.ENTER);
		
		//Select trip date
		driver.findElementById("onward_cal").click();
		driver.findElementByClassName("next").click();
		WebElement day= driver.findElementByXPath("(//td[@class='wd day'])[15]");
		act.moveToElement(day).click().build().perform();
		Thread.sleep(3000);
		
		//search bus
		//WebElement button= driver.findElementByXPath("//button[@id='search_btn']");
		//act.moveToElement(button).click().build().perform();
		
		WebElement submitBUtton = driver.findElementByXPath("//button[@id='search_btn']");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//for click
		jse.executeScript("arguments[0].click();", submitBUtton);
		}

}
