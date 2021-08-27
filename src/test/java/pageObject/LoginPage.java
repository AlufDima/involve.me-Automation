package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	@FindBy(css = ".other-link.login")
	private WebElement loginBtn;
	@FindBy(css = "[name='email']")
	private WebElement emailField;
	@FindBy(css = "[name='password']")
	private WebElement passwordField;
	@FindBy(css = "[type='submit']")
	private WebElement login;
	@FindBy(css = "[type='submit']")
	private WebElement loginAsUser;
	@FindBy(css = "div > .darken")
	private WebElement forgotPassword;
	@FindBy(css = ".nav.navbar-nav > li:nth-child(2) > a")
	private WebElement Register;
	@FindBy(css = ".btn.btn-secondary")
	private WebElement howItWorks;
	@FindBy(css = ".alert.alert-danger")
	private WebElement errorMsg;
	@FindBy(css = ".e-form-heading")
	private WebElement loginPageTitle;


	public LoginPage(WebDriver driver) {
		super(driver);

	}
	public void loginBtn1() {
		click(loginBtn);
	}


	public void login(String user, String password) {
//		click(loginBtn);
		fillText(emailField, user);
		fillText(passwordField, password);
		click(loginAsUser);
	}
	

	public void forgotPassword() {
		click(forgotPassword);
	}

	public void createAccount() {
		click(Register);
	}

	public void seeHowItWorks() {
		click(howItWorks);
	}
	//Validation
	public String getErrorMsg() {
		return getText(errorMsg);
	}
	public String getTitle() {
		return getText(loginPageTitle);
	}

}
