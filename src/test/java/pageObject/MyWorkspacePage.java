package pageObject;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyWorkspacePage extends BasePage {
	@FindBy(css = ".text-gray-900")
	private WebElement titleLabel;
	@FindBy(css = ".block.max-w-xl")
	private WebElement welecomeNotice;
	@FindBy(css = "#app .px-4 a")
	private WebElement startBtn;
	@FindBy(css = ".hidden.px-3")
	private WebElement createProjectBtn;
	@FindBy(css = ".mr-3+span")
	private WebElement numOfProject;
	@FindBy(css = ".font-medium button")
	private WebElement addWorckSpaces;
	@FindBy(css = "[placeholder='Workspace name']")
	private WebElement workspaceNameField;
	@FindBy(css = "#confirm-create-button")
	private WebElement confirmBtn;
	@FindBy(css = ".mt-6 .mr-3.truncate")
	List<WebElement> workspaceBlock;
	@FindBy(css = ".mb-2 .dropdown.relative")
	private WebElement dropdownRelativeBtn;
	@FindBy(css = ".dropdown-menu li:nth-of-type(10)>button")
	private List<WebElement> prjDropDwnDeleteButton;
	@FindBy(css = "#app .max-w-full div .mt-4 > .mt-8 > div")
	private List<WebElement> projecName;
	@FindBy(css = "#confirm-delete-button")
	private WebElement confirmDeleteBtn;
	@FindBy(css = ".dropdown-menu li:nth-of-type(8) button")
	List<WebElement> moveToWorkspaceBtn;
	@FindBy(css = ".h-12.w-full")
	private WebElement selectWorkspacePopup;
	@FindBy(css = "#confirm-create-button")
	private WebElement moveProjectBtn;
	@FindBy(css = ".relative.flex .dropdown-menu.w-auto >li:nth-child(2)")
	List<WebElement> previewProjectBtn;
	@FindBy(css = "mr-3.truncate")
	private WebElement myWorkSpace;
	@FindBy(css = ".leading-tight.text-lg>a")
	List<WebElement> projectNameList;
	@FindBy(css = ".relative.flex .dropdown.relative>button")
	List<WebElement> prjDropDwn;

	public MyWorkspacePage(WebDriver driver) {
		super(driver);
	}

	public void startBtn() {
		click(startBtn);
	}

	public boolean isWelecomeNotice() {
		if (getText(welecomeNotice).equalsIgnoreCase("Welcome Dima!")) {
			return true;
		}
		return false;
	}

	public boolean isMyWorkspacePage() {
		if (getText(titleLabel).equalsIgnoreCase("My Workspace")) {
			return true;
		}
		return false;
	}

	public void createProject() {
		// if(isElementDisplayed(startBtn)) {
		// click(startBtn);
		// }else if(isElementDisplayed(createProjectBtn)) {
		// click(createProjectBtn);
		// }
		click(createProjectBtn);
	}


	public long getNumOfProjects() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mr-3+span")));
		String number = getText(numOfProject);
		long Num = Long.parseLong(number);
		sleep(3000);
		return Num;

	}

	public void addWorkspaces(String projectName) {
		click(addWorckSpaces);
		fillText(workspaceNameField, projectName);
		click(confirmBtn);
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public int getNumberOfWorkspaces() {
		int num = workspaceBlock.size();
		sleep(3000);
		return num;

	}

	public void clickDeleteProject(String prjcName) {
		List<WebElement> nl = projectNameList;
		List<WebElement> dd = prjDropDwn;
		List<WebElement> deleteButton = prjDropDwnDeleteButton;
		for (int i = 0; i < nl.size(); i++) {
			if (getText(nl.get(i)).equalsIgnoreCase(prjcName)) {
				click(dd.get(i));
				click(deleteButton.get(i));
				click(confirmDeleteBtn);
				sleep(9000);
				break;
			}
		}
	}

	public void moveProject(String projectName, String workspaceName) {
		List<WebElement> nl = projectNameList;
		List<WebElement> dd = prjDropDwn;
		List<WebElement> mtw = moveToWorkspaceBtn;
		for (int i = 0; i < projectNameList.size(); i++) {
			if (getText(nl.get(i)).equalsIgnoreCase(projectName)) {
				click(dd.get(i));
				click(mtw.get(i));
				Select selectWorkspace = new Select(selectWorkspacePopup);
				selectWorkspace.selectByVisibleText(workspaceName);
				click(moveProjectBtn);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

	public void previewProject(String projectName) {
		List<WebElement> nl = projectNameList;
		List<WebElement> dd = prjDropDwn;
		List<WebElement> ppb = previewProjectBtn;
		for (int i = 0; i < nl.size(); i++) {
			if (getText(nl.get(i)).equalsIgnoreCase(projectName)) {
				click(dd.get(i));
				click(ppb.get(i));
				break;
			}
		}
	}
}