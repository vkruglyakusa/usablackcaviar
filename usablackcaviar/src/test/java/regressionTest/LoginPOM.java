package regressionTest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testBase.TestBase;
import uiActions.HomePage;
import uiActions.LoginPage;

public class LoginPOM extends TestBase {
	
	WebDriver driver = null;
	public static final Logger log = Logger.getLogger(Login.class.getName());
	
	HomePage homePage;
	LoginPage loginPage;
	
	@BeforeTest
	@Parameters({"BroserName","baseURL"})
	public void Init(String BroserName, String baseURL){
		driver = selectBrowser(BroserName,baseURL);
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
	}
	
	@Test
	public void Login() {
		
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		homePage.navigateToLoginPage();
		loginPage.loginToAccount("inputBoxEmail", "zmxncbv");
		
	}

}
