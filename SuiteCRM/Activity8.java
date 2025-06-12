import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.List;

public class Activity8 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://alchemy.hguy.co/crm");

        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        
        // Verify login success
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab0")));
    }

    @Test
    public void printOddNumberedAccountNames() {
        // Navigate to Accounts
        wait.until(ExpectedConditions.elementToBeClickable(By.id("grouptab_0"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Accounts"))).click();
        
        // Wait for table to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//table[contains(@class, 'list view')]/tbody/tr")
        ));

        List<WebElement> rows = driver.findElements(
            By.xpath("//table[contains(@class, 'list view')]/tbody/tr")
        );

        System.out.println("Activity8: Odd-numbered row account names:");
        int printedCount = 0;

        for (int i = 0; i < rows.size() && printedCount < 5; i++) {
            if ((i + 1) % 2 != 0) {
                WebElement nameCell = rows.get(i).findElement(By.xpath(".//td[@field='name']//a"));
                System.out.println(nameCell.getText());
                printedCount++;
            }
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}