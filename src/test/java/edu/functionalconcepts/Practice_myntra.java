package edu.functionalconcepts;

import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ButtonReleaseAction;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class Practice_myntra {
	@Test
public void myntra()
{
	//Browser launch
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	RemoteWebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.myntra.com");
	driver.findElementByClassName("desktop-searchBar").sendKeys("sunglasess Men"+Keys.ENTER);
	
	//filter the glasess with brand "poloroid"
	driver.findElementByXPath("//div[@class='filter-search-filterSearchBox']").click();
	driver.findElementByClassName("filter-search-inputBox").sendKeys("Polaroid"+Keys.ENTER);
	driver.findElementByClassName("img-responsive").click();

}
}
