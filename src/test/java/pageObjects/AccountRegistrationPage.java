package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	
	@FindBy(xpath = "//input[@name = 'firstname']")
	WebElement enterFirstname;
	
	@FindBy(xpath = "//input[@id = 'input-lastname']")
	WebElement enterLastname;
	
	@FindBy(xpath = "//input[@id = 'input-email']")
	WebElement enterEmail;
	
	@FindBy(xpath = "//input[@id = 'input-password']")
	WebElement enterPassword;
	
	@FindBy(xpath = "//input[@type = 'checkbox']")
	WebElement checkBox;
	
	@FindBy(xpath = "//input[@type = 'submit']")
	WebElement clickLogin;
	
	@FindBy(xpath = "//h1[normalize-space() = 'Your Account Has Been Created!']")
	WebElement confirmMessage;
	
	//Action methods
	
	public void ipFirstname(String firstname) {
		enterFirstname.sendKeys(firstname);
	}
	
	public void ipLastname(String lastname) {
		enterLastname.sendKeys();
	}
	
	public void ipEmail(String email) {
		enterEmail.sendKeys(email);
	}
	
	public void ipPassword(String pwd) {
		enterPassword.sendKeys(pwd);
	}
	
	public void toggleCheckbox() {
		checkBox.click();
	}
	
	public void clickLoginbtn() {
		clickLogin.click();
	}
	
	public String confirmationMsg() {
		try {
			return (confirmMessage.getText());
		} 
		catch(Exception e) {
			return(e.getMessage());
		}
	}
	
}
