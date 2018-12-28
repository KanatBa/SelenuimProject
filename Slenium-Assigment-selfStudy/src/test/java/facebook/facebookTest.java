package facebook;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class facebookTest {

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
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@Test
	public void register() {
		facebookPage facebook=new facebookPage(driver);
		facebook.name.sendKeys("Kanat");
		facebook.lastname.sendKeys("Baialiev");
		facebook.email.sendKeys("kbailaiev@gmail.com");
		facebook.password.sendKeys("kanat1985");
		Select month=new Select(facebook.month);
		month.selectByValue("1");
		Select day=new Select(facebook.day);
		day.selectByValue("2");
		Select year=new Select(facebook.year);
		year.selectByValue("2001");
		
		facebook.male.click();
		driver.close();
		driver.quit();
		
		
	}

}
