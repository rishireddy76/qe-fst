
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.SkipException;
import org.testng.Assert;
import org.openqa.selenium.By;

public class Activity2Test {
	WebDriver driver;
  
	@BeforeClass
	 public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/target-practice/");
     
    }
@Test 
public void testTitle() {
    // Get the title and assert
    String title = driver.getTitle();
    System.out.println(driver.getTitle());
    Assert.assertEquals(title, "Selenium: Target Practice");
}
@Test
public void testBlackButton() {
   
    String buttonText = driver.findElement(By.xpath("//button[text()='Slate']")).getText();
    Assert.assertEquals(buttonText, "White"); // Intentionally incorrect
}

@Test(enabled = false)
public void skippedTest1() {
    
    System.out.println("This test is disabled and will not run.");
}

@Test
public void skippedTest2() {
   
    throw new SkipException("Skipping this test explicitly");
}

@AfterClass
public void tearDown() {
    driver.close();
}
}
