package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.ChooseProjectType;
import pageObject.ChooseProjectTypeForm;
import pageObject.LoginPage;
import pageObject.MyWorkspacePage;
import pageObject.PreviewPage;
import pageObject.TemplatesPage;
import pageObject.TopMenuPage;

public class MyWorkspaceTests extends BaseTest {


	@Test
	public void tc01_isItMyWorkspacePage() {
		MyWorkspacePage mw = new MyWorkspacePage(driver);
		Assert.assertTrue(mw.isMyWorkspacePage());
	}

	@Test
	public void tc02_creatNewProject() {
		MyWorkspacePage mw = new MyWorkspacePage(driver);
		long before = mw.getNumOfProjects();
		mw.createProject();
		ChooseProjectType cpt = new ChooseProjectType(driver);
		cpt.chooseProjectType("Form");
		TemplatesPage tp = new TemplatesPage(driver);
		tp.chooseTemplateType("Tag Along Sign Up Form");
		PreviewPage pp = new PreviewPage(driver);
		pp.useTemplate();
		ChooseProjectTypeForm cptf = new ChooseProjectTypeForm(driver);
		cptf.startEditing("New Project");
		TopMenuPage tmp = new TopMenuPage(driver);
		tmp.saveAndExit();
		long after = mw.getNumOfProjects();
		Assert.assertEquals(after, before + 1);
	}

	@Test
	public void tc03_DeleteProject() {
		MyWorkspacePage mwp = new MyWorkspacePage(driver);
		long before = mwp.getNumOfProjects();
		mwp.clickDeleteProject("Open Job Application");
		long after = mwp.getNumOfProjects();
		Assert.assertEquals(after, before - 1);

	}

	@Test
	public void tc04_MoveProjectToDifferentWorkSpace() {
		MyWorkspacePage mwp = new MyWorkspacePage(driver);
		long before = mwp.getNumOfProjects();
		mwp.moveProject("Student Feedback Survey", "Finished Projects");
		long after = mwp.getNumOfProjects();
		Assert.assertEquals(after, before - 1);
	}

	@Test
	public void tc05_addNewWorkpaces() {
		MyWorkspacePage mwp = new MyWorkspacePage(driver);
		long before = mwp.getNumberOfWorkspaces();
		mwp.addWorkspaces("Unfinished Projects");
		long after = mwp.getNumberOfWorkspaces();
		Assert.assertEquals(after, before + 1);
	}

}
