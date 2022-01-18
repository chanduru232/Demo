package edu.functionalconcepts;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class WindowHandlingNaukri {
	private Object driver;

	@Test
	public void naukri() throws IOException, InterruptedException
	{
		ExtentReports extreports=new ExtentReports();
		ExtentSparkReporter sparkReport=new ExtentSparkReporter("./demoTestResult/demohtmlreport.html");
		extreports.attachReporter(sparkReport);
		ExtentTest test = extreports.createTest("Button check");
		ExtentTest node = test.createNode("EndtoEndFlow");
		
		
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");
		
		Thread.sleep(3000);
		//Screen short
		File source= driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,new File("./snapshot/buttonCheck.jpeg"));
		node.log(Status.PASS, "Naukri executed successfully");
		node.addScreenCaptureFromPath(".././snapshot/redbus.jpeg");
		
		
		String firstWinTitleName = driver.getTitle();
		System.out.println("Window Title" + firstWinTitleName);

		String header = driver.findElementByXPath(("//div[@class='qsb-header-text']/..")).getText();
		System.out.println(header);
		
		String firsWindowName = driver.getWindowHandle();
		System.out.println("first windowHandle ID" + firsWindowName);		
		Set<String> windowHandleIds = driver.getWindowHandles();
		for (String individualWinHandle:windowHandleIds) 
		{
			System.out.println(individualWinHandle);			
			driver.switchTo().window(individualWinHandle);			
			String pageTitle = driver.getTitle();
			System.out.println("Window Title" + pageTitle);
			
			if(pageTitle.equalsIgnoreCase("Sopra"))
			{
				driver.findElementByXPath("//img[@alt='Sopra']/..").click();
			}
		}
		
		
	System.out.println("Data to be Printed after clicking the button in new window");
	
	
	extreports.flush();
	}
	}
	

