package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreviewPage extends BasePage{
	@FindBy(css = "div.e-use-template")
	private WebElement useTemplateBtn;
	@FindBy(css = ".fa.fa-angle-right.text-white")
	private WebElement nextBtn;
	@FindBy(css = ".fa.fa-angle-left.text-white")
	private WebElement backBtn;
	@FindBy(css = "#firstName_auvpeiu")
	private WebElement firstNameField;
	@FindBy(css = "#lastName_1a0tg3a")
	private WebElement lastNameField;
	@FindBy(css = "#email_dg94h3c")
	private WebElement emailField;
	@FindBy(css = "#pkp9lnw > span.el-checkbox__input > span")
	private WebElement subscribeCheckbox;
	@FindBy(css = "#mbl2vat > span.el-checkbox__input")
	private WebElement agreeChekbox;
	@FindBy(css = ".c-button.btn")
	private WebElement signUpBtn;
	@FindBy(css="[title='mobile']")
	private WebElement mobilePresntation;
	
	public PreviewPage(WebDriver driver) {
		super(driver);
		
	}
	public void useTemplate() {
		click(useTemplateBtn);
	}
	public void next() {
		click(nextBtn);
	}
	public void back() {
		click(backBtn);
	}
	public void mobilePresntation() {
		click(mobilePresntation);
	}
	public void signUpBtn() {
		click(signUpBtn);
	}
	
	public void checkSignInForm(String firstName ,String lastName , String email) {
		fillText(firstNameField, firstName);
		fillText(lastNameField, lastName);
		fillText(emailField, email);
		click(subscribeCheckbox);
		click(agreeChekbox);
		click(signUpBtn);
	}

	
	

}
