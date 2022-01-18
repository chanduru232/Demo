package edu.functionalconcepts;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice_AJIO {
	public RemoteWebDriver driver;
	@Test
	public void ajio()	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		//Browser
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		//link
		driver.get("https://www.ajio.com/");
		driver.findElementByXPath("//input[@autocomplete='off']").sendKeys("Shoes"+Keys.ENTER);
		//check box
		WebElement checkbox= driver.findElementByXPath("//label[@class='facet-linkname facet-linkname-genderfilter facet-linkname-Women']");
		checkbox.click();
	
		//select grid box
		driver.findElementByXPath("//span[@class='ic-Chevron-down']/..").click();
		
		//select new : whats new
		//Action Class 
		Actions actionObj = new Actions(driver);
		WebElement SpecificCourse = driver.findElementByXPath("//span[@class='ic-Chevron-down']");
		actionObj.moveToElement(SpecificCourse).click().build().perform();
		
		WebElement whatnew=driver.findElementByXPath("//option[@value='newn']/..");
		Select what=new Select(whatnew);
		what.selectByValue("newn");
		
		//price
		driver.findElementByXPath("//div[@id='facets']//span[text()='price']").click();
		
		WebElement min= driver.findElementById("minPrice");
		actionObj.moveToElement(min).click().build().perform();
		min.sendKeys("2000");
		
		WebElement max= driver.findElementById("maxPrice");
		actionObj.moveToElement(max).click().perform();
		max.sendKeys("2501");
		
		driver.findElementByXPath("//button[@type='submit']/..").click();
		
		//first product
		driver.findElementByXPath("//img[@class='rilrtl-lazy-img  rilrtl-lazy-img-loaded']/..").click();
		Set<String> WindowHandles=driver.getWindowHandles();
		List<String> list=new ArrayList<String>(WindowHandles);
		driver.switchTo().window(list.get(1));
		
		//Actualprice
		String prices= driver.findElementByXPath("//div[@class='prod-sp']/..").getText();
		System.out.println("Actual price"+prices);
		
		//dicount
		String discount= driver.findElementByXPath("//div[@class='promo-desc']/..").getText();			
		System.out.println("Discount"+discount);
		
		//other information
		String other=driver.findElementByXPath("//i[@class='ic-angle-down']/..").getText();
		System.out.println(other);
		
		//size
		driver.findElementByXPath("//div[@class='circle size-variant-item size-instock ']").click();
		
		//pincode
		driver.findElementByXPath("//span[@class='edd-pincode-msg-details edd-pincode-msg-details-pointer edd-pincode-msg-details-text-color']/..").click();
		driver.findElementByXPath("//div[@class='edd-pincode-modal-form-container']//input[@class='edd-pincode-modal-text']").sendKeys("605701"+Keys.ENTER);
		
		//other information
		String information= driver.findElementByXPath("//ul[@class='prod-list']//div[@class='other-info-toggle']").getText();
		System.out.println("Other infrormation"+information);
		//Add toBag
		driver.findElementByXPath("//div[@class='pdp-addtocart-button']").click();
		//WebElement submitBUtton = driver.findElementByXPath("//div[@class='btn-cart ']");
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//for click
		//jse.executeScript("arguments[0].click();", submitBUtton);
		//driver.findElementByXPath("//div[@class='btn-cart ']").click();
		
		//coupon code apply
		driver.findElementById("couponCodeInput").sendKeys("EPIC");
		driver.findElementByXPath("//input[@id='EPIC']/..").click();
		driver.findElementByXPath("//button[@class='rilrtl-button button apply-button ']").click();
		String print= driver.findElementByXPath("//span[@class='applied-coupon-section']//p[@class='applied-voucher-message']/.").getText();
		System.out.println(print);
	}
		
	}



