import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChallengeActivity {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://www.google.com");

            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Accept')]")));
                acceptButton.click();
            } catch (Exception e) {
                System.out.println("No cookie popup.");
            }

            
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("cheese");
            searchBox.submit();

            
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("result-stats")));

            WebElement toolsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Tools']")));
            toolsButton.click();

            Thread.sleep(1000);  

          
            WebElement resultStats = driver.findElement(By.id("result-stats"));
            String resultText = resultStats.getText(); 
            System.out.println("Total Search Results: " + resultText.split("\\(")[0].trim());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}