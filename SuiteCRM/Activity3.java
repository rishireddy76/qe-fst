import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
public class Activity3 {
	WebDriver driver;

    @BeforeClass
    public void setUp() {
       
        driver = new FirefoxDriver();
            driver.get("http://alchemy.hguy.co/crm");
    }
    
    @Test
    public void getFooterCopyright() {
            WebElement footer = driver.findElement(By.id("admin_options"));
           System.out.println("Activity3: Copyright text: " + footer.getText());
        } 
          
    @AfterClass
    public void tearDown() {
            driver.quit();
        }
    }

