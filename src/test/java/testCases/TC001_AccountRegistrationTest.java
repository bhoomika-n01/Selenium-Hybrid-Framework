package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

//Opencart WebSite

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	@Test
	public void verify_account_registration() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		hp.clickMyAccount();
		Thread.sleep(3000);
		hp.clickRegister();
		
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
		
		String confirm = arp.confirmationMsg();
		Assert.assertEquals(confirm, "Your Account Has Been Created!");
			
	}
	
	
}
