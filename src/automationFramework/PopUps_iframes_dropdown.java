package automationFramework;


import java.io.*;
import java.util.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;


public class PopUps_iframes_dropdown {
	
	
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
			 
			 
			 
			 
			 			
			
			 //pop-ups
			 driver.get("https://www.toolsqa.com/selenium-tutorial/");
			
			 
			 driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div/div/div/div/ul[2]/li[1]/span/a/em/strong")).click();
			
			 //driver.switchTo().window(mainWindow);
			 //driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div/div/div/div/ul[2]/li[1]/span/a/em/strong")).click();
			
			 String mainWindow = driver.getWindowHandle();
			
			 Set<String> s = driver.getWindowHandles();
			 Iterator<String> i = s.iterator();
			
			 while(i.hasNext()) {
				 String child = i.next();
				 
				 if(!mainWindow.equalsIgnoreCase(child)) {
					
					
					 driver.switchTo().window(child);
					 
					
					
					System.out.println(driver.getCurrentUrl());
					driver.close();
					
				 }
			 }
			 driver.switchTo().window(mainWindow);	
			 System.out.println(driver.getTitle());
			 
			 
			 
			 
			 
			 //dropdowns
			 driver.get("https://www.facebook.com/");
			 driver.findElement(By.name("firstname")).sendKeys("hari");
			 driver.findElement(By.name("lastname")).sendKeys("veeranki");
			 driver.findElement(By.name("reg_email__")).sendKeys("hari@gmail.com");
			 driver.findElement(By.name("reg_email_confirmation__")).sendKeys("hari@gmail.com");
			 driver.findElement(By.name("reg_passwd__")).sendKeys("123456789");
			 
			 Select drp = new Select(driver.findElement(By.name("birthday_month")));
			 drp.selectByVisibleText("Jul");
				
			 Select drp1 = new Select(driver.findElement(By.name("birthday_day")));
			 drp1.selectByVisibleText("15");
					
				
			 Select drp2 = new Select(driver.findElement(By.name("birthday_year")));
			 drp2.selectByVisibleText("1999");
			 
			 driver.findElement(By.xpath("//*[@id=\"u_0_7\"]")).click();
			 driver.findElement(By.name("websubmit")).click();
			 
			 
			 driver.get("http://demo.guru99.com/test/guru99home/"); 
		       // navigates to the page consisting an iframe

		       driver.manage().window().maximize();
		       driver.switchTo().frame("a077aa5e"); //switching the frame by ID

				System.out.println("********We are switch to the iframe*******");
	     		driver.findElement(By.xpath("/html/body/a/img")).click();
	  		    //Clicks the iframe
	       
	  			System.out.println("*********We are done***************");
			 
		 }
		 
			 
	
		 @After
		    public void endTest() {
		       // driver.quit();
		    }
	

}
 