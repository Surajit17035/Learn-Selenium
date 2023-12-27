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
import org.testng.annotations.Test;

public class Apple {

	
	@Test
	public void appleFooter() throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "/Users/maity/eclipse-workspace/Selenium/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.apple.com/in/");
		WebElement footerdriver = driver.findElement(By.xpath("//ul[@id='footer-directory-column-section-products']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", footerdriver);
		List<WebElement> links = driver.findElements(By.xpath("//ul[@id='footer-directory-column-section-products']/li/a"));
		for(WebElement link:links) {
			String url = link.getAttribute("href");
			//HttpURLConnection conn =(HttpURLConnection)new URL(url).openConnection();
			HttpURLConnection conn =(HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int statusCode = conn.getResponseCode();
			System.out.println(statusCode);
		}
	}
	
}
