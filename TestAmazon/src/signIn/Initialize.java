package signIn;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Initialize {
  protected static WebDriver driver;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    System.setProperty("webdriver.chrome.driver", "chromedriver"); 
    driver  = new ChromeDriver(); 
    driver.get ("https://www.amazon.ca/");
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    driver.quit();
  }
  



}
