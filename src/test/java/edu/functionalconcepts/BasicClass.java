package edu.functionalconcepts;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class BasicClass {
	private static Object object;
	private static Object object2;

	public static void main(String args[])

{
	//Browser Launch 
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	RemoteWebDriver driver = new ChromeDriver();
	driver.get("http://automationpractice.com/index.php");
	
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	//click the sign in button
	driver.findElementByClassName("login").click();
	
	//To enter the Data in Edit box
	//driver.findElement(ById("email_create")).sendKeys("chanduru1260@gmail.com");
	driver.findElementById("email_create").sendKeys("chanduru1260@gmail.com");
	driver.findElementById("SubmitCreate").click();
	
	//Enter the data edit text box : first name
		driver.findElementById("customer_firstname").sendKeys("chanduru");
		
		//Enter the data edit box : last name
		driver.findElementById("customer_lastname").sendKeys("V");
		
		//enter the data edit box : Email
		
		
		//driver.findElementById("email").sendKeys("chanduru1260@gmail.com");
		
		
		//Enter the data edit box : password
		driver.findElementById("passwd").sendKeys("12345");
		
		//Selecting a value from a drop_down field.
				//days
				WebElement days = driver.findElementById("days");
				Select dateObj = new Select(days);
				dateObj.selectByValue("1");
				//month
				WebElement month=driver.findElementById("months");
				Select monthobj=new Select(month);
				monthobj.selectByValue("1");
				//year
				WebElement year=driver.findElementById("years");
				Select yearobj=new Select(year);
				yearobj.selectByValue("2000");
				
				// Enter the data edit box : company
				driver.findElementById("company").sendKeys("TCS");
				
				//address
				driver.findElementById("address1").sendKeys("washington");
				
				//address (line 1)
				driver.findElementById("address2").sendKeys("washington");
				
				//city
				driver.findElementById("city").sendKeys("olimpia");
				
				//state
				WebElement state= driver.findElementById("id_state");
				Select mystate=new Select(state);
				mystate.selectByVisibleText("California");
				
				//zip/postal code
				driver.findElementById("postcode").sendKeys("605 701");
				
				//country
				WebElement country= driver.findElementById("id_country");
				Select mycountry=new Select(country);
				mycountry.selectByVisibleText("United States");
				
				//additional information
				driver.findElementById("other").sendKeys("8765432112");
				
				//phone
				driver.findElementById("phone").sendKeys("140 22323");
				
				//mobile
				driver.findElementById("phone_mobile").sendKeys("9876543210");
				
				//assing address Alias
				driver.findElementById("alias").sendKeys("My address");
				
				//register
				driver.findElementById("submitAccount");
								 
				//String details = driver.findElementById("contact-link").getText();
				//System.out.println(details);
				
				driver.findElementById("email");
				WebElement emali= driver.findElementById("email");
				boolean emailvisible= driver.findElementById("email").isDisplayed();
				if(emailvisible==true)
				{
					System.out.println("succesfull");
			
				}
				else
				{
					System.out.println("failed");

				}
}}			


