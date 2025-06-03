import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity14 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/tables");

        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        System.out.println("Number of rows: " + rows.size());

        List<WebElement> cols = driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
        System.out.println("Number of columns: " + cols.size());

        WebElement bookNameBeforeSort = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        System.out.println("Book in 5th row before sort: " + bookNameBeforeSort.getText());

        WebElement priceHeader = driver.findElement(By.xpath("//table/thead/tr/th[5]"));
        priceHeader.click();

        WebElement bookNameAfterSort = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        System.out.println("Book in 5th row after sort: " + bookNameAfterSort.getText());

      
        driver.quit();
    }
}
