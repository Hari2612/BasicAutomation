package automationFramework;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class ExcelDetails {
	
    public String[] readExcel(String filePath,String fileName,String sheetName) throws IOException{

    	//System.out.println("0.5");
	    File file =    new File(filePath+"\\"+fileName);
	
	
	    FileInputStream inputStream = new FileInputStream(file);
	
	    Workbook guru99Workbook = null;
	
	
	    String fileExtensionName = fileName.substring(fileName.indexOf("."));
	
	  
	    if(fileExtensionName.equals(".xlsx")){
	    	
	    	guru99Workbook = new XSSFWorkbook(inputStream);
	    	
	    }
	    else if(fileExtensionName.equals(".xls")){
	
	        guru99Workbook = new HSSFWorkbook(inputStream);
	
	    }
	
	    //System.out.println("0.6");
	
	    Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);
	
	    
	    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
	    
	     String[] a = new String[100];
	     for(int i=0;i<rowCount;i++)
	    	 a[i] = "";
	     int count =0;
	    // System.out.println("0.7");
	    for (int i = 1; i < rowCount+1; i++) {
	
	        Row row = guru99Sheet.getRow(i);
	        System.out.println("0.71");
	        //Create a loop to print cell valsues in a row
	
	        for (int j = 0; j < 1; j++) {
	        	System.out.println("0.75");
	            //Print Excel data in console
	        	if(String.valueOf(row.getCell(j).getCellType()).equals("NUMERIC")) {
	        		a[count] = String.valueOf( row.getCell(j).getNumericCellValue());
	        		count++;
	        	}
	        	else {	
		        	a[count] = row.getCell(j).getStringCellValue();
		        	count++;
	        	}
	        	
	            //System.out.print(row.getCell(j).getStringCellValue()+ " ");
	            
	
	        }
	        System.out.println("0.8");
	        System.out.println();
	    } 
	   
	    return a;

    }  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void writeExcel(String filePath,String fileName,String sheetName,String[] dataToWrite) throws IOException{
    	System.out.println("1");
        //Create an object of File class to open xlsx file

        File file =    new File(filePath+"\\"+fileName);

        //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(file);

        Workbook guru99Workbook = null;

        //Find the file extension by splitting  file name in substring and getting only extension name

        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xlsx file

        if(fileExtensionName.equals(".xlsx")){

        //If it is xlsx file then create object of XSSFWorkbook class

        guru99Workbook = new XSSFWorkbook(inputStream);

        }

        //Check condition if the file is xls file

        else if(fileExtensionName.equals(".xls")){

            //If it is xls file then create object of XSSFWorkbook class

            guru99Workbook = new HSSFWorkbook(inputStream);

        }    
        System.out.println("2");

    //Read excel sheet by sheet name    

    Sheet sheet = guru99Workbook.getSheet(sheetName);

    //Get the current count of rows in excel file

    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

    //Get the first row from the sheet

    Row row = sheet.getRow(0);

    //Create a new row and append it at last of sheet

    Row newRow = sheet.getRow(4+1);
    System.out.println("3");
    //Create a loop over the cell of newly created Row

    for(int j = 0; j < 2; j++){

        //Fill data in row
    	System.out.println("4");
        //Cell cell = newRow.createCell(j);

        newRow.getCell(j).setCellValue(dataToWrite[j]);

    }

    //Close input stream
    System.out.println("3");
    inputStream.close();

    //Create an object of FileOutputStream class to create write data in excel file

    FileOutputStream outputStream = new FileOutputStream(file);

    //write data in the excel file

    guru99Workbook.write(outputStream);

    //close output stream
    System.out.println("5");
    outputStream.close();
	
    }

   
    
    public void writeExcel1(String filePath,String fileName,String sheetName,String[] dataToWrite) throws IOException{

        File file =    new File(filePath+"\\"+fileName);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook guru99Workbook = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        if(fileExtensionName.equals(".xlsx")){
        guru99Workbook = new XSSFWorkbook(inputStream);

        }

        else if(fileExtensionName.equals(".xls")){
            guru99Workbook = new HSSFWorkbook(inputStream);

        }    

    Sheet sheet = guru99Workbook.getSheet(sheetName);

    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
    System.out.println("dsvs" + rowCount);

    
    for (int i = 1; i < rowCount+1; i++) {
    	
        Row row = sheet.getRow(i);
        for (int j = 1; j < 2; j++) {
        	row.getCell(j).setCellType(CellType.STRING);
        	row.getCell(j).setCellValue(dataToWrite[j]);
        }
    inputStream.close();
    FileOutputStream outputStream = new FileOutputStream(file);
    guru99Workbook.write(outputStream);
    outputStream.close();
	
    	}
    }


    
    

	String driverPath = "C:\\Users\\gkokz\\Documents\\GeckoDriver.exe";
    public WebDriver driver;

   
	@Before
    public void startBrowser() {
        System.setProperty("webdriver.gecko.driver", driverPath);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);

    }
	 @Test
	    public void navigateToUrl() throws Exception {
		 String[] valueToWrite = {"Mr. E","Noida"};
	        ExcelDetails objExcelFile = new ExcelDetails();
	        objExcelFile.writeExcel(System.getProperty("user.dir")+"\\src\\automationFramework","Book1.xlsx","Sheet1",valueToWrite);
		 
		 
	 }
	 
	 
	 
	 

	  @After
	    public void endTest() {
	       // driver.quit();
	    }
    
    
    
    
    
    
    
}