package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.ChooseProjectType;
import pageObject.ChooseProjectTypeForm;
import pageObject.GeneralSettingPage;
import pageObject.LoginPage;
import pageObject.MyWorkspacePage;
import pageObject.PersonalityEditPage;
import pageObject.PreviewPage;
import pageObject.TemplatesPage;

public class EditingPersonalityTest extends BaseTest {


	@Test
	public void tc01_emptyProjectNameTest() {
		MyWorkspacePage mw = new MyWorkspacePage(driver);
		mw.createProject();
		ChooseProjectType cpt = new ChooseProjectType(driver);
		cpt.chooseProjectType("Personality Test");
		TemplatesPage tp = new TemplatesPage(driver);
		tp.chooseTemplateType("What Personality Type Are You?");
		PreviewPage pp = new PreviewPage(driver);
		pp.useTemplate();
		ChooseProjectTypeForm cptf = new ChooseProjectTypeForm(driver);
		cptf.startEditingSeccond("");
		String expected = "This field is required.";
		String actual = cptf.getRequiredMsg();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void tc02_addSlide() {
		ChooseProjectTypeForm cptf = new ChooseProjectTypeForm(driver);
		cptf.startEditingSeccond("Personality Project");
		PersonalityEditPage ptp = new PersonalityEditPage(driver);
		long before = ptp.getNumberOfSlides();
		ptp.addNewPage();
		long after = ptp.getNumberOfSlides();
		assertEquals(after, before + 1);
	}

	@Test
	public void tc03_DeleteSlide() {
		PersonalityEditPage ptp = new PersonalityEditPage(driver);
		long before = ptp.getNumberOfSlides();
		ptp.deleteSlide(5);
		long after = ptp.getNumberOfSlides();
		assertEquals(after, before - 1);
	}

	@Test
	public void tc04_editingAnswers() {
		PersonalityEditPage ptp = new PersonalityEditPage(driver);
		ptp.editAnswers("Test 1", "Test 2", "Test 3", "Test 4");
		Assert.assertEquals(ptp.getTitle(0), "Test 1");
	}

	@Test
	public void tc05_editProjectName() {
		PersonalityEditPage ptp = new PersonalityEditPage(driver);
		ptp.editProjectNameBtn();
		GeneralSettingPage sgp = new GeneralSettingPage(driver);
		sgp.editProjectName("NEW NAME");
		Assert.assertEquals(ptp.getProjectName(), "NEW NAME");
	}

}
