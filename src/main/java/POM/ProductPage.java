package POM;

import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductPage {
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[@id='submit.add-to-cart']") private WebElement addToCart;

	public WebElement getAddToCart() {
		return addToCart;
	}
	
	
	public void setProdDataInExcel(WebDriver driver,int rowno,Sheet sheet)
	{
		/*
		 * List<WebElement> searchdata = driver .findElements(By.
		 * xpath("//span[@class='a-size-medium a-color-base a-text-normal']/ancestor::a[contains(@class,'a-link-normal s-underline-text')]"
		 * ));
		 */
		
		List<WebElement> searchdata = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
		
		for (WebElement we : searchdata) {
			
			Row row=sheet.createRow(rowno);
			row.createCell(0).setCellValue(we.getText());
			//System.out.println(we.getText());
			//String link=we.getAttribute("href").substring(21);
			//WebElement price = driver.findElement(By.xpath("//a[@href='"+link+"']/span[@class='a-price']"));
			//System.out.println(price.getText());
			
			String prodId = we.getAttribute("data-asin");
			WebElement price = driver.findElement(By.xpath("//div[@data-asin='"+prodId+"']//span[@class='a-price']"));
			
			row.createCell(1).setCellValue(price.getText());
			
			row.createCell(2).setCellValue(prodId);
			rowno++;
			
		}
		
		
	}


	
	
	
}
