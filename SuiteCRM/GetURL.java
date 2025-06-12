import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class GetURL {
	WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
    }
        @Test
        public void getHeaderImageURL() {
        WebElement headerImage = driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));

       
        String imageURL = headerImage.getAttribute("src");
        System.out.println("Activity2: Header image URL: " + imageURL);
        }
       
        @AfterClass
        public void tearDown() {
        driver.quit();
    }
}
