package addToCart;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import search.TestBasicSearch_3;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestSingleItemToCart extends signIn.Initialize{

  
  private String itemToAdd = "Sandisk Ultra 32GB Class 10 SDHC UHS-I Memory Card Up to " + 
      "80MB, Grey/Black (SDSDUNC-032G-GN6IN)"; 
  
  @Test
  public void test() {
    
    try{
      TestBasicSearch_3.testSearchForItem();
      
      WebElement item = driver.findElement(By.xpath("//*[@data-attribute=\'" + itemToAdd + "\']"));
      item.click();
      

        TimeUnit.SECONDS.sleep(10);

    }catch(Exception e){
      fail(e.toString());
    }


  
  }

}
