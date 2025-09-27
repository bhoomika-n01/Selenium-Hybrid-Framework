package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLoginPage extends BasePage {
	
	public AccountLoginPage(WebDriver driver){
		super(driver);
	}
	
	//locators
	
	@FindBy(xpath = "//input[@id = 'input-email']")
	WebElement UserName;
	
	@FindBy(xpath = "//input[@name = 'password']")
	WebElement LoginPassword;
	
	@FindBy(xpath = "//input[@value = 'Login']")
	WebElement loginBtn;
	
	//action methods
	
	public void enterUsername(String email) {
		UserName.sendKeys(email);
	}
	
	public void enterPwd(String pwd) {
		LoginPassword.sendKeys(pwd);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
}
