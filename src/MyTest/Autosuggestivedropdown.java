package MyTest;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Autosuggestivedropdown {
	WebDriver driver = null;
	
	@BeforeTest
	public void Launch()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/maity/eclipse-workspace/Selenium/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	}

	@Test
	public void StaticDropdownTest() throws InterruptedException
	{	
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> countryList = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(int i=0 ; i<countryList.size(); i++) 
		{
			if (countryList.get(i).getText().equalsIgnoreCase("India"))
			{
				countryList.get(i).click();
			}
		}
		
		
	}
}


//# Learn-Selenium
//
//1. git init
//2. git add README.md
//3. git add .
//4. git commit "version 1"
//5. git branch -M main
//6. git remote add origin https://github.com/Surajit17035/Learn-Selenium.git
//7. git push --force origin main
//
//git push -u origin main command isn't working in this repo.

