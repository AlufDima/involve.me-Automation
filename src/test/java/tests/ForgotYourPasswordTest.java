package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.ForgotPasswordPage;
import pageObject.LoginPage;

public class ForgotYourPasswordTest extends BaseTest {
	private final String SUCCESS_MSG = "A reset link has been sent to the email address, if it has been used to register for an account.";
	private final String FAIL_MSG = "We can't find a user with that e-mail address.";
	private final String WRONG_MSG = "We can't find a user with that e-mail";

@Override
public void setupLogin() {
}

	@Test
	public void tc01_invalidEmailTest() {
		LoginPage lp = new LoginPage(driver);
		lp.loginBtn1();
		lp.forgotPassword();
		ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
		fpp.sendPasswordRestLink("test2@gmail.com");
		Assert.assertEquals(fpp.getInvalidMsg(), FAIL_MSG);
	}

	// Fail in purpose -expected result is different from actual
	@Test
	public void tc02_invalidEmailTest() {
		LoginPage lp = new LoginPage(driver);
		lp.loginBtn1();
		lp.forgotPassword();
		ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
		fpp.sendPasswordRestLink("test2@gmail.com");
		Assert.assertEquals(fpp.getInvalidMsg(), WRONG_MSG);
	}

	@Test
	public void tc03_validEmailTest() {
		ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
		fpp.sendPasswordRestLink("aluf.dima@gmail.com");
		Assert.assertEquals(fpp.getSuccessrMsg(), SUCCESS_MSG);

	}

}
