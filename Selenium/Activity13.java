import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity13 {
	public static void main(String[] args) {
        
	     WebDriver driver = new FirefoxDriver();
	     WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
	     driver.get("https://training-support.net/webelements/tables");
	     System.out.println("Page title: " + driver.getTitle());

	     List<WebElement> cols = driver.findElements(By.xpath("//table/thead/tr/th"));
	        System.out.println("Number of columns: " + cols.size());
	        
		     List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		        System.out.println("Number of rows: " + rows.size());
		        
		        List<WebElement> thirdRow = driver.findElements(By.xpath("//table/tbody/tr[3]/td"));
		        System.out.print("Third Row Cell Values: ");
		        for (WebElement cell : thirdRow) {
		            System.out.print(cell.getText() + " ");
		        }
		        System.out.println();

		        WebElement cell = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
		        System.out.println("Cell Value at (2,2): " + cell.getText());

		     driver.quit();
	}
}
