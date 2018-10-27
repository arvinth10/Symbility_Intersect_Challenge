package signIn;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import signIn.TestSignInButtonVisible_1;; 

/*
2. As a User, I should have the ability to sign in to Amazon Test steps:
a) Ensure user is logged out of amazon
b) Navigate to  https://www.amazon.ca
c) Notice in top right corner, “Hello. Sign In. Your Account” should be displayed
d) Tap “Hello. Sign In. Your Account” button
e) Tap Sign In Button
f) Sign In w/ credentials
 */



public class TestSignInUser_2 extends Initialize{
  
  
  private String name = "Arvinth_SI"; 
  private String email = "testSI@gmail.com"; 
  private String password = "SI_Challenge"; 
  


  @Test
  public void testSignToAccount() {
    
    TestSignInButtonVisible_1.testEnsureUserIsLoggedOut(); 
    accountSignIn.click();
    WebElement usernameEle = driver.findElement(By.id("ap_email")); 
    WebElement passwordEle = driver.findElement(By.id("ap_password"));
    WebElement signInEle = driver.findElement(By.id("signInSubmit"));

    
    usernameEle.sendKeys(email); 
    passwordEle.sendKeys(password);
    signInEle.click();
    
    accountSignIn = driver.findElement(By.id("nav-link-yourAccount")); 

    
    WebElement navLine1 = accountSignIn.findElement(By.className("nav-line-1"));

    
    assertEquals ("Check sign in successful", "Hello, " + name, navLine1.getText()); 
    
    
//    
//    try {
//      TimeUnit.SECONDS.sleep(10);
//    } catch (InterruptedException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }  
//    
    
    }

}
