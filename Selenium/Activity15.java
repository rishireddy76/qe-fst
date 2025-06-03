import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity15 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        
            driver.get("https://training-support.net/webelements/dynamic-attributes");

            
            System.out.println("Page title is: " + driver.getTitle());

            
            WebElement fullName = driver.findElement(By.xpath("//input[contains(@placeholder, 'Full name')]"));
            WebElement email = driver.findElement(By.xpath("//input[contains(@placeholder, 'Email Address')]"));
            WebElement date = driver.findElement(By.xpath("//input[@type= 'date']"));
            WebElement details = driver.findElement(By.xpath("//textarea"));

            
            fullName.sendKeys("rishi");
            email.sendKeys("sunkireddy@gmail.com");
            date.sendKeys("2002-07-02");
            details.sendKeys("nothing");

           
            driver.findElement(By.xpath("//button[text()='Submit']")).click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation"))
            );
           

            WebElement message = driver.findElement(By.id("action-confirmation"));
            System.out.println("Success message: " + message.getText());
            

       
            driver.quit();
        }
    }

