package stepDefinitons;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import org.testng.Assert;

public class LoginSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("the user is on the login page")
    public void openLoginPage() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://alchemy.hguy.co/crm/");
    }

    @When("the user logs in with username {string} and password {string}")
    public void loginWithCredentials(String username, String password) {
        driver.findElement(By.id("user_name")).sendKeys(username);
        driver.findElement(By.id("username_password")).sendKeys(password);
        driver.findElement(By.id("bigbutton")).click();
    }

    @Then("the login result should be {string}")
    public void checkLoginResult(String expectedResult) {
        if (expectedResult.equalsIgnoreCase("success")) {
            WebElement toolbar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toolbar")));
            Assert.assertTrue(toolbar.isDisplayed(), "Expected successful login, but it failed.");
            System.out.println("Login successful. Toolbar is displayed.");
        } else if (expectedResult.equalsIgnoreCase("failure")) {
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.error:nth-child(4)")));
            Assert.assertTrue(error.isDisplayed(), "Expected failure message, but it was not found.");
            String errorMsg = error.getText().trim();
            System.out.println("Login failed. Error message displayed: " + errorMsg);
        } else {
            System.out.println("Unexpected result type provided: " + expectedResult);
            Assert.fail("Invalid expected result value: " + expectedResult);
        }
        driver.quit();
    }
}

    

