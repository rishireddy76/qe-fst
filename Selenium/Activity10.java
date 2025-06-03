import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10 {
	public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        

        
        driver.get("https://training-support.net/webelements/drag-drop");
        System.out.println("Page title: " + driver.getTitle());
        
        WebElement footballElement = driver.findElement(By.id("ball"));
        WebElement dropzone1 = driver.findElement(By.id("dropzone1"));
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
        
        Actions builder  = new Actions(driver);
        
        builder.clickAndHold(footballElement).moveToElement(dropzone1).pause(2000).release().build().perform();
        if(dropzone1.findElement(By.className("dropzone-text")).getText().equals("Dropped!")) {
        	System.out.println("Ball was dropped in Dropzone 1");
        }
        
        builder.dragAndDrop(footballElement, dropzone2).build().perform();
        if(dropzone2.findElement(By.className("dropzone-text")).getText().equals("Dropped!")) {
        	System.out.println("Ball was dropped in Dropzone 2");
        }
        
        driver.close();
	}
}
