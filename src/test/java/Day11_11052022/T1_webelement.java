package Day11_11052022;

import ReusableClass.reusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class T1_webelement {
    WebDriver driver;

    ArrayList<WebElement> totalMenuHeaders, mainMenuHeaders;

    @BeforeSuite
    public void SetChromeDriver() {
        driver = reusableMethods.setUpDriver();
        //navigate to website
        driver.navigate().to("https://www.usps.com");
        //store all the elements of the menu header into an arraylist of webelements
        totalMenuHeaders = new ArrayList<>(driver.findElements(By.xpath("//*[@class = 'nav-list']/li")));
    }//end of set driver method

    @AfterSuite
    public void quitTheSession() {
        driver.quit();
    }//end of after suite

    // Test Case 1 should verify the total count of the displayed menu headers
    @Test(priority = 1)
    public void tc001_verifyTotalCountOfMenuHeaders() {
        driver.navigate().to("https://www.usps.com");
        //store all the elements of the menu header into an arraylist of webelements
        totalMenuHeaders = new ArrayList<>(driver.findElements(By.xpath("//*[@class = 'nav-list']/li")));
        System.out.println("The total number of menu headers is: " + totalMenuHeaders.size());
    }//end of test 1

    @Test(priority = 2)
    public void tc002_clickOnFirstDropDown() {
        totalMenuHeaders.get(0).click();

    }//end of test 2


    @Test(priority = 3)
    public void tc003_verifyCountOfMainHeaders() {
        mainMenuHeaders = new ArrayList<>(driver.findElements(By.xpath("//*[@class = 'menuheader']")));
        System.out.println("The total number of main menu headers is: " + mainMenuHeaders.size());

    }//end of test 3
}
