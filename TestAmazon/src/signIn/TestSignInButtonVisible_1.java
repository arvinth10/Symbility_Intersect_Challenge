package signIn;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
 * 1. As a User, I should be presented with Sign In button CTA, when I navigate
 * to Amazon Test steps: a) Ensure user is logged out of amazon b) Navigate to
 * https://www.amazon.ca c) Notice in top right corner, “Hello. Sign In. Your
 * Account” should be displayed
 */

public class TestSignInButtonVisible_1 extends Initialize {

  private WebElement accountSignIn;

  @Test
  public void testAtHomePage() {
    assertEquals("Test home page loaded", homeURL, driver.getCurrentUrl());
  }

  @Test
  public void TestUserIsLoggedOutTopNav() {
    accountSignIn = driver.findElement(By.id("nav-link-yourAccount"));

    WebElement navLine1 = accountSignIn.findElement(By.className("nav-line-1"));

    assertEquals("Test Hello. Sign in", "Hello. Sign in", navLine1.getText());
  }

  @Test
  public void TestUserIsLoggedOutBottomNav() {
    accountSignIn = driver.findElement(By.id("nav-link-yourAccount"));

    WebElement navLine2 = accountSignIn.findElement(By.className("nav-line-2"));

    assertEquals("Test Your Account", "Your Account", navLine2.getText());
  }

  @Test
  public void testSignInButtonAppears() {
    WebElement flyOutSignIn = driver.findElement(By.className("nav-signin-tt"));

    assertEquals("Test Sign In Button Shown", true, flyOutSignIn.isDisplayed());
  }
}
