package GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {
	Workbook book;
	public String getData(String sheetname,int row,int col) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/ExcelAmazon.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		DataFormatter formate=new DataFormatter();
		String data=formate.formatCellValue(book.getSheet(sheetname).getRow(row).getCell(col));
		return data;
		
	}
	
	public Sheet getProdSheet(String prod) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelAmazon.xlsx");
	    book = WorkbookFactory.create(fis);
		 if(book.getSheet(prod)==null)
		 {
			 book.createSheet(prod);
		 }
		 Sheet sheet = book.getSheet(prod);

		return sheet;
	}
	
	public void writeIntoBook() throws Throwable
	{

		FileOutputStream os = new FileOutputStream("./src/test/resources/ExcelAmazon.xlsx");
		book.write(os);
	}

}
