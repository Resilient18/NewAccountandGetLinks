package practiceTestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddAccount {
	
	WebDriver driver; 
	String browser;
	//Element List 
	By USER_NAME_FIELD = By.xpath("//input [@id = 'username']");
	By PASSWORD_FIELD = By.xpath("//input [@id = 'password']"); 
	By SIGNIN_BUTTON_FIELD = By.xpath("//button [@class= 'btn btn-success block full-width']");
	By DASHBOARD_FIELD = By.xpath("//*[@id='page-wrapper']/div[2]/div/h2");
	By CUSTOMERS_FIELD = By.xpath("//div[@class ='sidebar-collapse']/descendant::span[6]");
	By ADD_CUSTOMER_FIELD = By.xpath("//div[@id ='wrapper']/descendant::a[7]");
	By CONTACTS_HEADER_FIELD = By.xpath("//div[@id='wrapper']/descendant::h2");
	By FULL_NAME_FIELD = By.xpath("//input[@id = 'account' ]");
	By COMPANY_FIELD = By.xpath("//select[@id ='cid']");
	By EMAIL_FIELD = By.xpath("//input[@id = 'email']");
	By PHONE_FIELD = By.xpath("//input[@id = 'phone']");
	By ADDRESS_FIELD  = By.xpath("//input[@id = 'address']");
	By CITY_FIELD = By.xpath("//input[@id = 'city']");
	By SAVE_FIELD = By.xpath("//button[@id = 'submit']");
	By LIST_CUSTOMER = By.xpath("//div[@class = 'sidebar-collapse']/descendant::a[8]");
	
	//Test Data 
		String userName = "demo@techfios.com";
		String password = "abc123";
		String fullname = "Raji#aacc#2";
		String company = "Techfios";
		String email = "janedoe@techfios.com";
		String phone = "12345678";
		String address = "NewTechnology ln";
		String city = "Dallas";
		
		
		//@BeforeClass
	/*public void readConfig() { 
	 //InputStream 
		try { 
			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
			Properties prop = new Properties();		
			prop.load(input);
			browser = prop.getProperty(browser);
		}catch (IOException e) {
			e.getStackTrace();
		}
	}*/
	
	@BeforeTest
public void init() { 
	
	//if (browser.equalsIgnoreCase("chrome")) { 
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	//}else if (browser.equalsIgnoreCase("firefox")) {
		//System.setProperty("webdriver.gecko.driver","drivers\\geckodriver.exe");
	//	driver = new FirefoxDriver();
//	}
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
 @Test(priority=1)
public void loginTest() {
	
	driver.findElement(USER_NAME_FIELD).sendKeys(userName);
	driver.findElement(PASSWORD_FIELD).sendKeys(password);
	driver.findElement(SIGNIN_BUTTON_FIELD).click();
	System.out.println("Login Successful");
	
	WebDriverWait wait = new WebDriverWait(driver, 30); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_FIELD));
	System.out.println("Dashboard Page is visible.");
}
 @Test(priority=2)
 public void addcustomer() throws InterruptedException { 
	 	Thread.sleep(2000);
	 	driver.findElement(CUSTOMERS_FIELD).click();
		driver.findElement(ADD_CUSTOMER_FIELD).click();
		driver.findElement(CONTACTS_HEADER_FIELD);
		driver.findElement(FULL_NAME_FIELD).sendKeys(fullname);
		//Choosing an option from a dropdown menu
		Select sel = new Select(driver.findElement(COMPANY_FIELD));
		sel.selectByVisibleText(company);
		driver.findElement(EMAIL_FIELD).sendKeys(email);
		driver.findElement(PHONE_FIELD).sendKeys(phone);
		driver.findElement(ADDRESS_FIELD).sendKeys(address);
		driver.findElement(CITY_FIELD).sendKeys(city);
		//choosing country from the options given
		//sel.selectByVisibleText(country);
		driver.findElement(SAVE_FIELD).click();
		Thread.sleep(2000);
		driver.findElement(LIST_CUSTOMER).click();
 }

}
