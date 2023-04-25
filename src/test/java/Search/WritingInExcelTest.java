package Search;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import GenericUtility.WebDriverUtility;
import POM.HomePage;
import POM.ProductPage;

public class WritingInExcelTest extends BaseClass{
	@Test
	public  void writingInExcelTest()throws Throwable 
	{
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.maximizeBrowser(driver);
		wlib.implicitWait(driver);
		
		FileUtility file=new FileUtility();
		String URL = file.getKeyValue("url");
		
		ExcelUtility elib=new ExcelUtility();
		String prod = elib.getData("ProductData", 1, 0);	
		
		Sheet sheet = elib.getProdSheet(prod);
		int rowno = sheet.getLastRowNum()+1;
        System.out.println(rowno);
		driver.get(URL);
		
		HomePage home=new HomePage(driver);
		WebElement searchfld = home.getSearchTxtField();
		searchfld.sendKeys(prod,Keys.ENTER);
		ProductPage plib=new ProductPage(driver);
		plib.setProdDataInExcel(driver, rowno, sheet);
		
		elib.writeIntoBook();
		
	}


}
