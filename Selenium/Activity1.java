import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        
    }

    @Test
    public void OpenTS() {
    	driver.get("https://training-support.net");
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        
    }

    @AfterClass
    public void Close() {
        driver.close();
    }
}
