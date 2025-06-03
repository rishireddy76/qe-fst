import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class HelloSelenium {
  public static void main(String[] args) {
    
    WebDriver driver = new FirefoxDriver();
    
    
    driver.get("https://training-support.net");

    // Perform testing and assertions
    
System.out.println(driver.getTitle());
    
    
    
    driver.quit();
    
  }
}
