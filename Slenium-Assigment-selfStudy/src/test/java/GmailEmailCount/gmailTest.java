package GmailEmailCount;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class gmailTest {

	WebDriver driver;

	@BeforeTest
	public void setup() throws IOException {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		FileInputStream inputStream = new FileInputStream("C:\\Users\\kbaialiev\\Desktop\\testing-maven\\Slenium-Assigment-selfStudy\\src\\test\\java\\url.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		driver.get(properties.getProperty("URLgmail"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	@Test
	public void login() {
		gmailPage loginPage=new gmailPage(driver);
		loginPage.email.sendKeys("kbaialiev@gmail.com");
		loginPage.next.click();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/form/content/section/div/content/div[1]/div/div[1]/div/div[1]/input")));
		loginPage.password.sendKeys("Kaku6na1985");
		loginPage.nextPassword.click();
		
	}

}
