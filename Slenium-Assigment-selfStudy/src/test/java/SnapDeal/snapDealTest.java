package SnapDeal;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class snapDealTest {
	
	WebDriver driver;
	Properties properties;
	
	@BeforeTest
	public void setUP() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		FileInputStream ip=new FileInputStream("C:\\Users\\kbaialiev\\Desktop\\testing-maven\\Slenium-Assigment-selfStudy\\src\\test\\java\\url.properties");
		properties=new Properties();
		properties.load(ip);
		driver.get(properties.getProperty("URLsnapdeal"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		}
	@Test
	public void MoveToSignIn() {
		spanDealPage signIn=new spanDealPage(driver);
		Actions builder=new Actions(driver);
		builder.moveToElement(signIn.SignIn).build().perform();
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".accountBtn.btn.rippleWhite > a")));
		builder.moveToElement(signIn.Login).build().perform();
		signIn.Login.click();
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		driver.switchTo().frame(0);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#login-register-modal > div")));
		signIn.singUp.sendKeys("kbaialiev@gmail.com");
		signIn.continueBtn.click();
			
		
	}
	@AfterTest
	public void Close() {
		driver.close();
		driver.quit();
	}
	
	

}
