package Day10_10302022;

import ReusableClass.reusableMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T3_dependsOnMethod {
    WebDriver driver;
    @BeforeSuite
    public void SetChromeDriver(){
        driver = reusableMethods.setUpDriver();
    }//end of set driver method

    @AfterSuite
    public void quitTheSession(){
        driver.quit();
    }//end of after suite

    @Test()
    public void SearchForCar(){
        driver.navigate().to("https://www.google.com");
        //enter a car on search field
        reusableMethods.sendKeysAction(driver,"//*[@name='q']","BMW","Search Field");
        //hit submit on the google search button
        reusableMethods.submitAction(driver,"//*[@name='btnK']","Google Search Button");
    }//end of test 1

    @Test(dependsOnMethods = "SearchForCar")
    public void CaptureSearchNumber(){
        String result = reusableMethods.getTextAction(driver,"//*[@id='result-stats']","Search Results");
        String[] arrayResult = result.split(" ");
        System.out.println("Result is " + arrayResult[1]);
    }//end of test 2

}
