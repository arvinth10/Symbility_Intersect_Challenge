package signIn;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Initialize {
  protected static WebDriver driver;
  protected static WebElement accountSignIn;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    System.setProperty("webdriver.chrome.driver", "chromedriver"); 
    driver  = new ChromeDriver(); 
    driver.get ("https://www.amazon.ca/");
    accountSignIn = driver.findElement(By.id("nav-link-yourAccount")); 
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    driver.quit();
  }
  



}
