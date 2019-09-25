package uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;


public class HomePage extends TestBase{
	
	WebDriver driver;
	public static final Logger log = Logger.getLogger(HomePage.class.getName());

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "My Account")
	public WebElement myAccountLing;
	
	@FindBy(linkText = "Login")
	public WebElement loginLink;
	
	public void navigateToLoginPage(){
		myAccountLing.click();
//		Thread.sleep(200);
		loginLink.click();
	}

}
