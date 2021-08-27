package pageObject;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class PreviewPersonalityPage extends BasePage{

	@FindBy(css = ".c-button.btn")
	private WebElement startBtn;
	@FindBy(css = ".e-html-container span")
	WebElement questionProgress;
	@FindBy(css = ".c-question-container button")
	List<WebElement> answerList;
	@FindBy(css = ".e-headline span")
	WebElement endTestTxt;
	
	public PreviewPersonalityPage(WebDriver driver) {
		super(driver);
	}
		
	public void clickStartBtn() {
		click(startBtn);
	}
		public String getWindowMainTab() {
			String mainWindow = driver.getWindowHandle();
			return mainWindow;
		}
		
		public void switchtoLastTab() {
			Set<String> windows = driver.getWindowHandles();
			for (String win : windows) {
				driver.switchTo().window(win);
			}
		}
		public void chooseAnswer(String name, String headerName) {
			ExpectedCondition<Boolean> elementTextContainsString = arg0 -> questionProgress.getText().contains(headerName);
			wait.until(elementTextContainsString);
			List<WebElement> ansLst = answerList;
			for (int i = 0; i < ansLst.size(); i++) {
				if (getText(ansLst.get(i)).equalsIgnoreCase(name)) {
					click(ansLst.get(i));
					break;
				}
			}
		}
		public String getFinalTxt() {
			ExpectedCondition<Boolean> elementTextContainsString = arg0 -> endTestTxt.getText().contains("You're a Leader");
			wait.until(elementTextContainsString);
			String txt = endTestTxt.getText();
			return txt;
		}

	


	

}
