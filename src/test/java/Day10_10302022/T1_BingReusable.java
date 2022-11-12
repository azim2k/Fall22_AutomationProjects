package Day10_10302022;

import ReusableClass.reusableMethods;
import org.openqa.selenium.WebDriver;

public class T1_BingReusable {
    public static void main(String[] args) {

        //calling reusable method for set driver
        WebDriver driver = reusableMethods.setUpDriver();

        //navigate
        driver.navigate().to("https://www.bing.com");

        //enter a keyword in search field using reusable method
        reusableMethods.sendKeysAction(driver,"//*[@name='q']","soccer","Search Field");

        //click on search icon using reusable method
        reusableMethods.clickAction(driver,"//*[@id='search_icon']","Search Icon");

        //capture the result and extract out the number
        String result = reusableMethods.getTextAction(driver,"//*[@class='sb_count']","Search Results");
        System.out.println("Result is " + result);

    }//end of main

}
