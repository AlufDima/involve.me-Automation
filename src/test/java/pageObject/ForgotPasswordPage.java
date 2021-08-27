package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage{
	@FindBy(css = ".form-control")
	private WebElement emailAddressField;
	@FindBy(css = ".btn-primary")
	private WebElement sendPasswordResetLinkBtn;
	@FindBy(css = ".alert-success")
	private WebElement SuccessrMsg;
	@FindBy(css = ".alert-danger")
	private WebElement invalidMsg;

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void sendPasswordRestLink(String email) {
		fillText(emailAddressField, email);
		click(sendPasswordResetLinkBtn);
		sleep(2000);
	}
	
	public String getSuccessrMsg() {
		return getText(SuccessrMsg);
	}
	public String getInvalidMsg() {
		return getText(invalidMsg);
	}
	

}
