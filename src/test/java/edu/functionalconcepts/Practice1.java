package edu.functionalconcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Practice1 {
	public void add()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");

		driver.findElementByClassName("desktop-searchBar").sendKeys("Sunglass" + Keys.ENTER);
		// RadioButton.click;

				WebElement submitBUtton = driver.findElementByXPath("//input[@value='men,men women']");
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				// for click
				jse.executeScript("arguments[0].click();", submitBUtton);

				// Search_box
				driver.findElementByClassName("filter-search-filterSearchBox").click();
				driver.findElementByClassName("filter-search-inputBox").sendKeys("Polaroid" + Keys.ENTER);

				WebElement submitBUtton2 = driver.findElementByClassName("brand-num");
				JavascriptExecutor jse2 = (JavascriptExecutor) driver;
				// for click
				jse2.executeScript("arguments[0].click();", submitBUtton2);

				// ViewSmilarProducts
				WebElement viewSml = driver.findElementByXPath(
						"//div[@class='image-grid-similarColorsCta product-similarItemCta']//span[@class='image-grid-iconText']");
				JavascriptExecutor viewProd = (JavascriptExecutor) driver;
		        //Click
				viewProd.executeScript("arguments[0].click();", viewSml);
				//ScrollDown
				// viewProd.executeScript("arguments[0]. scrollIntoView(true);", viewSml);

	}

}
