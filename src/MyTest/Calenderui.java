package MyTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Calenderui {

	WebDriver driver = null;
	
	@BeforeTest
	public void Launch()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/maity/eclipse-workspace/Selenium/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
	}
	
	@Test
	public void Test()
	{		
		driver.findElement(By.cssSelector("div[class='css-1dbjc4n r-18u37iz'] div[class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-5njf8e r-1otgn73'] ")).click();
		List<WebElement> date = driver.findElements(By.cssSelector("div[class='css-1dbjc4n r-1awozwy r-1pi2tsx r-1777fci r-13qz1uu']"));

		
		for(int i=0; i<= date.size(); i++)
		{
			String dateNo = driver.findElements(By.cssSelector("div[class='css-1dbjc4n r-1awozwy r-1pi2tsx r-1777fci r-13qz1uu']")).get(i).getText();
			
			if (dateNo.equalsIgnoreCase("26"))
			{
				driver.findElements(By.cssSelector("div[class='css-1dbjc4n r-1awozwy r-1pi2tsx r-1777fci r-13qz1uu']")).get(i).click();
				break;
			}
		}
	
		String expecteddate = driver.findElement(By.cssSelector("div[class='css-1dbjc4n r-18u37iz'] div[class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-5njf8e r-1otgn73'] div[class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']")).getText();
		
		System.out.println(expecteddate);
		Assert.assertEquals(expecteddate, "Tue, 26 Dec 2023");
		
		
	}
			
}
