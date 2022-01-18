package edu.functionalconcepts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Screen {
	public RemoteWebDriver driver;
	@Test
	public void add() throws IOException
	{
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	RemoteWebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//link
	driver.get("http://automationpractice.com/index.php");
	//screenshort
	File source = driver.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("./snaps/screenshot1.jpeg"));
	System.out.println("screenshot 1 taken");
	driver.quit();
}
}