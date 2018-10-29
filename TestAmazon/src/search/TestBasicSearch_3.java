package search;

import static org.junit.Assert.*;

import org.openqa.selenium.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.junit.rules.ExpectedException;


public class TestBasicSearch_3 extends signIn.Initialize{
  
  private static String searchItem = "memory card"; 
  

  @Test
  public static void testSearchForItem() {
    
    try{
      
      WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
      
      searchBar.sendKeys(searchItem, Keys.RETURN);
      
      WebElement searchResults = driver.findElement(By.id("s-result-count"));
            
      assertTrue("Test has search results", searchResults.getText().contains("results")); 
      
      
    }catch(Exception e){
      fail(e.toString());
    }
    
    
  }

}
