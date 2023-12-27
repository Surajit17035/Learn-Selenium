package MyTest;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Greencart {

	WebDriver driver = null;
	int j = 0;
	
	
	@BeforeTest
	public void Lunch()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/maity/eclipse-workspace/Selenium/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		
	}
	@Test
	public void eCommerceValidation() {
		List<WebElement> productName = driver.findElements(By.cssSelector(".product-name"));
		List<WebElement> AddToCart = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));		
		String[] veggies = {"Brocolli", "Cucumber","Beetroot"};
		List<String> vegList = Arrays.asList(veggies);
		
		for(int i=0; i<productName.size(); i++) {
			if(productName.get(i).getText().contains("Cauliflower")) {
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
			}
		}
		
	}
	
}
