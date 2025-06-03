import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;



public class Activity2 {
	public static void main(String[] args) {
	    
	    WebDriver driver = new FirefoxDriver();
	    
	    
	    driver.get("https://training-support.net/webelements/login-form/");
	    System.out.println(driver.getTitle());
	    
	    WebElement username = driver.findElement(By.id("username"));
	    username.sendKeys("admin");
	    
	    WebElement password = driver.findElement(By.id("password"));
	    password.sendKeys("password");
	    
	    WebElement loginButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        loginButton.click();
        
        driver.findElements(By.tagName("h2"))
        .forEach(h2 -> System.out.println(h2.getText()));
       
        driver.quit();

}
}




