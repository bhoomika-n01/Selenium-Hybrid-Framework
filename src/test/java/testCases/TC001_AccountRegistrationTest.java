package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest {
	
	WebDriver driver;

	@BeforeClass
	public void setup() {
		
		driver = new ChromeDriver();
		//driver.manage().deleteAllCookies();
		
		driver.get("https://www.opencart.com/index.php?route=cms/demo");
		driver.findElement(By.xpath("//span[normalize-space() = 'View Store Front']")).click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void verify_account_registration() {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegistrationPage arp = new AccountRegistrationPage(driver);
		arp.ipFirstname("John");
		arp.ipLastname("bary");
		arp.ipEmail("johnbary@mailinator.com");
		arp.ipPassword("john123");
		arp.toggleCheckbox();
		arp.clickLoginbtn();
		
		String confirm = arp.confirmationMsg();
		Assert.assertEquals(confirm, "Your Account Has Been Created!");
		
		
		
	}
	
	
}
