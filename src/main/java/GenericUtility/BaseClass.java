package GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	public static WebDriver sdriver;
	public WebDriver driver;
	
	@BeforeSuite
	public void BS()
	{
		System.out.println("DataBase Connection");
	}
	@BeforeTest
	public void BT()
	{
		System.out.println("Parallel Execution");
	}
	
	@BeforeClass
	public void BC() throws Throwable
		{
		FileUtility file=new FileUtility();
		String BROWSER = file.getKeyValue("browser");
		
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		System.out.println("launching browser");
		sdriver=driver;
	}
	@BeforeMethod
	public void BM() throws Throwable
	{
		System.out.println("Login to Application");
	}
	@AfterMethod
	public void AM()
	{
		System.out.println("Logout Application");
	}
	@AfterClass
	public void AC()
	{
		driver.quit();
		System.out.println("Browser closed");
	}
	@AfterTest
	public void AT() 
	{
		System.out.println("Parallel Execution Done");
	}
	@AfterSuite
	public void AS()
	{
		System.out.println("DataBase Connection close");
	}
	

}
