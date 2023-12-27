package MyTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Customcalender {

	WebDriver driver = null;
	JavascriptExecutor js = null;
	
	@BeforeTest
	public void Lunch()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/maity/eclipse-workspace/Selenium/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companion/");
		js = (JavascriptExecutor) driver;
		
	}
	
	@Test
	public void calendertest()
	{	
		WebElement element = driver.findElement(By.cssSelector(".p2u_sortby"));
		js.executeScript("arguments[0].scrollIntoView();", element);
	//	js.executeScript("window.scrollBy(0,1000)", ""); 
		
//		driver.findElement(By.id("form-field-travel_from")).sendKeys("Mumbai");
//		driver.findElement(By.xpath("//input[@id='form-field-travel_to']")).sendKeys("Kolkata");
		
		driver.findElement(By.id("form-field-travel_comp_date")).click();
		
		while(!driver.findElement(By.cssSelector(".flatpickr-current-month .cur-month")).getText().contains("May"))
		{
			driver.findElement(By.cssSelector(".flatpickr-next-month")).click();
		}
		
		List<WebElement> date = driver.findElements(By.cssSelector(".flatpickr-day"));
		for(int i=0; i<date.size(); i++)
		{
			try {
				if(driver.findElements(By.cssSelector(".flatpickr-day")).get(i).getText().equalsIgnoreCase("14"))
				{
					driver.findElements(By.cssSelector(".flatpickr-day")).get(i).click();
					break;
				}
			}
			catch(StaleElementReferenceException e) {
				if(driver.findElements(By.cssSelector(".flatpickr-day")).get(i).getText().equalsIgnoreCase("14"))
				{
					driver.findElements(By.cssSelector(".flatpickr-day")).get(i).click();
					break;
				}
			}

		}
	}
}
