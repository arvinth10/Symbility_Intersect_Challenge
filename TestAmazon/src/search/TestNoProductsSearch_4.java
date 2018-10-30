package search;

import static org.junit.Assert.*;
import org.openqa.selenium.NoSuchElementException;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import signIn.TestSignInButtonVisible_1;

/*
 * 4. As a User, I should be presented with a no products found search screen,
 * when attempting to search for an item that doesn’t exist, on Amazon Test
 * steps: a) Navigate to https://www.amazon.ca b) Input “[alpja]” in the search
 * bar c) Notice “Your search "[alpja]" did not match any products.” text and no
 * results are displayed.
 */


public class TestNoProductsSearch_4 extends signIn.Initialize {

  private String searchItem = "[alpja]";

  @Test(expected = NoSuchElementException.class)
  public void testSearchForItemNotFound() {
    TestSignInButtonVisible_1 previousTest = new TestSignInButtonVisible_1();
    previousTest.testAtHomePage();

    searchHelper(searchItem);

    WebElement noProductsText = driver.findElement((By.id("noResultsTitle")));

    String elementText = noProductsText.getText();

    assertEquals("Test correct no products message",
        "Your search \"" + searchItem + "\" did not match any products.",
        elementText);

    @SuppressWarnings("unused")
    WebElement searchResults = driver.findElement(By.id("s-result-count"));

  }

}
