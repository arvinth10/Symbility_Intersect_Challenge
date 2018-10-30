package signIn;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import signIn.TestSignInButtonVisible_1;;

/*
 * 2. As a User, I should have the ability to sign in to Amazon Test steps: a)
 * Ensure user is logged out of amazon b) Navigate to https://www.amazon.ca c)
 * Notice in top right corner, “Hello. Sign In. Your Account” should be
 * displayed d) Tap “Hello. Sign In. Your Account” button e) Tap Sign In Button
 * f) Sign In w/ credentials
 */


public class TestSignInUser_2 extends Initialize {


  private String name = "Arvinth_SI";
  private String afterSignInURL = "https://www.amazon.ca/?ref_=nav_ya_signin&";


  @Test


  public void testSignToAccount() {
    TestSignInButtonVisible_1 previousTest = new TestSignInButtonVisible_1();
    previousTest.testAtHomePage();
    previousTest.TestUserIsLoggedOutTopNav();
    previousTest.TestUserIsLoggedOutBottomNav();

    WebElement accountSignIn =
        driver.findElement(By.id("nav-link-yourAccount"));
    accountSignIn.click();

    loginHelper();

    assertEquals("Test at home page after sign in", afterSignInURL,
        driver.getCurrentUrl());

    accountSignIn = driver.findElement(By.id("nav-link-yourAccount"));
    WebElement navLine1 = accountSignIn.findElement(By.className("nav-line-1"));

    assertEquals("Check sign in successful", "Hello, " + name,
        navLine1.getText());

  }

}
