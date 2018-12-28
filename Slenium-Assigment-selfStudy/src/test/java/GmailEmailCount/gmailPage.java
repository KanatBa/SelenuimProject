package GmailEmailCount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class gmailPage {
	public gmailPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="identifierId")
	public WebElement email;
	
	@FindBy(css="#identifierNext > content:nth-child(3) > span:nth-child(1)")
	public WebElement next;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/form/content/section/div/content/div[1]/div/div[1]/div/div[1]/input")
	public WebElement password;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/content/span")
	public WebElement nextPassword;
	
	
	
	

}
