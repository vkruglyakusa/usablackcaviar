package regressionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author vkruglyak
 *
 */
public class Test_Login {

	public static void main(String[] args) {

		/**
		 * WebDriver initialization for Chrome browser
		 */
		
		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/webDrivers/chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		

		String baseUrl = "http://usablackcaviar.com";
		
		driver.manage().window().maximize();
		driver.get(baseUrl + "/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("test12@abc.net");
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys("zmxncbv");
		driver.findElement(By.xpath(".//*[@id='content']/div/div[2]/div/form/input")).click();

		if (driver.getTitle().equals("My Account")) {
			
			System.out.println("Test Passed!");
			
		} else {
			
			System.out.println("Test Failed");
			
		}

		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'Logout')])[2]")));
		
		driver.findElement(By.xpath("(//a[contains(text(),'Logout')])[2]")).click();
		driver.findElement(By.linkText("Continue")).click();

		driver.close();
	}

}