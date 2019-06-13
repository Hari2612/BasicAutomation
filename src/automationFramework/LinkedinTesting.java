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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class LinkedinTesting {
	
    public String[] readExcel(String filePath,String fileName,String sheetName) throws IOException{

    	
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
	
	    Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);
	
	    
	    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
	    
	     String[] a = new String[100];
	     for(int i=0;i<rowCount;i++)
	    	 a[i] = "";
	     int count =0;
	   
	    for (int i = 1; i < rowCount+1; i++) {
	
	        Row row = guru99Sheet.getRow(i);
	        
	        for (int j = 0; j < 1; j++) {
	        	
	        	if(String.valueOf(row.getCell(j).getCellType()).equals("NUMERIC")) {
	        		a[count] = String.valueOf( row.getCell(j).getNumericCellValue());
	        		count++;
	        	}
	        	else {	
		        	a[count] = row.getCell(j).getStringCellValue();
		        	count++;
	        	}
	        	
	            
	            
	
	        }
	     
	    } 
	   
	    return a;

    }  

    
    
    
    
    public void writeExcel(String filePath,String fileName,String sheetName,String[] dataToWrite) throws IOException{
    	
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
  
   
int c =0;
  for (int i = 1; i < 5; i++) {
    	
        Row row = sheet.getRow(i);
       
        for (int j = 1; j < 2; j++) {
       
        	//row.createCell(1);
        	row.getCell(1).setCellValue(dataToWrite[c++]);
        	
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
		 
		 LinkedinTesting objExcelFile = new LinkedinTesting();


		    String filePath = System.getProperty("user.dir")+"\\src\\automationFramework";
		    	
		    //Call read file method of the class to read data

		   String[] ans =  objExcelFile.readExcel(filePath,"Book1.xlsx","Sheet1");
		  //  System.out.println("1");
		 /*
		 driver.get("https://www.facebook.com/");
		 driver.findElement(By.name("firstname")).sendKeys(ans[0]);
		 driver.findElement(By.name("lastname")).sendKeys(ans[1]);
		 driver.findElement(By.name("reg_email__")).sendKeys(ans[2]);
		 driver.findElement(By.name("reg_passwd__")).sendKeys("123456789");
		 
		 Select drp = new Select(driver.findElement(By.name("birthday_month")));
		 drp.selectByVisibleText(ans[3]);
			
		 Select drp1 = new Select(driver.findElement(By.name("birthday_day")));
		 drp1.selectByVisibleText(ans[4]);
				
			
		 Select drp2 = new Select(driver.findElement(By.name("birthday_year")));
		 drp2.selectByVisibleText(ans[5]);
		 
		 driver.findElement(By.name("sex")).click();
		 driver.findElement(By.name("websubmit")).click();
		 */
		  
		   String[] out = new String[10];
		  
		   driver.get("https://www.linkedin.com/start/join");
			 int coun =-1;
			 
			 boolean s = true;
			 while(s==true) {
				 coun++;
			
			 driver.findElement(By.className("fill-v2")).click();
			 WebElement e = driver.findElement(By.xpath("//*[@id=\"uno-reg-join\"]/div/div/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/p/strong"));
			  s = e.isDisplayed();
			
			 String org = e.getText();
			 
			 if(org.contains("Please enter your first name")) {
				
				 driver.findElement(By.name("firstName")).sendKeys(ans[0]);
				
				 driver.findElement(By.className("fill-v2")).click();
				 WebElement e1 = driver.findElement(By.xpath("//*[@id=\"uno-reg-join\"]/div/div/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/p/strong"));
				 boolean n  = e1.isDisplayed();
				 
				 if(n) {
					 String org1 = e1.getText();
					 if(org1.contains("Please enter a valid first name")) {
						 out[coun] = "failed";
					 }
					 else {
						 out[coun] = "passed";
					 }
				 }
				 else {
					 out[coun] = "passed";
				  }
				 }
				 
			 
			 else if (org.contains("Please enter your last name") ) {
				
				 driver.findElement(By.name("lastName")).sendKeys(ans[1]);
				// System.out.println("4" );
				 driver.findElement(By.className("fill-v2")).click();
				 WebElement e1 = driver.findElement(By.xpath("//*[@id=\"uno-reg-join\"]/div/div/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/p/strong"));
				 boolean n  = e1.isDisplayed();
				 if(n) {
					 String org1 = e1.getText();
					 if(org1.contains("Please enter a valid last name")) {
						 out[coun] = "failed";
					 }
					 else {
						 out[coun] = "passed";
					 }
				 }
				 else {
					 out[coun] = "passed";
				  }
				 
				 
			 }
			 else if (org.contains("Please enter your email address" )) {
				
				 driver.findElement(By.name("emailAddress")).sendKeys(ans[2]);
				
				 driver.findElement(By.className("fill-v2")).click();
				 WebElement e1 = driver.findElement(By.xpath("//*[@id=\"uno-reg-join\"]/div/div/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/p/strong"));
				 boolean n  = e1.isDisplayed();
				 if(n) {
					 String org1 = e1.getText();
					 if(org1.contains("Please enter a valid email address")) {
						 out[coun] = "failed";
						 org = "Please enter your password";
					 }
					 else {
						 out[coun] = "passed";
					 }
				 }
				 else {
					 out[coun] = "passed";
				  }
				 
			 }
			 
			 else if (org.contains("Please enter your password")) {
				
				 driver.findElement(By.name("password")).sendKeys(ans[3]);
				
				 s = false;
				 driver.findElement(By.className("fill-v2")).click();
				
				 boolean n  = false;
				 
				 if(n) {
					 
						 out[coun] = "failed";
					
				 }
				 else {
					 out[coun] = "passed";
				  }
				 
			 }
			 
			 }
			 
			 
			 
			 LinkedinTesting objExcelFile11 = new LinkedinTesting();

			 	
		        objExcelFile11.writeExcel(System.getProperty("user.dir")+"\\src\\automationFramework","Book1.xlsx","Sheet1",out);
		
		 
		 
	 }
	 
	 
	 
	 

	  @After
	    public void endTest() {
	       // driver.quit();
	    }
    
    
    
    
    
    
    
}