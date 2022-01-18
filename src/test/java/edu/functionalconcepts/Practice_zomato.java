package edu.functionalconcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Practice_zomato {
	public RemoteWebDriver driver;
	@Test
	public void zomato()
	{
		//Browser
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.zomato.com/chennai");
		//driver.findElementByXPath("//div[@class='sc-18n4g8v-0 gAhmYY sc-MYvYT bTQrEZ']").click();
		driver.findElementByXPath("//input[@class='sc-jxGEyO kfiBoC']/..").click();
		Actions act=new Actions(driver);
		WebElement search= driver.findElementByXPath("//ul[@id='navigation_ckxk7unqb000115o0bgcmhsyk']//input[@class='sc-jxGEyO kfiBoC']");
		act.moveToElement(search).click().build().perform();
		search.sendKeys("A2B",Keys.ENTER);
		
		WebElement submitBUtton = driver.findElementByXPath("//button[@id='search_btn']");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//for click
		jse.executeScript("arguments[0].click();", submitBUtton);
	
	}}


