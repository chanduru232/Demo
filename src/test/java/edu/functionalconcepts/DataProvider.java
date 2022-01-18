package edu.functionalconcepts;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DataProvider {
	WebDriver driver;
	@org.testng.annotations.DataProvider(name="sampledata")
	public Object[][] getTestdata() {
				
		String[][] employee= new String[3][3];
		
		employee[0][0] = "kevin";
		employee[0][1] = "123546";
		employee[0][2] = "kjkjhjhkjhk";
		
		employee[1][0] = "chandru";
		employee[1][1] = "12354634";
		employee[1][2] = "kjkjhjhksdffjhk";
		
		employee[2][0] = "Indu";
		employee[2][1] = "123533346";
		employee[2][2] = "kjkjhjhasdfkjhk";
				
		return employee;
		
	}

	@Test (dataProvider="sampledata")
	public void alertsDemo(String name, String mobile, String message) throws InterruptedException {
		driver.findElementByXPath("(//i[contains(@class,'fa fa-phone')])[1]/..").click();
		
		driver.findElementById("Name").sendKeys(name);
		driver.findElementById("Email").sendKeys(mobile);
		driver.findElementById("mes").sendKeys(message);
				
		Thread.sleep(3000);
		WebElement submitBUtton = driver.findElementByXPath("//button[text()='submit']");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// for click
	//	jse.executeScript("arguments[0].click();", submitBUtton);

		// for page scrolldown
		//jse.executeScript("arguments[0]. scrollIntoView(true);", submitBUtton);
		/*
		 * System.out.println(driver.switchTo().alert().getText()); Thread.sleep(1500);
		 * driver.switchTo().alert().accept();
		 */
	}
	
	
	//@Test (dependsOnMethods="alertsDemo",enabled=false)
	public void actionClassDemo() throws InterruptedException, IOException {
		// Action Class
		Actions actionObj = new Actions(driver);

		WebElement courses = driver.findElementById("cour");
		actionObj.moveToElement(courses).perform();
		

		Thread.sleep(10000);

		WebElement SpecificCourse = driver.findElementByXPath("//ul[@id='dview']/li[3]/a");
		actionObj.moveToElement(SpecificCourse).click().build().perform();
		Thread.sleep(10000);
		System.out.println(driver.findElementByXPath("//div[@id='course-description']/h2").getText());

	}

	
}
