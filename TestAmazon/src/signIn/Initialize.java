package signIn;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Initialize {
  protected static WebDriver driver;

  protected static String homeURL = "https://www.amazon.ca/";
  protected static String email = "testSI@gmail.com";
  protected static String password = "SI_Challenge";

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    System.setProperty("webdriver.chrome.driver", "chromedriver");
    driver = new ChromeDriver();
    driver.get(homeURL);
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    driver.quit();
  }

  public static void loginHelper() {
    assertEquals("Test at sign in page", "Amazon Sign In", driver.getTitle());

    WebElement usernameEle = driver.findElement(By.id("ap_email"));
    WebElement passwordEle = driver.findElement(By.id("ap_password"));
    WebElement signInEle = driver.findElement(By.id("signInSubmit"));

    usernameEle.sendKeys(email);
    passwordEle.sendKeys(password);

    signInEle.click();

  }

  public static void searchHelper(String searchItem) {

    WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));

    searchBar.sendKeys(searchItem, Keys.RETURN);

    assertEquals("Test correct search page loaded", "Amazon.ca: " + searchItem,
        driver.getTitle());

  }



}
