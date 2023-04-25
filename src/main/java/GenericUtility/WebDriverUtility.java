package GenericUtility;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility{
	
	
	/**
	 * this method is used to maximise the browser window
	 * @param driver
	 * @author jhansi
	 */
   public void maximizeBrowser(WebDriver driver)
   {
	   driver.manage().window().maximize();
   }
   
  
   
   /**
    * this method is used for switching windows
    * @param driver
    * @param partail_window_title
    * @author jhansi
    */
   public void switchWindow(WebDriver driver,String partail_window_url)
   {
	   Set<String> all_windows =driver.getWindowHandles(); 
		Iterator<String> window_ids = all_windows.iterator(); 
		while(window_ids.hasNext())
		{
			String wid = window_ids.next();
			driver.switchTo().window(wid);
			String url = driver.getCurrentUrl();
			if(url.contains(partail_window_url))
			{
				break;
			}
		}
   }
   public void switchWindowByTitle(WebDriver driver,String partail_title)
   {
	   Set<String> all_windows =driver.getWindowHandles(); 
		Iterator<String> window_ids = all_windows.iterator(); 
		while(window_ids.hasNext())
		{
			String wid = window_ids.next();
			driver.switchTo().window(wid);
			String ttl = driver.getTitle();
			if(ttl.contains(partail_title))
			{
				break;
			}
		}
   }
   
   /**
	 * This method is used to wait for page to load before identifying any synchronized element in DOM
	 * @param driver
	 * @author jhansi
	 */
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	/**
	 * after every action it will wait for next action to perform
	 * @param driver
	 * @author jhansi
	 */
	public void scriptTimeOut(WebDriver driver)
	{
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
	}
	
	/**
	 * used to wait for element to clickable in GUI and check for specific elementfor every 500 milliseconds
	 * @param driver
	 * @param element
	 * @param polling_time
	 * @author jhansi
	 */
	public void waitForElemenetWithCustomTimeOUT(WebDriver driver,WebElement element,int polling_time)
	{
		FluentWait wait=new FluentWait(driver);
		wait.withTimeout(Duration.ofSeconds(30));
		wait.pollingEvery(Duration.ofSeconds(polling_time));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * used to switch to AlertWindow and Accept(click on ok button)
	 * @param driver
	 * @author jhansi
	 */
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	
	/**
	 * used to switch to AlertWindow and Dismiss(click on cancel button)
	 * @param driver
	 * @author jhansi
	 */
	public void switchToAlertAndDismiss(WebDriver driver)
	{	
		driver.switchTo().alert().dismiss();	
	}
	
	
	/**
	 * used to switch to Frame Window based on index
	 * @param driver
	 * @param index
	 * @author jhansi
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	
	/**
	 * used to switch to Frame Window based on id/name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switchToFrame(WebDriver driver,String id_name_attribute)
	{
		driver.switchTo().frame(id_name_attribute);
	}
	
	
	/**
	 * used to select the value from DropDown based on index
	 * @param element
	 * @param index
	 * @author jhansi
	 */
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	
	/**
	 * used to select the value from DropDown based on text
	 * @param element
	 * @param text
	 * @author jhansi
	 */
	public void select(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);;
	}
	
	
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 * @author jhansi
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	
	/**
	 * used to RightClick on specified element
	 * @param driver
	 * @param element
	 * @author jhansi
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void moveByOffset(WebDriver driver,int x,int y)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(x, y).click().perform();
	}
}
