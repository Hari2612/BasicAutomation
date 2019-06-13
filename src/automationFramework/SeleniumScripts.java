package automationFramework;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.*;

public class SeleniumScripts {

    String driverPath = "C:\\Users\\gkokz\\Documents\\GeckoDriver.exe";
    public WebDriver driver;

   
	@SuppressWarnings("deprecation")
	@Before
    public void startBrowser() {
        System.setProperty("webdriver.gecko.driver", driverPath);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);

    }

    @Test
    public void navigateToUrl() {
        
        
      //driver.findElement(By.xpath(".//*[@id='menu-item-374']/a")).click();
        //driver.navigate().back();
      //  driver.navigate().to("https://www.youtube.com/");
        //driver.navigate().back();
        //driver.navigate().forward();
        //driver.navigate().refresh();
	
    	
    /*	driver.get("http://demo.guru99.com/test/login.html");
        WebElement e1 = driver.findElement(By.id("email"));
        WebElement e2 = driver.findElement(By.id("passwd"));
        e1.sendKeys("hari@gmail.com");
        e2.sendKeys("qdwubiwedscdw");
       e1.clear();
       //e1.sendKeys("sahcbisc@gmail.com");
       WebElement e3 = driver.findElement(By.id("SubmitLogin"));
       e3.click();
   */
    	
    /*	driver.get("http://demo.guru99.com/test/radio.html");
    	WebElement r1 = driver.findElement(By.id("vfb-7-1"));
    	WebElement r2 = driver.findElement(By.id("vfb-7-2"));
    	WebElement r3 = driver.findElement(By.id("vfb-7-3"));
    	r1.click();
    	r2.click();
    	r3.click();
    	
    	WebElement c1 = driver.findElement(By.id("vfb-6-0"));
    	WebElement c2 = driver.findElement(By.id("vfb-6-1"));
    	WebElement c3 = driver.findElement(By.id("vfb-6-2"));
    	
    	c2.click();
    	c3.click();
    	for(int i=0;i<2;i++) {
    		c1.click();
    		System.out.println(c1.isSelected());
    	}
    	*/
    	/*driver.get("https://www.facebook.com");
    	driver.findElement(By.cssSelector("a[title=\"Go to Facebook home\"]")).click();			
    	*/
    	
    	
    	/*driver.get("http://demo.guru99.com/test/newtours/register.php");
    	Select c = new Select(driver.findElement(By.name("country")));
    	c.selectByVisibleText("ANTARCTICA");
    	*/
    	/*driver.get("http://output.jsbin.com/osebed/2");
    	Select c1 = new Select(driver.findElement(By.id("fruits")));
    	c1.selectByVisibleText("Banana");
    	c1.selectByIndex(1);
    	*/
    	
    	/*driver.get("http://demo.guru99.com/test/link.html");
    	driver.findElement(By.linkText("click here")).click();
    	*/
    	
    	/*driver.get("http://demo.guru99.com/test/accessing-link.html");
    	driver.findElement(By.partialLinkText("here")).click();
    	*/
    	
    /*	driver.get("https://www.facebook.com/");           
       
        WebElement txtUsername = driver.findElement(By.id("email"));
        Actions builder = new Actions(driver);
        Action seriesOfActions = builder
        		.moveToElement(txtUsername)
        		.click()
        		.keyDown(txtUsername, Keys.SHIFT)
        		.sendKeys(txtUsername, "hello")
        		.keyUp(txtUsername, Keys.SHIFT)
        		.doubleClick(txtUsername)
        		.contextClick()
        		.build();
        */
    	
    	/*driver.get("http://demo.guru99.com/test/upload/");
    	WebElement e = driver.findElement(By.id("uploadfile_0"));
    	e.sendKeys("C:\\Users\\gkokz\\Downloads\\Image+2.png");
    	driver.findElement(By.id("terms")).click();
    	driver.findElement(By.name("send")).click();
    	*/
    	
    	/*driver.get("http://demo.guru99.com/test/delete_customer.php");
    	driver.findElement(By.name("cusid")).sendKeys("53920");		
    	driver.findElement(By.name("submit")).click();
    	Alert alert = driver.switchTo().alert();		
		
        // Capturing alert message.    
       
        	
        // Accepting alert		
        alert.dismiss();;	
        driver.switchTo().alert().accept();;		
    	
    	*/
    	/*String baseUrl = "http://demo.guru99.com/test/newtours/";
    	driver.get(baseUrl);
    	String innerText = driver.findElement(By
    		.xpath("//table[@width=\"270\"]/tbody/tr[4]/td"))
    		.getText(); 		
    	System.out.println(innerText); 
    	*/
    	//"//*[@id=\"leftcontainer\"]/table/thead/tr/th[1]"

    /*	driver.get("http://demo.guru99.com/test/web-table-element.php"); 
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 WebElement baseTable = driver.findElement(By.tagName("table"));
		  
		 //To find third row of table
		 WebElement tableRow = baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]"));
		//*[@id="leftcontainer"]/table/tbody/tr[3]/td[1]/a
        String rowtext = tableRow.getText();
		 System.out.println("Third row of table : "+rowtext);
		    
		    //to get 3rd row's 2nd column data
		    WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]/td[2]"));
		    String valueIneed = cellIneed.getText();
		  //*[@id="leftcontainer"]/table/tbody/tr[3]/td[3]
		    System.out.println("Cell value is : " + valueIneed);
	*/
    	
    	
    /*	
    	String homePage = "https://www.guru99.com";
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
    	
    	
driver.manage().window().maximize();
        
        driver.get(homePage);
        
        List<WebElement> links = driver.findElements(By.tagName("a"));
        
        Iterator<WebElement> it = links.iterator();
        
        while(it.hasNext()){
            
            url = it.next().getAttribute("href");
            
            System.out.println(url);
        
            if(url == null || url.isEmpty()){
System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
            
            if(!url.startsWith(homePage)){
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }
            
            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());
                
                huc.setRequestMethod("HEAD");
                
                huc.connect();
                
                respCode = huc.getResponseCode();
                
                if(respCode >= 400){
                    System.out.println(url+" is a broken link");
                }
                else{
                    System.out.println(url+" is a valid link");
                }
                    
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    	
    	
    	*/
    	
    	
    	
    	
    	
        String baseUrl = "http://demo.guru99.com/test/newtours/";					

    	String underConsTitle = "Under Construction: Mercury Tours";					
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);					

		driver.get(baseUrl);					
    List<WebElement> linkElements = driver.findElements(By.tagName("a"));							
    String[] linkTexts = new String[linkElements.size()];							
		int	i = 0;					

		//extract the link texts of each link element		
		for (WebElement e : linkElements) {							
		linkTexts[i] = e.getText();							
		i++;			
    }		

		//test each link		
		for (String t : linkTexts) {							
		driver.findElement(By.linkText(t)).click();					
		if (driver.getTitle().equals(underConsTitle)) {							
            System.out.println("\"" + t + "\""								
                    + " is under construction.");			
        } else {			
            System.out.println("\"" + t + "\""								
                    + " is working.");			
        }		
		driver.navigate().back();			
    }	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
	
    }
    @After
    public void endTest() {
        driver.close();
    }
}