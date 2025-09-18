package testCases;

import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

//Opencart WebSite

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	@Test
	public void verify_account_registration() throws InterruptedException {
		
		try {
		logger.info("*******Starting the testcase TC001********");
		HomePage hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		hp.clickMyAccount();
		logger.info("clicked on my account cta");
		Thread.sleep(3000);
		hp.clickRegister();
		
		logger.info("*****Providing customer details*****");
		AccountRegistrationPage arp = new AccountRegistrationPage(driver);
		arp.ipFirstname(randomString().toUpperCase());
		arp.ipLastname(randomString().toUpperCase());
		arp.ipEmail(randomString() + "@mailinator.com");
		arp.iptelephone(randomNumber());
		
		String password = randomAlphaNumeric();
		arp.ipPassword(password);
		arp.ipConfirmPassword(password);
		arp.toggleCheckbox();
		arp.clickLoginbtn();
		
		logger.info("Validating expected result");
		String confirm = arp.confirmationMsg();
		Assert.assertEquals(confirm, "Your Account Has Been Created!");
		} 
		catch (Exception e) {
			logger.error("Test failed");
			logger.debug("debug logs...");
			Assert.fail();
		}
		
		logger.info("*****Finished the testcase TC001*****");
	}
	
	
}
