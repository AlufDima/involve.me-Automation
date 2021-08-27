package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChooseProjectType extends BasePage {
	@FindBy(css = ".e-title")
	private WebElement title;
	@FindBy(css = ".col-md-12.content-chooser .title")
	private List<WebElement> titleList;


	public ChooseProjectType(WebDriver driver) {
		super(driver);
	}

	public boolean isMyWorkspacePage() {
		if (getText(title).equalsIgnoreCase("Choose project type")) {
			return true;
		}
		return false;
	}

	public void chooseProjectType(String projectTypeName) {
		List<WebElement> list = titleList;
		for (WebElement el : list) {
			if (el.getText().equalsIgnoreCase(projectTypeName)) {
				el.click();
				break;
			}
		}
	}


}
