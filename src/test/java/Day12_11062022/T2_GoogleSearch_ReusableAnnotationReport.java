package Day12_11062022;

import ReusableClass.ReusableAnnotations;
import ReusableClass.reusableMethods_Logger;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class T2_GoogleSearch_ReusableAnnotationReport extends ReusableAnnotations {
    @Test
    public void searchForBmw(){
        driver.navigate().to("https://www.google.com");
        //search for bmw on the search field
        reusableMethods_Logger.sendKeysAction(driver,"//*[@name='q']","BMW",logger,"Search Field");
        //hit submit on google search button
        reusableMethods_Logger.submitAction(driver,"//*[@name='btnK']",logger,"Google Search");
    }//end of test 1

    @Test(dependsOnMethods = "searchForBmw")
    public void captureSearchNumber(){
        //capture the search results text
        String results = reusableMethods_Logger.getTextAction(driver,"//*[@id='result-stats']",logger,"Search Results");
        String[] arrayResult = results.split(" ");
        //print back to html report by using log INFO
        logger.log(LogStatus.INFO,"Search number for BMW is " + arrayResult[1]);
    }//end of test 2

}//end of class
