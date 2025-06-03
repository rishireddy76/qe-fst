import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriver driver = new FirefoxDriver();

	     // Open the page
	     driver.get("https://training-support.net/webelements/dynamic-controls");
	     // Print the title of the page
	     System.out.println("Page title: " + driver.getTitle());
	     
	     WebElement checkbox = driver.findElement(By.id("checkbox"));
	     System.out.println("check box selected before the click: " + checkbox.isSelected());
	     checkbox.click();
	     System.out.println("check box selected after the click: " + checkbox.isSelected());
	     driver.quit();
}
}

