package pageObject;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalityEditPage extends BasePage {
	@FindBy(css = "div:nth-of-type(4) .fa-plus.fal")
	private WebElement addPage;
	@FindBy(css = "[title='Question with several text answers.']")
	private WebElement multipleChoice;
	@FindBy(css = "div.content-item-wrapper")
	private WebElement dropZone;
	@FindBy(css = ".e-pages-container .e-page-management")
	private List<WebElement> slidesList;
	@FindBy(css = "#input_9t5ovdj")
	private WebElement questionField;
	@FindBy(css = ".settings-group > div > div:nth-of-type(1) .e-answer-text-container > input")
	private WebElement firstAnswerField;
	@FindBy(css = ".settings-group > div > div:nth-of-type(2) .e-answer-text-container > input")
	private WebElement seconfAnswerField;
	@FindBy(css = ".settings-group > div > div:nth-of-type(3) .e-answer-text-container > input")
	private WebElement thirdAnswerField;
	@FindBy(css = ".settings-group > div > div:nth-of-type(4) .e-answer-text-container > input")
	private WebElement fourthdAnswerField;
	@FindBy(css = ".content-item-edit-close .save-close.btn")
	private WebElement saveAndCloseBtn;
	@FindBy(css = "div:nth-of-type(4) > .e-page-management")
	private WebElement page4;
	@FindBy(css = "div.c-question-container") // .content-item .c-question
	private WebElement helo;
	@FindBy(css = "div.content-menu-item")
	private List<WebElement> contentList;
	@FindBy(css = ".tab-content .svg-wrapper")
	private List<WebElement> contentElemenyBoxList;
	@FindBy(css = "button[title='Delete page']")
	private List<WebElement> deleteSlideBtns;
	@FindBy(css = ".swal-button--confirm")
	private WebElement confirmDeleteSlideBtn;
	@FindBy(css = ".project-name-edit")
	private WebElement editProjectNameBtn;
	@FindBy(css = ".project-name")
	private WebElement projectNameLabel;
	@FindBy(css = ".e-page-item p")
	private List<WebElement> slides;

	public PersonalityEditPage(WebDriver driver) {
		super(driver);

	}

	public void addNewPage() {
		click(addPage);
	}

	public void addElementToProject(String element) {
		Actions actions = new Actions(driver);
		List<WebElement> contElmtlstName = contentList;
		for (int i = 0; i < contElmtlstName.size(); i++) {
			if (getText(contElmtlstName.get(i)).equalsIgnoreCase(element)) {
				sleep(1000);
				actions.dragAndDrop(contentElemenyBoxList.get(i),
						driver.findElement(By.cssSelector(".empty-canvas-info.center-center"))).build().perform();
				sleep(1000);
				actions.moveByOffset(725, 268).contextClick().perform();
				sleep(1000);
				actions.click();
				sleep(1000);
				windowRefresh();
				break;
			}
		}
		click(saveAndCloseBtn);
	}

	private void windowRefresh() {
		// TODO Auto-generated method stub

	}

	public int getNumberOfSlides() {
		sleep(1000);
		List<WebElement> pageNumber = slidesList;
		return pageNumber.size();

	}

	public void editAnswers(String firstAnswer, String secondfAnswer, String thirdAnswer, String fourthdAnswer) {
		click(helo);
		fillText(firstAnswerField, firstAnswer);
		fillText(seconfAnswerField, secondfAnswer);
		fillText(thirdAnswerField, thirdAnswer);
		fillText(fourthdAnswerField, fourthdAnswer);
		click(saveAndCloseBtn);
	}

	public void moveToPageFour() {
		List<WebElement> slides = slidesList;
		slides.get(slides.size() - 2).click();

	}


	public void deleteSlide(int slideNumber) {
		// will delete slide according to its given number
		click(deleteSlideBtns.get(slideNumber - 1));
		click(confirmDeleteSlideBtn);
	}


	public void editProjectNameBtn() {
		Actions action = new Actions(driver);
		action.click(editProjectNameBtn).perform();
		
		

	}

	public String getProjectName() {
		wait.until(ExpectedConditions.visibilityOf(projectNameLabel));
		return getText(projectNameLabel);
	}

	public String getTitle(int position) {
		List<WebElement> list = driver.findElements(By.cssSelector("button.c-answer"));
		return getText(list.get(position));
	}

//	public boolean isAnswer() {
//		if (getText(titleLabel).equalsIgnoreCase("My Workspace")) {
//			return true;
//		}
//		return false;
//	}
}
