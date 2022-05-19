package practiceTestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetAllLinks {

	WebDriver driver; 
	
	@BeforeTest
	public void init() { 
		
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://objectspy.space/");
		driver.manage().window().maximize();
				
	}
	@Test
	public void getlinks () { 
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for(WebElement element: links) {
			
			System.out.println(element.getAttribute("href"));
			

		}
		System.out.println("All links are printed.");
	}
}
