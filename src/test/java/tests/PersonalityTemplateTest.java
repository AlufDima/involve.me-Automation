package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.MyWorkspacePage;
import pageObject.PreviewPersonalityPage;

public class PersonalityTemplateTest extends BaseTest {
	//	This test will open personality test template in web browser and complete it



	@Test
	public void tc01_Templete_personality_Test() {
		MyWorkspacePage mwp = new MyWorkspacePage(driver);
		mwp.previewProject("Personality Test");
		PreviewPersonalityPage ptp = new PreviewPersonalityPage(driver);
		ptp.getWindowMainTab();
		ptp.switchtoLastTab();
		ptp.clickStartBtn();
		ptp.chooseAnswer("In a mansion", "Where would you choose to live?");
		ptp.chooseAnswer("No", "Do you enjoy telling people what to do?");
		ptp.chooseAnswer("By inviting friends over", "How will you celebrate your next birthday?");
		String finalTxt = ptp.getFinalTxt();
		Assert.assertEquals(finalTxt, "You're a Leader");
	}
}
