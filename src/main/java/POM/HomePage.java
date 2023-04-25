package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="twotabsearchtextbox") private WebElement searchTxtField;
	
	//getters
	public WebElement getSearchTxtField() {
		return searchTxtField;
	}


}
