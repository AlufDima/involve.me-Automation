package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.MyWorkspacePage;
import pageObject.PreviewIQTestPage;

public class IQTemplateTest extends BaseTest {


	@Test
	public void tc01_Templete_IQ_Test() {
		MyWorkspacePage mwp = new MyWorkspacePage(driver);
		mwp.previewProject("IQ Test");
		PreviewIQTestPage pitp = new PreviewIQTestPage(driver);
		pitp.getWindowMainTab();
		pitp.switchtoLastTab();
		pitp.startIQTest();
		pitp.chooseShapeAnswer("Complete the sequence");
		pitp.chooseAnswer("brilliant", "What has similar meaning?");
		pitp.chooseAnswer("Ellbow", "Find the analogy");
		pitp.chooseAnswer("T", "Continue the sequence");
		pitp.chooseAnswer("Dandelion", "Find the odd one");
		pitp.chooseShapeAnswer("Complete the sequence");
		pitp.chooseAnswer("Harp", "Find the odd one");
		pitp.chooseAnswer("14", "Continue the sequence");
		pitp.chooseAnswer("Carpenter", "Find the analogy");
		pitp.chooseAnswer("26", "Continue the sequence");
		String finalScore = pitp.getFinalScore();
		Assert.assertEquals(finalScore, "40");
	}

}
