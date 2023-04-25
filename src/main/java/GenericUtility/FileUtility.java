package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;


public class FileUtility {
	
	
	public String getKeyValue(String key) throws Throwable
	{
	
	FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
	Properties pro=new Properties();
	pro.load(fis);
	String value = pro.getProperty(key);
	return value;
	}
}
