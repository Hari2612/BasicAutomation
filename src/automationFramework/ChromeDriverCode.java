package automationFramework;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverCode {

	
		 public static void main(String[] args) {
		 String exePath = "C:\\Users\\gkokz\\Downloads\\chromedriver_win32\\chromedriver.exe";
		 System.setProperty("webdriver.chrome.driver", exePath);
		 WebDriver driver = new ChromeDriver();
		 driver.get("http://toolsqa.com/automation-practice-form/");
		 }
		}
	
	
	