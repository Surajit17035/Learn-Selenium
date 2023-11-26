package MyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Dropdown {
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
	public void StaticDropdownTest()
	{	
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText("USD");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
	}
	
	@Test
	public void Dropdownincrement() throws InterruptedException
	{
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000L);
		int i = 1;
		while(i < 3) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
			
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}
}
