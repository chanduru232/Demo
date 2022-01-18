package edu.functionalconcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Open_MRS {
	public WebDriver driver;
	@Test
	public void login()
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
	
	//Register a Patient
	Actions act=new Actions(driver);
	
	driver.findElementByXPath("//i[@class='icon-user']/..").click();
	WebElement name= driver.findElementByXPath("//p[@class='left']//input[@type='text']");
	act.moveToElement(name).click().build().perform();
	name.sendKeys("V"+Keys.ENTER);
	
	WebElement middle= driver.findElementByXPath("//input[@name='middleName']");
	act.moveToElement(middle).click().build().perform();
	middle.sendKeys("chandan",Keys.ENTER);
	
	WebElement family= driver.findElementByXPath("//input[@name='familyName']");
	act.moveToElement(family).click().build().perform();
	family.sendKeys("chandru",Keys.ENTER);

	//gender
	 WebElement gender= driver.findElementByXPath("//select[@id='gender-field']//option[@value='M']");
	 act.moveToElement(gender).click().build().perform();
	 driver.findElementById("next-button").click();
	 
	 //Date of birth
	 WebElement days = driver.findElementById("birthdateDay-field");
	 act.moveToElement(days).click().build().perform();
	 days.sendKeys("26",Keys.ENTER);
	
	 	//month
		WebElement month=driver.findElementById("birthdateMonth-field");
		Select monthobj=new Select(month);
		monthobj.selectByValue("3");
		//year
		WebElement year=driver.findElementById("birthdateYear-field");
		act.moveToElement(year).click().build().perform();
		year.sendKeys("2000",Keys.ENTER);
		
		//Address
		driver.findElementById("address1").sendKeys("main road",Keys.ENTER);
		driver.findElementById("address2").sendKeys("main road",Keys.ENTER);
		driver.findElementById("cityVillage").sendKeys("kandachipuram",Keys.ENTER);
		driver.findElementById("stateProvince").sendKeys("Tamilnadu",Keys.ENTER);
		driver.findElementById("country").sendKeys("india",Keys.ENTER);
		driver.findElementById("postalCode").sendKeys("606 701",Keys.ENTER);
		
		//phone number
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("6362661260",Keys.ENTER);
		
		//Relatives
		driver.findElementById("relationship_type").click();
		WebElement relation=driver.findElementById("relationship_type");
		Select relations=new Select(relation);
		relations.selectByValue("8d919b58-c2cc-11de-8d13-0010c6dffd0f-A");
		
		driver.findElementByXPath("//input[@placeholder='Person Name']").sendKeys("arun");
		driver.findElementByXPath("//button[@id='next-button']").click();
		
		//summit
		driver.findElementById("submit").click();

		
		
	
	}

}
