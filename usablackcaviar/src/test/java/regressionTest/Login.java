package regressionTest;

import org.testng.annotations.Test;


import testBase.TestBase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login extends TestBase {
	
	WebDriver driver = null;
	public static final Logger log = Logger.getLogger(Login.class.getName());
	
	@BeforeTest
	@Parameters({"BroserName","baseURL"})
	public void init(String BroserName, String baseURL){
		driver = selectBrowser(BroserName,baseURL);
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
	}
	
	@DataProvider()
	public Object [][] loginData(){
		
		Object [][] data = {{"valera@test.com", "123"},{"test12@abc.net","zmxncbv"}};
				
		return data;
		
	}
	

	//@Test(dataProvider="loginData")
	//public void LoginPage(String loginName, String pass) {
	@Test
	public void LoginPage() {
		log.info("Test is started");
		System.out.println("Test is started");
		//.get("http://usablackcaviar.com");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).clear();
		log.info("Entering login name");
		driver.findElement(By.id("input-email")).sendKeys("test12@abc.net");
		//driver.findElement(By.id("input-email")).sendKeys(loginName);
		driver.findElement(By.id("input-password")).clear();
		log.info("Entering login password");
		driver.findElement(By.id("input-password")).sendKeys("zmxncbv");
		//driver.findElement(By.id("input-password")).sendKeys(pass);
		driver.findElement(By.xpath(".//*[@id='content']/div/div[2]/div/form/input")).click();

		Assert.assertEquals(driver.getTitle(), "My Account");

		driver.findElement(By.xpath("(//a[contains(text(),'Logout')])[2]")).click();
		driver.findElement(By.linkText("Continue")).click();
	}


}
