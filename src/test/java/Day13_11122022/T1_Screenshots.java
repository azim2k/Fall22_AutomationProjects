package Day13_11122022;

import ReusableClass.ReusableAnnotations;
import ReusableClass.reusableMethods_Logger;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class T1_Screenshots extends ReusableAnnotations {
    @Test(priority = 1)
    public void tc001_verifySignedInOptionIsChecked() throws InterruptedException {
        //first navigate to yahoo homepage
        driver.navigate().to("https://www.yahoo.com/");
        //next we need to click on sign in button
        reusableMethods_Logger.clickAction(driver,"//*[@class = '_yb_1933e123']",logger,"Sign In");
        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
        logger.log(LogStatus.INFO,"The checkbox check condition is: " + isSignInChecked);
    }//end of test 1
}
