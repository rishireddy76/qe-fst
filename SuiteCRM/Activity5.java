import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class Activity5 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    public void getNavigationMenuColor() {
        
        WebElement usernameField = driver.findElement(By.id("user_name"));
        WebElement passwordField = driver.findElement(By.id("username_password"));
        WebElement loginButton = driver.findElement(By.id("bigbutton"));

        usernameField.sendKeys("admin");
        passwordField.sendKeys("pa$$w0rd");
        loginButton.click();

        
        WebElement navBar = driver.findElement(By.id("toolbar")); 

       
        String navColor = navBar.getCssValue("background-color");

      
        System.out.println("Activity5: Navigation bar color: " + navColor);
    }

    @AfterClass
    public void tearDown() {
       
        driver.quit();
    }
}
