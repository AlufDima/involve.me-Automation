package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegestretionPage extends BasePage{
	@FindBy(css=".other-link.register")
	private WebElement loginRegisterBtn;
	@FindBy(css="#user-name")
	private WebElement userName;
	@FindBy(css="#organization-name")
	private WebElement organizationName;
	@FindBy(css="[name='email']")
	private WebElement email;
	@FindBy(css="#register-password")
	private WebElement password;
	@FindBy(css="#recaptcha-anchor")
	private WebElement imNotARobot;
	@FindBy(css="#terms")
	private WebElement agreeToTheTerms;
	@FindBy(css=".btn.btn-primary.btn-lg")
	private WebElement register;
	
	
	

	public RegestretionPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void register(String name , String password ,String organizationName , String email) {
		click(this.loginRegisterBtn);
		fillText(this.userName, name);
		fillText(this.organizationName, organizationName);
		fillText(this.email, email);
		fillText(this.password, password);
		click(imNotARobot);
		click(agreeToTheTerms);
//		click(register);
	}
	
	

}
