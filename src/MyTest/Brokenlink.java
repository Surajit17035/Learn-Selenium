package MyTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Brokenlink {

	WebDriver driver = null;
	WebElement footerdriver = null;
	SoftAssert a = new SoftAssert();
	
	@BeforeTest
	public void Lunch()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/maity/eclipse-workspace/Selenium/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		footerdriver = driver.findElement(By.id("gf-BIG"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", footerdriver);
	}
	@Test
		public void Linkbroken() throws MalformedURLException, IOException {
		List<WebElement> links = driver.findElements(By.xpath("//ul/li/a"));
		for(WebElement link: links) {
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int statusCode = conn.getResponseCode();
			System.out.println(statusCode);
//			if(statusCode >= 400) {
//				System.out.println("Link is Broken, Status code: " +statusCode);
//			}else {
//				System.out.println("Link is Working, Status code: " +statusCode);
//			}
			
			a.assertTrue(statusCode<400, "Link is Broken, Status code: " +statusCode);
			
		}
		a.assertAll();
		

	}

}
