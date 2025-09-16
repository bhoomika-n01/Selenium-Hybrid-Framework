package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

//Opencart WebSite

public class TC001_AccountRegistrationTest {
	
	WebDriver driver;

	@BeforeClass
	public void setup() {
		
		driver = new ChromeDriver();
		//driver.manage().deleteAllCookies();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void verify_account_registration() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		hp.clickMyAccount();
		Thread.sleep(3000);
		hp.clickRegister();
		
		AccountRegistrationPage arp = new AccountRegistrationPage(driver);
		arp.ipFirstname("John");
		arp.ipLastname("bary");
		arp.ipEmail("johnbary3@mailinator.com");
		arp.iptelephone("43536363536");
		arp.ipPassword("john123");
		arp.ipConfirmPassword("john123");
		arp.toggleCheckbox();
		arp.clickLoginbtn();
		
		
		String confirm = arp.confirmationMsg();
		Assert.assertEquals(confirm, "Your Account Has Been Created!");
		
		
		
	}
	
	
}
