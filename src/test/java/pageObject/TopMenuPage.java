package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuPage extends BasePage{
	@FindBy(css = ".flex >.relative >.absolute.bottom-0")
	private WebElement dropDownMenu;
	@FindBy(css = ".dropdown-menu > li:nth-child(12)")
	private WebElement logOutBtn;
	@FindBy(css=".text-sm.flex > a:nth-child(2)")
	private WebElement templatesBtn;
	@FindBy(css=".e-close.nav-link")
	private WebElement saveAndExit;

	public TopMenuPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void logOut() {
		click(dropDownMenu);
		click(logOutBtn);
	}
	public void Templates() {
		click(templatesBtn);
	}
	public void saveAndExit() {
		click(saveAndExit);
	
	}
	
	

}
