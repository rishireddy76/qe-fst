import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class Activity7 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm");

        WebElement username = driver.findElement(By.id("user_name"));
        WebElement password = driver.findElement(By.id("username_password"));
        WebElement loginBtn = driver.findElement(By.id("bigbutton"));

        username.sendKeys("admin");
        password.sendKeys("pa$$w0rd");
        loginBtn.click();
    }

    @Test
    public void readPhoneFromPopup() throws InterruptedException {
        WebElement salesMenu = driver.findElement(By.id("grouptab_0")); 
        salesMenu.click();
        
        WebElement leadsLink = driver.findElement(By.xpath("//*[@id=\"moduleTab_9_Leads\"]"));
        leadsLink.click();

        Thread.sleep(3000);

      
        WebElement infoIcon = driver.findElement(By.xpath("//table[contains(@class, 'list view table')]//tr[1]//span[@title='Additional Details']"));
        Thread.sleep(1000);
        infoIcon.click();
        Thread.sleep(2000);

        WebElement phoneNumber = driver.findElement(By.xpath("//span[@class='phone']"));
        System.out.println("Activity7: Phone Number: " + phoneNumber.getText());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
