import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import static org.testng.Assert.*;

import java.time.Duration;

public class Activity6 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    public void checkActivitiesMenu() {
      
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();

        
        WebElement activitiesMenu = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.id("grouptab_3"))  
        );

       
        assertTrue(activitiesMenu.isDisplayed(), "Activities menu is not displayed.");
        assertEquals(activitiesMenu.getText().trim(), "ACTIVITIES", "Menu text does not match 'Activities'");

        System.out.println("Activity6: Activities menu is present.");
    }

    @AfterClass
    public void tearDown() {
        
        driver.quit();
    }
}
