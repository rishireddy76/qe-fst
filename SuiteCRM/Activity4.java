import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class Activity4 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void loginTest() {
        WebElement username = driver.findElement(By.id("user_name"));
        WebElement password = driver.findElement(By.id("username_password"));

        username.sendKeys("admin");
        password.sendKeys("pa$$w0rd");

        driver.findElement(By.id("bigbutton")).click();

        try {
            WebElement dashboard = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("toolbar"))
            );
            System.out.println("Activity4: Login successful. Dashboard is visible.");
        } catch (Exception e) {
          
            List<WebElement> errorMessages = driver.findElements(By.xpath("//*[@id='form']/span[3]"));
            if (!errorMessages.isEmpty()) {
                System.out.println("Activity4: Login failed: " + errorMessages.get(0).getText());
            } else {
                System.out.println("Activity4: Login failed: Unknown reason.");
            }
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
