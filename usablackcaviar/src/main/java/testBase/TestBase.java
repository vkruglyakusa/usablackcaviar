package testBase;

import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class TestBase {
	
	public static WebDriver driver;
	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	public static WebDriver selectBrowser(String browser, String baseURL) {
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	
		driver = null;
		if (browser.equals("chrome") || browser.equals("CHROME")) {
			System.out.println("Test runs with Chrome Browser");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/webDrivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(baseURL);
		}else if (browser.equals("firefox") || browser.equals("FIFEFOX")) {
			System.out.println("Test runs with FireFox Browser");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/webDrivers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(baseURL);
		}
		return driver;
	}
	
	public static String randomAddress() {
		int AddresName = 10000 + (int) (Math.random() * ((10000 - 100) + 12));

		return AddresName + " Test Random Street Number";
	}

	protected static String getSaltString() {

		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}
	
	@AfterClass
	public void afterTest() {
		driver.close();
	}
	
}
