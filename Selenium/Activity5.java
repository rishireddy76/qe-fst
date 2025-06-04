import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity5 {
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/target-practice");
    }

    @Test(groups = { "HeaderTests" })
    public void testThirdHeaderText() {
        WebElement thirdHeader = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals(thirdHeader.getText(), "Heading #3");
    }

    @Test(groups = { "HeaderTests" })
    public void testFifthHeaderColor() {
        WebElement fifthHeader = driver.findElement(By.xpath("//h5"));
        String color = fifthHeader.getCssValue("color");
        Assert.assertEquals(color, "rgb(147, 51, 234)"); 
    }

    @Test(groups = { "ButtonTests" })
    public void testEmeraldButtonText() {
        WebElement emeraldButton = driver.findElement(By.xpath("//button[contains(text(), 'Emerald')]"));
        Assert.assertEquals(emeraldButton.getText(), "Emerald");
    }

    @Test(groups = { "ButtonTests" })
    public void testFirstButtonInThirdRowColor() {
        WebElement button = driver.findElement(By.xpath("(//button)[5]"));
        String color = button.getCssValue("background-color");
        Assert.assertEquals(color, "rgb(253, 230, 138)"); // adjust based on actual value
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
