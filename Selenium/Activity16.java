import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class Activity16 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

            driver.get("https://training-support.net/webelements/selects");
            System.out.println("Page title is: " + driver.getTitle());
            
            WebElement dropdown = driver.findElement(By.cssSelector("select.bg-purple-200"));

            Select select = new Select(dropdown);
            select.selectByVisibleText("Two");
            select.selectByIndex(2);
            select.selectByValue("three");
            
            List<WebElement> allOptions = select.getOptions();
            System.out.println("All dropdown options:");
            for (WebElement option : allOptions) {
                System.out.println(option.getText());
            }
            driver.quit();
    }
}
