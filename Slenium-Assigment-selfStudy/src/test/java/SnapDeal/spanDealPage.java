package SnapDeal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class spanDealPage {
	
	
	public spanDealPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="span.accountUserName.col-xs-12.reset-padding")
	public WebElement SignIn;
	
	@FindBy(css=".accountBtn.btn.rippleWhite > a")
	public WebElement Login;
	
	@FindBy(xpath="//*[@id=\"userName\"]")
	public WebElement singUp;
	
	@FindBy(xpath="//*[@id=\"checkUser\"]")
	public WebElement continueBtn;

}
