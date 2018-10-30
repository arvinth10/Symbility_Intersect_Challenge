package search;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import signIn.TestSignInButtonVisible_1;

/*
 * 3. As a User, I should have the ability to search for an item on Amazon Test
 * steps: a) Navigate to https://www.amazon.ca b) Input “memory card” in the
 * search bar c) Notice results appear for memory
 */

public class TestBasicSearch_3 extends signIn.Initialize {

  private static String searchItem = "memory card";

  @Test
  public void testSearchForItem() {

    TestSignInButtonVisible_1 previousTest = new TestSignInButtonVisible_1();
    previousTest.testAtHomePage();

    searchHelper(searchItem);

    try {

      WebElement searchResults = driver.findElement(By.id("s-result-count"));
      assertTrue("Test " + searchItem + " has search results",
          searchResults.getText().contains("results"));

    } catch (Exception e) {
      fail("No search results");
    }

  }

}
