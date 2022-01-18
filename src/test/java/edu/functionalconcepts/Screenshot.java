package edu.functionalconcepts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Screenshot {
	public RemoteWebDriver driver;
	@Test
	public void myntra() throws IOException 
	{
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/sunglasses");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// for click
		WebElement submitBUtton = driver.findElementByXPath("//ul[@class='gender-list']/li[1]//input");
		jse.executeScript("arguments[0].click();", submitBUtton);
		driver.findElementByXPath("//input[@placeholder='Search for Brand']/../span").click();
		driver.findElementByXPath("//input[@placeholder='Search for Brand']").sendKeys("polaroid");

		WebElement polaroidCheck = driver.findElementByXPath("//input[@value='Polaroid']/../div");
		jse.executeScript("arguments[0].click();", polaroidCheck);
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./snaps/screenshot1.jpeg"));
		
		System.out.println("screenshot 1 taken");
		
		WebElement firstElement = driver.findElementByXPath("(//div[@class='product-sliderContainer'])[1]");

		System.out.println("cursor moved over first element");


		Actions actionObj = new Actions(driver);
		actionObj.moveToElement(firstElement).perform();

		WebElement similarElement = driver.findElementByXPath("(//div[contains(@class,'product-similarItemCta')])[1]");
		actionObj.moveToElement(similarElement).build().perform();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(@class,'product-similarItemCta')])[1]//span[text()='VIEW SIMILAR']")));

		//Thread.sleep(2000);
		System.out.println("similar item selected");
		WebElement similarProduct = driver.findElementByXPath(
				"(//div[contains(@class,'product-similarItemCta')])[1]//span[text()='VIEW SIMILAR']");
		jse.executeScript("arguments[0].click();", similarProduct);		
		
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'halfcard-closeLeftCard')]/span")));
		File SimilarProductSource= driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SimilarProductSource, new File("./snaps/screenshot2.jpeg"));
		
		System.out.println("screenshot 2 taken");
	}}


