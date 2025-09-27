package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_AccountLoginPage extends BaseClass {
	
	@Test
	public void verify_account_login() {
		
	try {	
	logger.info("------Starting Login---------");
	HomePage hp = new HomePage(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	hp.clickMyAccount();
	hp.clickLogin();
	
	logger.info("--------Entering Credentials---------");
	AccountLoginPage alp = new AccountLoginPage(driver);
	alp.enterUsername(p.getProperty("login-email"));
	alp.enterPwd(p.getProperty("password"));
	alp.clickLoginBtn();
	
	logger.info("-----my account page-----");
	MyAccountPage macc = new MyAccountPage(driver);
	boolean targetPage = macc.isMyAccountPageDisplayed();
	//Assert.assertEquals(targetMSG, true);
	Assert.assertTrue(targetPage);
	
	}
	catch(Exception e) {
		Assert.fail();
	}
	logger.info("Test TC002 completed");
	}
	
}
