package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TemplatesPage extends BasePage {
	@FindBy(css = "div.c-thumbnail-image-wrapper > a > img")
	private List<WebElement> imgItems;

	public TemplatesPage(WebDriver driver) {
		super(driver);

	}

	public void chooseTemplateType(String projectTypeName) {
		List<WebElement> list = imgItems;
		for (WebElement image : list) {
			if (image.getAttribute("alt").equalsIgnoreCase(projectTypeName)) {
				image.click();
				break;
			}
		}
	}

}
