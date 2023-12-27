package MyTest;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Windowhandle {


	WebDriver driver = null;
	
	
	@BeforeTest
	public void Lunch()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/maity/eclipse-workspace/Selenium/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
	}
	@Test
	public void windowhandle()
	{
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String parentWin = it.next();
		String childWin = it.next();
		driver.switchTo().window(childWin);
		String str = driver.findElement(By.cssSelector(".red")).getText();
		String emailText = str.split("with")[0].split("at")[1].trim();
		System.out.println(emailText);
		driver.switchTo().window(parentWin);
		driver.findElement(By.id("username")).sendKeys(emailText);	
			
	}
}
