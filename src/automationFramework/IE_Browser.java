package automationFramework;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IE_Browser{
public static void main(String[] args) {
 
	System.setProperty("webdriver.ie.driver","C:\\Users\\gkokz\\Documents\\My Received Files\\IEDriverServer.exe");
	DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
    cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	WebDriver driver = new InternetExplorerDriver();;
 driver.get("http://demoqa.com");
 }
}