package ActionKeywords;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.openqa.selenium.NoSuchElementException;

import config.Constants;

public class ActionKeywords {
	public static WebDriver driver;

	public static void fnOpenBrowser(){
		/*
		 * System.setProperty("webdriver.chrome.driver",Constants.ChromeDriverPath);
		 * driver = new ChromeDriver();
		 */
		System.setProperty("webdriver.gecko.driver",Constants.FirefoxDriverPath);
		driver = new FirefoxDriver();
	}

	public static void fnNavigate(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constants.URL);
	}

	public static void fnEnterEmail(){
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(Constants.UserName);
	}
	
	public static void fnEnterPassword(){
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Constants.Password);
	}
	
	public static void fnClickSignIn(){
		driver.findElement(By.id("login")).click();
	}

	public static void fnAddBook() {
		try {
			driver.findElement(By.xpath("//button[@id='gotoStore']")).click();
			driver.findElement(By.className("rt-tbody")).findElement(By.xpath("//a")).click();
			driver.findElement(By.xpath("//button[contains(text(),'Add To Your Collection')]")).click();

			driver.switchTo().alert().accept();

			driver.findElement(By.xpath("//button[contains(text(),'Back To Book Store')]")).click();
		}catch(NoSuchElementException e) {
			Assert.fail("Element not Found");
			e.printStackTrace();
		}
	}

	public static void fnCloseBrowser(){
		driver.quit();
	}

}
