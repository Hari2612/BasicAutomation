package automationFramework;



import java.io.*;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class Time_Weather {
	
	
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
		 driver.get("https://weather.com/en-IN/weather/hourbyhour/l/072e7110ccda5a2b786e1b942f4946d382bdd6ff315f63682bfc14827786c271");
		 LocalTime time = LocalTime.now();
		 int minutes = time.getMinute();
		 String time1 = null;
		 if (minutes > 45)
		 {
			 
			 time = time.plusHours(1);
			 int d = time.getHour();
				
				 time1 = String.valueOf(d) + ":" +  "00";
		 }
		 else if (minutes > 30)
		 {
			
			 int d = time.getHour();
				int d1 = time.getMinute();
				 time1 = String.valueOf(d) + ":" +  "45";
		 }
		 else if (minutes > 15)
		 {
			
			 int d = time.getHour();
				 time1 = String.valueOf(d) + ":" +  "30";
		 }
		 else if (minutes > 0)
		 {
			 
			 int d = time.getHour();
				
				 time1 = String.valueOf(d) + ":" +  "15";
		 }

		 // Round down
		
		// d.split(" ");
		 //System.out.println("Time:" + time1);
		 
		 //String d3 = driver.findElement(By.xpath("(//span[@class= 'dsx-date' and text() = \'" +time1 +  "\'])//following::td")).getText();
		 //System.out.println("Description:" + d3);
		 String d3 = driver.findElement(By.xpath("(//span[@class= 'dsx-date' and text() = \'" +time1 +  "\'])//following::td[2]")).getText();
		 System.out.println("Temperature:" +  d3);
		 System.out.println();
		 driver.findElement(By.xpath("/html/body/div[1]/div/div/div[10]/div/main/region/div[3]/div/section/div/div/div/button")).click();
		 //driver.findElement(By.className("icon icon-font iconset-arrows icon-arrow-down-line")).click();
		 
		 
		 System.out.println("Temperature for next 24 hours");
		 int j = 23;
		 while( j-- >0) {
			 WebElement e  = driver.findElement(By.xpath("(//span[@class= 'dsx-date' and text() = \'" +time1 +  "\'])//following::tr[23-" +j +"]"));
			
			 d3 = e.findElement(By.className("dsx-date")).getText();
			 System.out.println("Time:"  +  d3);
			 
			 
			 d3 = e.findElement(By.className("temp")).getText();
			 System.out.println("Temperature:" + d3);
			 
			 
			 System.out.println();
			 
			 
		 }
		 
	 }
	 
	


	
	@After
	   public void endTest() {
	      // driver.quit();
	   }


}
