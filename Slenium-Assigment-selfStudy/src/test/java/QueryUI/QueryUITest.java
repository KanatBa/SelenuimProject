package QueryUI;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QueryUITest {
	Properties properties;
	WebDriver driver;
	@BeforeTest
	public void setUp() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		FileInputStream caps=new FileInputStream("C:\\Users\\kbaialiev\\Desktop\\testing-maven\\Slenium-Assigment-selfStudy\\src\\test\\java\\url.properties");
		properties=new Properties();
		properties.load(caps);
		
		driver.get(properties.getProperty("URLqueryui"));
		driver.manage().window().maximize();
		
			
		
	}
	
	@Test
	public void drag() {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Actions actions=new Actions(driver);
		driver.switchTo().frame(0);
		WebElement drag=driver.findElement(By.xpath("//*[@id=\"draggable\"]/p"));
		WebElement drop=driver.findElement(By.xpath("//*[@id=\"droppable\"]/p"));
		actions.dragAndDrop(drag,drop).build().perform();
		Assert.assertEquals(drop.getText(), "Dropped!");
		
	}
	@AfterTest
	public void close() {
		driver.close();
		driver.quit();
	}

}
