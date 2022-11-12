package Day9_10292022;

import ReusableClass.reusableMethods;
import org.openqa.selenium.WebDriver;

public class T4_MetLifeReusableMethods {
    public static void main(String[] args) throws InterruptedException {
        //call webdriver method from reusable library
        WebDriver driver = reusableMethods.setUpDriver();
        //navigate to MetLife
        driver.navigate().to("https://www.metLife.com");
        //hover over the solutions dropdown
        //ReusableActions.mouseHover(driver, "//*[contains(text(), 'SOLUTIONS')]", "Solutions Dropdown");
        //or click on solutions dropdown
        reusableMethods.clickActionByIndex(driver, "//*[contains(text(), 'SOLUTIONS')]", 0, "Solutions Link");
        //click on dental link
        reusableMethods.clickAction(driver, "//*[text() = 'Dental']", "Dental Link");
        //capture the headline title
        String headlineTitle = reusableMethods.getTextAction(driver, "//*[@class = 'headline__title']", "Headline Title");
        //print out the title
        System.out.println("The headline title is " + headlineTitle);
        //quit driver
        driver.quit();
    }//end of main

}
