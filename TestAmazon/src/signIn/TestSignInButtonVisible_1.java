package signIn;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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

public class TestSignInButtonVisible_1 {
  
  protected static WebDriver driver;
  protected static WebElement accountSignIn;
  
//
//  @BeforeClass
//  public static void setUpBeforeClass() throws Exception {
//    System.setProperty("webdriver.chrome.driver", "chromedriver"); 
//    driver  = new ChromeDriver(); 
//  }
  
  @Before
  public void setUp(){
    System.setProperty("webdriver.chrome.driver", "chromedriver"); 
    driver  = new ChromeDriver(); 
    driver.get ("https://www.amazon.ca/");
    accountSignIn = driver.findElement(By.id("nav-link-yourAccount")); 
    
  }

  @Test
  public void testSignInMessage() {
    WebElement navLine1 = accountSignIn.findElement(By.className("nav-line-1"));
    WebElement navLine2 = accountSignIn.findElement(By.className("nav-line-2")); 
    

    assertEquals("Test Hello. Sign in", "Hello. Sign in", navLine1.getText()); 
    assertEquals("Test Your Account", "Your Account", navLine2.getText()); 
  }
  
  @Test
  public void testSignInButtonAppears() throws InterruptedException{
    WebElement flyOutSignIn = driver.findElement(By.className("nav-signin-tt"));

    assertEquals("Test Sign In Button Shown", true, flyOutSignIn.isDisplayed());

//    TimeUnit.SECONDS.sleep(10);    
//    
//    assertEquals("Test Sign In Button Shown", false, flyOutSignIn.isDisplayed());
  }
  
  @After
  public void tearDown(){
    driver.quit();
    
  }

}