package com.cybertek.ZohoProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class zohoTest {

	WebDriver driver;
	WebDriverWait wait;
	List<WebElement> rowsAll;
	List <WebElement> columns;
	Properties prop;
	String path="C:\\Users\\kbaialiev\\Desktop\\testing-maven\\ZohoProject\\src\\test\\java\\com\\cybertek\\ZohoProject\\log4j.properties";
	Logger logger=LogManager.getLogger(zohoTest.class.getName());
	
	@BeforeTest
	public void beforeTest() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		FileInputStream ip=new FileInputStream(path);
		prop=new Properties();
		prop.load(ip);
		driver.get(prop.getProperty("url"));


	}
	@Test(priority=1)
	public void getData() throws Exception {
		logger.debug("Starting the test");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		wait=new WebDriverWait(driver, 50);
		Select sl=new Select(driver.findElement(By.id("recPerPage")));
		sl.selectByVisibleText("100");

		//Excel File 

		File src=new File("C:\\Users\\kbaialiev\\Desktop\\testing-maven\\ZohoProject\\TestData\\data.xlsx");
		FileInputStream fls=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fls);
		XSSFSheet sheet1= wb.getSheetAt(0);
		
		//column get and write
		columns=driver.findElements(By.cssSelector("#reportTab th"));
		for(int i=0; i<columns.size(); i++) {
			sheet1.createRow(i);
			sheet1.getRow(0).createCell(i).setCellValue(columns.get(i).getText());

		}
		
		//row get and write
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"123524000000428103_tr\"]/td[1]")));
		rowsAll=driver.findElements(By.cssSelector("#reportTab > tbody td"));
		int k=0;
		int p=1;
		for(int j=0; j<rowsAll.size(); j++) {
			sheet1.getRow(p).createCell(k).setCellValue(rowsAll.get(j).getText());
			logger.debug("Writing "+p+" Row "+k+" Collumn"+ rowsAll.get(j).getText());
			k++;
			if(k==5) {
				k=0;
				p++;
				sheet1.createRow(p+1);
			}

		} 

		//Output of the file; 

		FileOutputStream fos=new FileOutputStream("C:\\Users\\kbaialiev\\Desktop\\testing-maven\\ZohoProject\\TestData\\data.xlsx");
		wb.write(fos);
		fos.close();

	}



	@AfterTest
	public void close() {
		driver.close();
		driver.quit();
	}
}
