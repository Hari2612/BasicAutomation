package automationFramework;


import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebElementsMethods {

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
    public void navigateToUrl() {
    	//identifying Title
       
		driver.get("https://www.guru99.com/xpath-selenium.html");
     /*   String title = driver.getTitle();
        System.out.println(title);
        
        
        
        //finding and printing text
        String text = driver.findElement(By.className("titreck")).getText();
        System.out.println(text);
        
        
        
        //clicking element for five times
        for(int i=0;i<5;i++) {
        	driver.findElement(By.linkText(text)).click();
        	driver.navigate().back();
        }
        
        */
        
        
                                                      
        //identifying elements by various methods
        
      
        /* driver.navigate().to("http://toolsqa.com/automation-practice-form/");
       driver.findElement(By.partialLinkText("Partial")).click();
       driver.findElement(By.linkText("Link Test")).click();
       driver.navigate().back();
       driver.findElement(By.name("firstname")).sendKeys("Hari");
       driver.findElement(By.name("lastname")).sendKeys("Veeranki");
       driver.findElement(By.id("sex-0")).click();
       driver.findElement(By.cssSelector("input#datepicker")).sendKeys("13 july");
       driver.findElement(By.cssSelector("input#exp-0")).click();
       driver.findElement(By.cssSelector("input#profession-1")).click();
       driver.findElement(By.cssSelector("input#tool-2")).click();
       driver.findElement(By.tagName("button")).click();
       driver.findElement(By.cssSelector("img.preload-me")).click();
       String x = driver.findElement(By.xpath("//*[text()='Enterprise Testing']//ancestor::div[1]")).getText();
       System.out.println(x);
       */
       
      driver.findElement(By.xpath("//*[@id=\"demo1\"]/li[11]//following-sibling::li/a")).click();;
       
    }

    @After
    public void endTest() {
        driver.quit();
    }

}
