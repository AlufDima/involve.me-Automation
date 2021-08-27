package pageObject;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class PreviewIQTestPage extends BasePage {
	@FindBy(css = ".c-button.btn")
	private WebElement startBtn;
	@FindBy(css = ".c-answer-container.v-horizontal>div:nth-child(3)")
	WebElement thirdAns;
	@FindBy(css = ".e-html-container>span")
	private WebElement textQuestion;
	@FindBy(css = ".wrapper.align-center>button")
	List<WebElement> answerList;
	@FindBy(css = ".e-headline")
	private WebElement thankyouPage;
	@FindBy(css = ".wrapper.align-center.is-shrinkable>span:nth-child(2)")
	WebElement finalScore;
	@FindBy(css = ".wrapper.align-center.is-shrinkable>span:nth-child(1)")
	WebElement iqText;

	public PreviewIQTestPage(WebDriver driver) {
		super(driver);

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

	public void startIQTest() {
		click(startBtn);
	}

	public void chooseShapeAnswer(String headrname) {
		ExpectedCondition<Boolean> elementTextContainsString = arg0 -> textQuestion.getText().contains(headrname);
		wait.until(elementTextContainsString);
		click(thirdAns);
	}

	public void chooseAnswer(String name, String headerName) {
		ExpectedCondition<Boolean> elementTextContainsString = arg0 -> textQuestion.getText().contains(headerName);
		wait.until(elementTextContainsString);
		List<WebElement> ansLst = answerList;
		for (int i = 0; i < ansLst.size(); i++) {
			if (getText(ansLst.get(i)).equalsIgnoreCase(name)) {
				click(ansLst.get(i));
				break;
			}
		}
	}
	public String getFinalScore() {
		ExpectedCondition<Boolean> elementTextContainsString = arg0 -> iqText.getText().contains("IQ");
		wait.until(elementTextContainsString);
		String score = getText(finalScore);
		return score;
	}
}
