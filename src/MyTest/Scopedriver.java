package MyTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Scopedriver {

	WebDriver driver = null;
	WebElement footerdriver = null;
	
	
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
	public void Driverscope() {
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
	}
	
	@Test
	public void OpenlinkTab() throws InterruptedException {
		List<WebElement> links = driver.findElements(By.xpath("//table/tbody/tr/td[1]/ul/li/a"));
		for(int i=0; i<links.size(); i++) {
			String keypress = Keys.chord(Keys.CONTROL, Keys.ENTER);
			driver.findElements(By.xpath("//table/tbody/tr/td[1]/ul/li/a")).get(i).sendKeys(keypress);
			
		}
		Thread.sleep(5000L);
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext()) {
			 driver.switchTo().window(it.next());
			 System.out.println(driver.getTitle());
			
		}
		
	}
	

}
