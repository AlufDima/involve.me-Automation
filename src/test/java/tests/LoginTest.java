package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import pageObject.MyWorkspacePage;
import pageObject.TopMenuPage;
import utils.Utils;

public class LoginTest extends BaseTest {

	// Override login to ignore real login
	@Override
	public void setupLogin() {
	}


	@Test
	public void tc01_login_with_wrong_case_sensative_password() {
		LoginPage lp = new LoginPage(driver);
		lp.loginBtn1();
		lp.login("aluf.dima@gmail.com", "dima123456");
		String expected = "These credentials do not match our records.";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);
	}

	@Test(dataProvider = "getData")
	public void tc02_invalid_login(String user, String Password) {
		LoginPage lp = new LoginPage(driver);
		lp.login(user, Password);
		String expected = "These credentials do not match our records.";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void tc03_valid_login() {
		LoginPage lp = new LoginPage(driver);
		lp.login(Utils.readProperty("username"), Utils.readProperty("password"));
		MyWorkspacePage mw = new MyWorkspacePage(driver);
		Assert.assertTrue(mw.isMyWorkspacePage());
	}

	@Test
	public void tc04_logOut() {
		LoginPage lp = new LoginPage(driver);
		TopMenuPage tmp = new TopMenuPage(driver);
		tmp.logOut();
		Assert.assertEquals(lp.getTitle(), "Log in");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] myData = { { "user1@gmail.com", "123" }, { "user2@gmail.com", "123" }, { "use3@gmail.com", "1#444" },
				{ "user4@gmail.com", "123456878" }, };
		return myData;
	}

}
