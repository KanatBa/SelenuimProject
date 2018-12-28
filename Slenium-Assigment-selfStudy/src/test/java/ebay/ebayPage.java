package ebay;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ebayPage {
	
	public ebayPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="gh-ac")
	public WebElement searchBox;
	
	@FindBy(css="#gh-cat")
	public WebElement categories;
	
	@FindBy(id="gh-btn")
	public WebElement searchBtn;
	
	@FindBy(css="#srp-river-results > ul li h3")
	public List<WebElement> searchList;

}
