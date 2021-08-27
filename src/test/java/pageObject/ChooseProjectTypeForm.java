package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChooseProjectTypeForm extends BasePage {
	@FindBy(css = "#new-project-form >.form-group > #project-name")
	private WebElement projectNameField;
	@FindBy(css = "div:nth-child(1) > label > div > button")
	private WebElement startEditingBtn;
	@FindBy(css = "div:nth-child(2) > label > div > button")
	private WebElement startEditingBtn2;
	@FindBy(css = "#project-name-error")
	private WebElement requiredMsg;

	public ChooseProjectTypeForm(WebDriver driver) {
		super(driver);
	}

	//Thank You page
	public void startEditing(String projectName) {
		fillText(projectNameField, projectName);
		click(startEditingBtn);
	}

	// Answer based Outcomes
	public void startEditingSeccond(String projectName) {
		fillText(projectNameField, projectName);
		click(startEditingBtn2);
	}
	
	public String getRequiredMsg() {
		return getText(requiredMsg);
	}

}
