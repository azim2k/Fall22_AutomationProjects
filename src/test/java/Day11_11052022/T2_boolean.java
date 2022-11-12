package Day11_11052022;

import ReusableClass.reusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T2_boolean {
    WebDriver driver;
    @BeforeSuite
    public void SetChromeDriver() {
        driver = reusableMethods.setUpDriver();
    }//end of set driver method
    @AfterSuite
    public void quitTheSession() {
        driver.quit();
    }//end of after suite

    @Test(priority = 1)
    public void tc001_verifySignedInOptionIsSelected(){
        //navigate to yahoo homepage
        driver.navigate().to("https://www.yahoo.com");
        //next we need to click on sign in button
        reusableMethods.clickAction(driver,"//*[@class= '_yb_1933e']","Sign in button");
        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);

    }//end of test 1
    @Test(dependsOnMethods = "tc001_verifySignedInOptionIsSelected")
    public void tc002_verifySignedInOptionIsUnChecked(){
        //click on check box to uncheck it
        reusableMethods.clickAction(driver,"//*[@class= 'stay-signed-in checkbox-container']","SignedInCheckbox");
        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);

    }//end of test 2

}//end of class

