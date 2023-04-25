package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {
	public Cart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="nav-cart") private WebElement cartlink;
	@FindBy(xpath="//input[@value='Delete']") private WebElement deletelink;
	@FindBy(xpath="//span[@id='a-autoid-0-announce']") private WebElement qtyDD;
	
	//@FindBy(xpath="//li/a[text()='2']")private WebElement qty;
	//getters
	public WebElement getCartlink() {
		return cartlink;
	}
	public WebElement getDeletelink() {
		return deletelink;
	}
	public WebElement getQtyDD() {
		return qtyDD;
	}
	
	
	public void selectQty(WebDriver driver,String qty)
	{
		driver.findElement(By.xpath("//li/a[text()='"+qty+"']")).click();
	}
	
	

}
