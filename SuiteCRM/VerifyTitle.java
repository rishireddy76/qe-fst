import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class VerifyTitle {
	 WebDriver driver;
	 @BeforeMethod
    public  void setUp() {
		 driver = new FirefoxDriver();
	        driver.get("http://alchemy.hguy.co/crm");
	    }
        
      @Test
      public void verifyTitle() {
          String title = driver.getTitle();
          assertEquals(title, "SuiteCRM", "Website title is incorrect.");
          System.out.println("Activity1: Website title verified: " + title);
      }

      @AfterMethod
      public void tearDown() {
          driver.quit();
      }
  }
      