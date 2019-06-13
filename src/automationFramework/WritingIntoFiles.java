package automationFramework;

import java.io.*;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
public class WritingIntoFiles {
	
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
    	//identifying Title
       
		driver.get("https://www.guru99.com/selenium-tutorial.html");
		String title = driver.getTitle();
		String text = driver.findElement(By.className("titreck")).getText();
        
        String fileName = "C:\\Farmrise\\test\\src\\property.txt"; 
       
        BufferedWriter out = new BufferedWriter( new FileWriter(fileName)); 
        out.write(title);
        out.close(); 
        
        
		BufferedWriter out1 = new BufferedWriter( new FileWriter(fileName,true)); 
		out1.write(text);
		out1.close();
		
		
		FileReader fr=new FileReader(fileName);    
		BufferedReader br=new BufferedReader(fr);    
		br.skip(title.length());
		String ans = "";
		int i;
		while((i = br.read())!= -1)
    	ans = ans + (char)i;
    	br.close();
    	
    	
    	
    	//System.out.println(ans);
    	driver.findElement(By.linkText(ans)).click();
    	BufferedWriter out2 = new BufferedWriter( new FileWriter(fileName,true)); 
   		out2.write("	" + ans);
   		out2.close();
       
       
    }
    
    @After
    public void endTest() {
        driver.quit();
    }

	
	


}
