package facebook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class facebookPage {
	public facebookPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(name="firstname")
	public WebElement name;
	
	@FindBy(name="lastname")
	public WebElement lastname;
	
	@FindBy(name="reg_email__")
	public WebElement email;
	
	@FindBy(name="reg_passwd__")
	public WebElement password;
	
	@FindBy(id="month")
	public WebElement month;
	
	@FindBy(id="day")
	public WebElement day;
	
	@FindBy(id="year")
	public WebElement year;
	
	@FindBy(css="input[value=\"2\"]")
	public WebElement male;
	
	
	
}
