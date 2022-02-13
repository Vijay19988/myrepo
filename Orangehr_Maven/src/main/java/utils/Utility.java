package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
public class Utility {
	
	public static String getDataDFromExcelSheet(String sheet, int row, int col) throws EncryptedDocumentException, IOException 
	{
		String path = "C:\\Users\\vijay\\OneDrive\\Documents\\Book12.xlsx";
		FileInputStream file = new FileInputStream(path);
	    String data= WorkbookFactory.create(file).getSheet("Sheet2").getRow(row).getCell(col).getStringCellValue();
		return data;	    
	}
	
	/*public static void takeScreenshotHere(WebDriver driver,int testID) throws IOException 
	{
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_HHmmss");
		Date d = new Date();
		String datee = sdf.format(d);
		File shot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\vijay\\OneDrive\\Desktop\\screenshot\\test"+testID+datee+".jpg");
		FileHandler.copy(shot, dest);
		
		
	}*/
	
	
	
	
	
	
	
	
	
	

}
