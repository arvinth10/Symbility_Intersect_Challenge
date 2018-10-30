package addToCart;

import static org.junit.Assert.*;

import search.TestBasicSearch_3;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
 * 5. As a User, I can proceed to checkout, after I’ve added an item to my cart
 * from search Test steps: a) Navigate to https://www.amazon.ca b) Input “memory
 * card” in the search bar c) Tap on the “Sandisk Ultra 32GB Class 10 SDHC UHS-I
 * Memory Card Up to 80MB, Grey/Black (SDSDUNC-032G-GN6IN)” memory card d) Tap
 * the add to cart button e) Tap the proceed to checkout button f) Sign-in w/
 * credentials g) User should be taken to create shipping address screen.
 */

public class TestSingleItemToCart_5 extends signIn.Initialize {

  private String itemToAdd =
      "Sandisk Ultra 32GB Class 10 SDHC UHS-I Memory Card Up to "
          + "80MB, Grey/Black (SDSDUNC-032G-GN6IN)";

  @Test
  public void testAddItemToCart() {

    TestBasicSearch_3 previousTest = new TestBasicSearch_3();
    previousTest.testSearchForItem();

    try {
      WebElement item = driver
          .findElement(By.xpath("//*[@data-attribute=\'" + itemToAdd + "\']"));
      item.click();
    } catch (Exception e) {
      fail("Item is not found in search results");
    }

    WebElement addToCart = driver.findElement(By.id("submit.add-to-cart"));
    addToCart.click();
    assertEquals("Test at added to cart page", "Amazon.ca Shopping Cart",
        driver.getTitle());

    try {
      WebElement checkAddedtoCart =
          driver.findElement(By.id("huc-v2-order-row-confirm-text"));
      String confirmation = checkAddedtoCart.getText();
      assertEquals("Item added to cart test", "Added to Cart", confirmation);
    } catch (Exception e) {
      fail("Item not successfully added to cart");
    }

    WebElement proceed = driver.findElement(By.id("hlb-ptc-btn-native"));
    proceed.click();

    loginHelper();

    assertEquals("Test at create shipping address page",
        "Enter the shipping address for this order", driver.getTitle());

  }

}
