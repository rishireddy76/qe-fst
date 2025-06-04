import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3Test {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        

        driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/login-form/");
    }

    @Test
    public void loginWithValidCredentials() {
       
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));

   
        usernameField.sendKeys("admin");
        passwordField.sendKeys("password");

        
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        loginButton.click();

       
        WebElement confirmationMessage = driver.findElement(By.xpath("//h1[contains(text(), 'Success')]"));
        String messageText = confirmationMessage.getText();

       
        Assert.assertEquals(messageText, "Login Success!",
                            "Confirmation message did not match expected value.");
    }

    @AfterClass
    public void tearDown() {
        
        if (driver != null) {
            driver.close();
        }
    }
}
