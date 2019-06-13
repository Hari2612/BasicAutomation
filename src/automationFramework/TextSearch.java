package automationFramework;


import java.io.*;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TextSearch {
	
		String driverPath = "C:\\Users\\gkokz\\Documents\\GeckoDriver.exe";
	    public WebDriver driver;

	   
		@Before
	    public void startBrowser() {
	        System.setProperty("webdriver.gecko.driver", driverPath);
	        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	        capabilities.setCapability("marionette", true);
	        driver = new FirefoxDriver(capabilities);

	    }
		
		public String search(BufferedReader br) throws Exception {
			String ans = "";
			int i;
			
			while(( i = br.read()) != -1 ){
				if((char)i != '#') {
					while((char)br.read() != '=');
					
					ans = ans + br.readLine();
				}
				else {
					br.readLine();
				}
			}
			
			
			return ans;
			
		}

	    @Test
	    public void navigateToUrl() throws Exception {

	    	
	    	String fileName = "C:\\Farmrise\\test\\src\\property.txt"; 
	        
	    	driver.get("https://www.guru99.com/selenium-tutorial.html");
	    	FileReader fr = new FileReader(fileName);
	    	BufferedReader br = new BufferedReader(fr);
	    	
	    	String str = search(br);
	    	
	    	driver.findElement(By.id("search")).sendKeys(str);
	    	driver.findElement(By.id("search")).sendKeys(Keys.ENTER);;
	    	
	        
	    }
	    
	    @After
	    public void endTest() {
	       // driver.quit();
	    }

		
	}	
