package stepDefinitons;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import io.cucumber.java.After;

import java.time.Duration;
import java.util.List;

public class Rows {

    WebDriver driver;
    WebDriverWait wait;

    @Given("I open the CRM login page")
    public void openLoginPage() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://alchemy.hguy.co/crm");
    }

    @When("I enter valid username and password")
    public void enterCredentials() {
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
    }

    @And("I click the login button")
    public void clickLogin() {
        driver.findElement(By.id("bigbutton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab0")));
    }

    @And("I navigate to the \"Sales\" tab")
    public void clickSalesTab() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("grouptab_0"))).click();
    }

    @And("I click on \"Accounts\"")
    public void clickAccounts() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Accounts"))).click();
    }

    @Then("I should see the Accounts table")
    public void verifyTableIsVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[contains(@class, 'list view')]/tbody")));
    }

    @And("I print the names of the first 5 odd-numbered account rows")
    public void printOddRows() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'list view')]/tbody/tr"));
        int printed = 0;

        for (int i = 0; i < rows.size() && printed < 5; i++) {
            if ((i + 1) % 2 != 0) {
                try {
                    WebElement nameCell = rows.get(i).findElement(By.xpath(".//td[@field='name']//a"));
                    System.out.println("Odd Row " + (i + 1) + ": " + nameCell.getText());
                    printed++;
                } catch (NoSuchElementException e) {
                    // Skip if no name cell found
                }
            }
        }

        if (printed == 0) {
            System.out.println("No odd-numbered rows available.");
        }
    }

    @And("I print the names of the first 5 even-numbered account rows")
    public void printEvenRows() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'list view')]/tbody/tr"));
        int printed = 0;

        for (int i = 0; i < rows.size() && printed < 5; i++) {
            if ((i + 1) % 2 == 0) {
                try {
                    WebElement nameCell = rows.get(i).findElement(By.xpath(".//td[@field='name']//a"));
                    System.out.println("Even Row " + (i + 1) + ": " + nameCell.getText());
                    printed++;
                } catch (NoSuchElementException e) {
                    // Skip if no name cell found
                }
            }
        }

        if (printed == 0) {
            System.out.println("No even-numbered rows available.");
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
