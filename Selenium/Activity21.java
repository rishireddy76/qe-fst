
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class Activity21 {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/webelements/tabs");
        System.out.println("Page title: " + driver.getTitle());
        
        WebElement openTabButton = driver.findElement(By.xpath("//button[text()='Open A New Tab']"));
        openTabButton.click();
        
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> handles = driver.getWindowHandles();
        String originalHandle = driver.getWindowHandle();
        for (String handle : handles) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        System.out.println("New Tab Title: " + driver.getTitle());
        WebElement message1 = driver.findElement(By.tagName("h2"));
        System.out.println("Message in New Tab: " + message1.getText());
        
        WebElement openAnotherTab = driver.findElement(By.xpath("//button[text()='Open Another One']"));
        openAnotherTab.click();
        
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(originalHandle) && !handle.equals(driver.getWindowHandle())) {
                driver.switchTo().window(handle);
                break;
            }
        }
        System.out.println("Third Tab Title: " + driver.getTitle());
        WebElement message2 = driver.findElement(By.tagName("h2"));
        System.out.println("Message in Third Tab: " + message2.getText());
        
        driver.quit();
        
	}
}
