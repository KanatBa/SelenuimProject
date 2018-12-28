package qatechhub;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class qatechhubTest {
	RemoteWebDriver driver;
	public static final String USERNAME = "kanatB";
    public static final String ACCESS_KEY = "4c9afde8-ba08-489a-ba10-ad6a8ea951f6";
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "59.0");
		driver =new RemoteWebDriver(new URL(URL),caps);
		driver.get("http://qatechhub.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@Test
	public void checkTitle() {
		String title=driver.getTitle();
		Assert.assertEquals(title,"QA Automation Tools Trainings and Tutorials | QA Tech Hub");
		driver.navigate().to("https://www.facebook.com");
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		driver.navigate().forward();
		driver.navigate().refresh();
			
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
}
