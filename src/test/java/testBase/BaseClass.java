package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass
	@Parameters({"os" , "browser"})
	public void setup(String os, String br) throws IOException {
		
		//loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		logger = LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase()) {
		case "chrome": driver = new ChromeDriver(); break;
		case "edge": driver = new EdgeDriver(); break;
		case "firefox": driver = new FirefoxDriver(); break;
		default: System.out.println("Invalid browser name"); return;
		}
		
		//driver = new ChromeDriver();
		//driver.manage().deleteAllCookies();
		//driver.get("https://tutorialsninja.com/demo/");
		driver.get(p.getProperty("appURL"));  //reading url from properties file
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	public String randomString() {
		@SuppressWarnings("deprecation")
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber() {
		@SuppressWarnings("deprecation")
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	public String randomAlphaNumeric() {
		@SuppressWarnings("deprecation")
		String generatedString = RandomStringUtils.randomAlphabetic(4);
		@SuppressWarnings("deprecation")
		String generatedNumber = RandomStringUtils.randomNumeric(3);
		return (generatedString + "#" + generatedNumber);
	}
	
	
}
