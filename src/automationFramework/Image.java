package automationFramework;
import java.io.File;
import java.util.concurrent.TimeUnit;


import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.api.*;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;


public class Image {
public static FirefoxDriver wd;


ScreenRegion s;
Target target ;
ScreenRegion r; 


// Create a mouse object
Mouse mouse ;


public void click_Image(String img)
{
  s = new DesktopScreenRegion();
 target = new ImageTarget(new File(img));
  r = s.find(target);


 // Create a mouse object
  mouse = new DesktopMouse();
 // Use the mouse object to click on the center of the target region
 mouse.click(r.getCenter()); 
}
    @BeforeClass
    public static void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void register() throws InterruptedException {
     wd.get(“http://www.terrence.com/flash/calculator.html&#8221;);
     click_Image(“IMG\\1.png”);
     click_Image(“IMG\.png”);
     click_Image(“IMG\\plus.png”);
     click_Image(“IMG\\2.png”);
     click_Image(“IMG\\equal.png”);
    }
    
    @After
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }


}
