import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.List;

public class Activity9 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://alchemy.hguy.co/crm");

        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
    }

    @Test
    public void printFirst10Leads() throws InterruptedException {
        driver.findElement(By.id("grouptab_0")).click(); 
        driver.findElement(By.linkText("Leads")).click(); 

        Thread.sleep(3000);  // Prefer WebDriverWait in real tests

        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr"));

        System.out.println("Activity9: First 10 Leads:");
        for (int i = 0; i < Math.min(10, rows.size()); i++) {
            WebElement name = rows.get(i).findElement(By.xpath("./td[3]"));  
            WebElement user = rows.get(i).findElement(By.xpath("./td[8]")); 

            System.out.println("Name: " + name.getText() + " | User: " + user.getText());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
