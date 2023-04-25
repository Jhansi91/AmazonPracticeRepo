package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationPage {
	public ValidationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath="//a[@class='a-link-normal sc-product-link' ]//img") private WebElement prodimg;

	@FindBy(xpath="//a[@class='a-link-normal sc-product-link' ]/ancestor::div[@data-asin]") private WebElement prodimg;
	@FindBy(xpath="//span[@class='a-dropdown-prompt']") private WebElement actqty;
	
	public WebElement getProdimg() {
		return prodimg;
	}

	
	public WebElement getActqty() {
		return actqty;
	}


	public String productValidation(String expected)
	{
		//String actual = prodimg.getAttribute("alt");
		String actual = prodimg.getAttribute("data-asin");
		System.out.println(expected);
		System.out.println(actual);
		
		if(expected.contains(actual))
		{
			System.out.println("valid");
		}
		
		else
		{
			System.out.println("invalid");
		}
		return actual;
		
		
	}
	
	public String updateQtyvalidation(String expected)
	{
		String actual = actqty.getText();
		if(actual.equals(expected))
		{
			System.out.println("qty updated successfully");
		}
		else
		{
			System.out.println("qty not updated");
		}
		return actual;
		
	}
}
