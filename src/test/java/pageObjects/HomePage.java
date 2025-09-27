package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.StaleElementReferenceException;


public class HomePage extends BasePage{
	//WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement MyAccountLink;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement RegisterLink;
	
	@FindBy(xpath = "//a[normalize-space() = 'Login']")
	WebElement LoginLink;
	
	public void clickMyAccount() {
		MyAccountLink.click();
	}
	
	public void clickRegister() {
		RegisterLink.click();
	}
	
	public void clickLogin() {
		LoginLink.click();
	}
	
}
