package search;

import static org.junit.Assert.*;
import org.openqa.selenium.NoSuchElementException;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.junit.rules.ExpectedException;


public class TestNoProductsSearch_4 extends signIn.Initialize{
  
  private String searchItem = "[alpja]"; 
  
  @Rule
  public ExpectedException thrown= ExpectedException.none();

  @Test
  public void testSearchForItem() {
    
    try{
      
      WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
      
      searchBar.sendKeys(searchItem, Keys.RETURN);
      
      WebElement noProductsText = driver.findElement((By.id("noResultsTitle")));
      
      String elementText = noProductsText.getText();
      
      assertEquals("Test correct no products message", "Your search \"" + searchItem + "\" did not match any products.", elementText); 
            
      
    }catch(Exception e){
      fail(e.toString());
    }
    
    thrown.expect(NoSuchElementException.class);
    @SuppressWarnings("unused")
    WebElement searchResults = driver.findElement(By.id("s-result-count"));

    
    
  }

}
