package Day12_11062022;

import ReusableClass.ReusableAnnotations;
import ReusableClass.reusableMethods_Logger;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

//import static ReusableClass.ReusableAnnotations.driver;

public class T3_YahooExample_Annotation extends ReusableAnnotations {

    @Test(priority = 1)
    public void tc001_verifySignedInOptionIsChecked() throws InterruptedException {
        //first navigate to yahoo homepage
        driver.navigate().to("https://www.yahoo.com/");
        //next we need to click on sign in button
        reusableMethods_Logger.clickAction(driver,"//*[@class = '_yb_1933e']",logger,"Sign In");
        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
        logger.log(LogStatus.INFO,"The checkbox check condition is: " + isSignInChecked);
    }//end of test 1

    @Test(dependsOnMethods = "tc001_verifySignedInOptionIsChecked")
    public void tc002_verifySignedInOptionIsUnChecked() {
        //click on check box to uncheck it
        reusableMethods_Logger.clickAction(driver,"//*[@class= 'stay-signed-in checkbox-container']",logger,"Check Box Unchecked");
        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
        logger.log(LogStatus.INFO,"The checkbox check condition is: " + isSignInChecked);
    }//end of test 2

}
