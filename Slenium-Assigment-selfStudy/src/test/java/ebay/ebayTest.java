package ebay;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ebayTest {
	
	 
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
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	@Test 
	public void search() {
		ebayPage mainPage=new ebayPage(driver);
		mainPage.searchBox.sendKeys("Apple Watch");
		mainPage.categories.click();
		Select category=new Select(mainPage.categories);
		category.selectByValue("15032");
		mainPage.searchBtn.click();
		
		List<WebElement> listSearch=mainPage.searchList;
		for(WebElement l:listSearch) {
			System.out.println(l.getText());
			
		}
		driver.close();
		driver.quit();
		
	}

}
