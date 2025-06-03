import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;


public class Activity4 {
  public static void main(String[] args) {
    
    WebDriver driver = new FirefoxDriver();
    driver.get("https://training-support.net/webelements/target-practice");
    System.out.println(driver.getTitle());
    
    WebElement thirdHeader = driver.findElement(By.xpath("//h3"));
    System.out.println("3rd Header Text: " + thirdHeader.getText());
    
    WebElement fifthHeader = driver.findElement(By.xpath("//h5"));
    String color = fifthHeader.getCssValue("color");
    System.out.println("5th Header Color: " + color);
    
    WebElement purpleButton = driver.findElement(By.xpath("//button[contains(@class, 'purple')]"));
    String purpleClasses = purpleButton.getDomAttribute("class");
    System.out.println("Purple Button Classes: " + purpleClasses);
    
    WebElement slateButton = driver.findElement(By.xpath("//button[text()='Slate']"));
    String slateText = slateButton.getText();
    System.out.println("Slate Button Text: " + slateText);
   
  driver.quit();
}
}