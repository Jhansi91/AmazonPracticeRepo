package Cart;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import GenericUtility.WebDriverUtility;
import POM.Cart;
import POM.HomePage;
import POM.ProductPage;
import POM.ValidationPage;

public class DeleteProductFromCart extends BaseClass {
	
	@Test
	public  void deleteProductFromCart() throws Throwable {

		WebDriverUtility wlib=new WebDriverUtility();
		wlib.maximizeBrowser(driver);
		wlib.implicitWait(driver);
		
		FileUtility file=new FileUtility();
		String URL = file.getKeyValue("url");
		
		driver.get(URL);
		
		ExcelUtility elib=new ExcelUtility();
		String prod = elib.getData("ProductData", 0, 0);	
		
		HomePage home=new HomePage(driver);
		WebElement searchfld = home.getSearchTxtField();
		searchfld.sendKeys(prod,Keys.ENTER);
		
		Sheet sheet = elib.getProdSheet("ProductList");
		
		ProductPage plib=new ProductPage(driver);
		plib.setProdDataInExcel(driver, 0, sheet);
		
		elib.writeIntoBook();	
			
		String specific_productid = elib.getData("ProductList", 5, 2);
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//div[@data-asin='"+specific_productid+"']//img"))).click().perform();
		
		
		wlib.switchWindow(driver, specific_productid);
		
		ProductPage pd=new ProductPage(driver);
		pd.getAddToCart().click();
		

		ValidationPage validation=new ValidationPage(driver);
		String actual = validation.productValidation(specific_productid);
		
		Assert.assertEquals(actual, specific_productid);
		
		Cart cart=new Cart(driver);
		cart.getCartlink().click();
		cart.getDeletelink().click();
		
	}

}
