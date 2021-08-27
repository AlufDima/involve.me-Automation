package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeneralSettingPage extends BasePage{
	@FindBy(css = "#project-name")
	private WebElement projectNameField;
	@FindBy(css = "#general-settings button > span")
	private WebElement updateSettingBtn;
	@FindBy(css = ".mb-4.hidden")
	private WebElement editProjectgBtn;
	
	public GeneralSettingPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void editProjectName(String newName) {
		fillText(projectNameField, newName);
		click(updateSettingBtn);
		sleep(3000);
		click(editProjectgBtn);
	}

}
