import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/*
1. As a User, I should be presented with Sign In button CTA, when I navigate to Amazon Test steps:
a) Ensure user is logged out of amazon
b) Navigate to  https://www.amazon.ca
c) Notice in top right corner, “Hello. Sign In. Your Account” should be displayed
 */

public class TestSignInButton_1 {
  
  private static WebDriver driver;

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "chromedriver"); 
    driver  = new ChromeDriver(); 
    driver.get ("https://www.amazon.ca/");
  }

  @Test
  public void testSignInMessage() {
    WebElement account = driver.findElement(By.id("nav-link-yourAccount")); 
    WebElement navLine1 = account.findElement(By.className("nav-line-1"));
    WebElement navLine2 = account.findElement(By.className("nav-line-2")); 
    
    
   // navLine1.click();
    assertEquals("Test Hello. Sign in", "Hello. Sign in", navLine1.getText()); 
    assertEquals("Test Your Account", "Your Account", navLine2.getText()); 
  }
  
  @Test
  public void testSignInButtonAppears(){
    WebElement account = driver.findElement(By.id("nav-link-yourAccount")); 
    WebElement navLine1 = account.findElement(By.className("nav-line-1"));
    
    Actions mouse = new Actions(driver); 
    mouse.moveToElement(navLine1); 
    
    WebElement flyOutSignIn = driver.findElement(By.className("nav-signin-tt"));
    
    assertEquals("Test Sign In Button Shown", true, flyOutSignIn.isDisplayed());
  }
  
  @After
  public void tearDown(){
    driver.quit();
    
  }

}
