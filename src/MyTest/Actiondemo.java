package MyTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Actiondemo {

	WebDriver driver = null;
	
	
	@BeforeTest
	public void Lunch()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/maity/eclipse-workspace/Selenium/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/gp/css/homepage.html/ref=nav_bb_ya");
		
	}
	@Test
	public void mousedemo() {
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//span[text()='Hello, sign in']"))).build().perform();
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("apple iphone").build().perform();
	}
	
}
