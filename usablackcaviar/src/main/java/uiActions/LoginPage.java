package uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class LoginPage extends TestBase{

	WebDriver driver;
	public static final Logger log = Logger.getLogger(LoginPage.class.getName());

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "My Account")
	public WebElement myAccountLing;

	@FindBy(linkText = "Login")
	public WebElement loginLink;

	@FindBy(id = "input-email")
	public WebElement inputBoxEmail;

	@FindBy(id = "input-password")
	public WebElement inputBoxPassword;

	@FindBy(xpath = ".//*[@id='content']/div/div[2]/div/form/input")
	public WebElement submitButton;

	public void loginToAccount(String loginName, String passWord) {
		log.info("Enter login name and pass on login page");
		inputBoxEmail.clear();
		inputBoxEmail.sendKeys(loginName);
		inputBoxPassword.clear();
		inputBoxPassword.sendKeys(passWord);
		submitButton.click();
	}
}
