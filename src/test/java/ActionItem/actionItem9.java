package ActionItem;

import ReusableClass.reusableMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class actionItem9 {
    WebDriver driver;

    @BeforeSuite
    public void setChromeDriver() {

        driver = reusableMethods.setUpDriver();
    }//end of set up driver method

    @AfterSuite
    public void quitTheSession() {
        driver.quit();
    }//end of the after suite

    @Test()
    public void findADoctor() throws InterruptedException {
        //navigate to the website
        driver.navigate().to("https://www.uhc.com/");
        //wait a bit
        //Thread.sleep(2000);
        //click on find a doctor
        reusableMethods.clickAction(driver, "//*[@aria-label='Find a doctor']", "Find a doctor");
        //Thread.sleep(1000);
        //clicking no on pop up
        reusableMethods.clickAction(driver, "//*[@id='ip-no']", "clickPopUp");
        // Thread.sleep(3000);
        //scroll to view find a doctor
        reusableMethods.scrollByViewAction(driver, "//*[@id= 'main-content']", 0, "Main Content");
        //Thread.sleep(3000);
        // click on find a dentist
        reusableMethods.clickAction(driver, "//*[text()='Find a dentist']", "Find a Dentist");
        //Thread.sleep(3000);
        //switch tabs
        reusableMethods.switchToTabsAction(driver, 1);
        Thread.sleep(2000);
        driver.navigate().refresh();
        // refresh the website
        //driver.navigate().refresh();
        //click on employer and individual plan
        reusableMethods.clickAction(driver, "//*[text()='Employer and Individual Plans']", "Employer and Individual Plans");
        //Thread.sleep(3000);
        // refresh website
        // driver.navigate().refresh();
    } // end of test 1

    @Test(dependsOnMethods = "findADoctor")
    public void zipCode() throws InterruptedException {
        //input zipcode
        reusableMethods.sendKeysAction(driver, "//*[@id= 'location']", "11354", "Zip Code");
        // wait a sec
        Thread.sleep(2000);
        //click submit
        reusableMethods.clickAction(driver, "//*[@type='submit']", "Submit");
        Thread.sleep(3000);
        //click on National Options
        reusableMethods.clickActionByIndex(driver, "//*[text()='*National Options PPO 30']",0, "National Options");
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        reusableMethods.scrollByViewAction(driver,"//*[@class='searchBox textBaseSearch search-mode']",0,"searchbar");
        // click on general dentist
        reusableMethods.clickAction(driver, "//*[@id='nodeDescription1']", "general dentist");
        //Thread.sleep(5000);
    }// end of test 2

    @Test(dependsOnMethods = "zipCode")
    public void menu() {
        driver.navigate().refresh();
        //select a different mileage
        reusableMethods.selectByTextAction(driver, "//*[@id='distance']", 0, "Within 50 Miles", "miles dropdown on general dentist page ");
        //class="radiusMiles ng-valid ng-not-empty ng-touched ng-dirty ng-valid-parse ally-focus-within"
        //click on first doctor
        reusableMethods.clickActionByIndex(driver, "//*[@data-test-id='provider-name-link']", 0, "First Doctor");
        //click on save button
        reusableMethods.clickActionByIndex(driver, "//*[@data-test-id='saved-provider-button']", 0, "Save button");
        //capture address, miles, & network type
        String info = reusableMethods.getTextAction(driver, "//*[@class='outer-container tbl']", "Address, Miles, & Network Type");
        //print out information
        System.out.println(info);
        //close out the tab
        driver.close();
    }//test 3

    @Test(dependsOnMethods = "menu")
    public void doctor() throws InterruptedException {
        //switch back to default tab
        reusableMethods.switchToTabsAction(driver, 0);
        //navigate back to website
        driver.navigate().to("https://www.uhc.com/");
        Thread.sleep(1000);
        //enter keyword doctor on the search field
        reusableMethods.sendKeysAction(driver, "//*[@id='search-desktop']", "Doctor", "Search Doctor");
        // click submit on the search
        reusableMethods.clickAction(driver, "//*[@id='search__button-desktop']", "submit icon");
        //capture search results
        String searchResult = reusableMethods.getTextAction(driver, "//*[@id='search-results-count__header']", "Search Results");

        String[] arrayMessage = searchResult.split(" ");
        System.out.println(arrayMessage[0] + arrayMessage[1] + arrayMessage[2]);
    }// end of test 4


}//end of class
