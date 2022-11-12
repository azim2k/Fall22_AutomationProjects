package Day8_10232022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class T2_parcticeActionItem {
    public static void main(String[] args) throws InterruptedException {
        //setup webdriver manager for chromedriver
        WebDriverManager.chromedriver().setup();

        //setup chrome options
        ChromeOptions options = new ChromeOptions();

        //add chrome options
        options.addArguments("start-maximized", "incognito");

        //setup webdriver
        WebDriver driver = new ChromeDriver(options);
        //Declare and initialize location arraylist and add locations
        ArrayList<String> locations = new ArrayList<>();
        locations.add("Los Angeles");
        locations.add("Miami");
        locations.add("Dallas");
        //Declare and initialize child age arraylist and add age
        ArrayList<String> childAge = new ArrayList<>();
        childAge.add("12");
        childAge.add("14");
        childAge.add("2");
        //make a javascript executor
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        for (int i = 0; i < locations.size(); i++) {
            //navigate to hotels.com
            try {
                driver.navigate().to("https://www.hotels.com/");
            } catch (Exception e) {
                System.out.println("Unable to go to hotels.com " + e);
            }
            Thread.sleep(2500);
            //send location to the going to field
            try {
                driver.findElement(By.xpath("//*[@class='uitk-fake-input uitk-form-field-trigger']")).click();
                driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(locations.get(i));
                driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(Keys.ENTER);

                Thread.sleep(1000);
                //driver.findElements(By.xpath("//*[@data-stid='destination_form_field-result-item']")).get(0).click();
            } catch (Exception e) {
                System.out.println("Unable to send location to the search field " + e);
            }
            //click on travelers section
            try {
                driver.findElement(By.xpath("//*[@data-stid='open-room-picker']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on travelers option " + e);
            }
            //wait a few seconds
            Thread.sleep(1500);
            //store the location of the plus minus button in travelers
            ArrayList<WebElement> plusMinusButton = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-step-input-button']")));
            try {
                plusMinusButton.get(0).click();
            } catch (Exception e) {
                System.out.println("Unable to click on minus button for adults " + e);
            }
            //loop to add more adults
            for (int j = 0; j < i + 1; j++) {
                try {
                    plusMinusButton.get(1).click();
                } catch (Exception e) {
                    System.out.println("Unable to click button for adults " + e);
                }
            }//end of j loop
            //loop to add one child
            try {
                plusMinusButton.get(3).click();
            } catch (Exception e) {
                System.out.println("Unable to add child " + e);
            }
            //select childs age
            try {
                WebElement ageSelector = driver.findElement(By.xpath("//*[contains(@id,'age-traveler_selector')]"));
                Select childAgeDropdown = new Select(ageSelector);
                childAgeDropdown.selectByValue(childAge.get(i));
            } catch (Exception e) {
                System.out.println("Unable to select age " + e);
            }
            //click done
            try {
                driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on done button " + e);
            }
            //click on search icon
            try {
                driver.findElement(By.xpath("//*[@id='submit_button']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on search icon " + e);
            }
            //wait 1.5 sec
            Thread.sleep(1500);
            //scroll to the resort listings
            jse.executeScript("scroll(0,300)");
            //make arrayList of the resort list element
            ArrayList<WebElement> resortLinks = new ArrayList<>();
            //store the resort links inside the arraylist
            try {
                resortLinks = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-spacing uitk-spacing-margin-blockstart-three']")));
            } catch (Exception e) {
                System.out.println("Unable to find the resort link " + e);
            }
            //click on the respective resort link
            if (i == 0) {
                resortLinks.get(0).click();
            } else if (i == 1) {
                resortLinks.get(2).click();
            } else if (i == 2) {
                resortLinks.get(1).click();
            }
            //capture the tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to 2nd tab
            try {
                driver.switchTo().window(tabs.get(1));
            } catch (Exception e) {
                System.out.println("Unable to switch tab " + e);
            }
            //wait 3 sec
            Thread.sleep(8000);
            //Capture the resort name
            String resortName = "";
            try {
                resortName = driver.findElement(By.xpath("//*[@data-stid='content-hotel-title']/h1")).getText();
            } catch (Exception e) {
                System.out.println("Unable to capture resort name " + e);
            }
            System.out.println("The resort name is: " + resortName);
            //click on reserve now button
            try {
                driver.findElement(By.xpath("//*[contains(@class,'uitk-spacing uitk-spacing-padding-inlineend-three')]")).click();

            } catch (Exception e) {
                System.out.println("Unable to click on reserve now button " + e);
            }
            //get the first price
            String price = "";
            try {
                price = driver.findElements(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).get(0).getText();
            } catch (Exception e) {
                System.out.println("Unable to get the price " + e);
            }
            //print price
            System.out.println("The price is " + price);
            //click on reserve button
            try {
                driver.findElements(By.xpath("//*[@data-stid='submit-hotel-reserve']")).get(0).click();
            } catch (Exception e) {
                System.out.println("Unable to click on reserve " + e);
            }
            //Wait 3 sec
            Thread.sleep(3000);
            //get the dates
            //*[@class='travel-details w-full table-bc-s ph-base mt-mouse mb-tiny']
            try {
                String dates = driver.findElement(By.xpath("//*[@class='travel-details w-full table-bc-s ph-base mt-mouse mb-tiny']")).getText();
                String[] splitDates = dates.split("\n");
                System.out.println(splitDates[0] + " " + splitDates[1] + "\n" + splitDates[2] + " " + splitDates[3]);
                System.out.println();
            } catch (Exception e) {
                System.out.println("Unable to get the dates " + e);
            }
            //close current tab
            driver.close();
            //switch to the first tab
            driver.switchTo().window(tabs.get(0));

        }//end of i for loop
        driver.quit();

    }//end of main
}//end of class