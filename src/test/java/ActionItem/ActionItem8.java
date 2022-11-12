package ActionItem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ActionItem8 {
    public static void main(String[] args) throws InterruptedException {
        //create web driver manager
        WebDriverManager.chromedriver().setup();
        //create chrome options
        ChromeOptions options = new ChromeOptions();
        //make option for incognito
        options.addArguments("incognito");
        //make option for max window
        options.addArguments("start-maximized");
        //make a instance of web driver
        WebDriver driver = new ChromeDriver(options);




        //make arraylist of zipcode
        ArrayList<String> zipcodes = new ArrayList<>();
        zipcodes.add("11217");
        zipcodes.add("11216");
        zipcodes.add("11219");

        //make a javascript executor
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //make a loop to iterate through the zipcodes
        for (int i = 0; i < zipcodes.size(); i++) {
            //navigate to the weight watchers website
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
            //wait for 1 second
            Thread.sleep(1000);

            //click on find a workshop
            driver.findElements(By.xpath("//*[text()='Find a Workshop']")).get(0).click();
            //wait 1 seconds
            Thread.sleep(1000);
            //save search bar address in webElement, clear and send the zipcode
            WebElement searchBar = driver.findElement(By.xpath("//*[@id='location-search']"));

            searchBar.clear();
            //wait 1 sec
            Thread.sleep(1000);
            searchBar.sendKeys(zipcodes.get(i));
            //click on the search arrow
            driver.findElement(By.xpath("//*[@id='location-search-cta']")).click();
            Thread.sleep(2000);
            //scroll to the addresses
            jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElements(By.xpath("//*[contains(@class,'filterSegment')]")).get(2));
            //store the addresses of the location address elements inside webelement arraylist variable
            ArrayList<WebElement> locations = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[contains(@class,'wrapperLink')]"));

            if (i == 0) {
                locations.get(1).click();
            } else if (i == 1) {
                jse.executeScript("arguments[0].scrollIntoView(true);", locations.get(1));
                locations.get(2).click();
            } else if (i == 2) {
                locations.get(1).click();
            }
            //get the entire address of the lication
            String address = driver.findElements(By.xpath("//*[contains(@class,'address')]")).get(1).getText();
            //split the address by each line using \\R in split
            String[] addressSplits = address.split("\n");
            System.out.println("The address for " + zipcodes.get(i) + " is:");
            //print out only the first and second line or indexes in the array
            System.out.println(addressSplits[0] + "\n" + addressSplits[1]);
            //scroll to see the location schedule
            jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElements(By.xpath("//*[contains(@class,'title')]")).get(1));
            //capture the schedule
            String schedule = driver.findElement(By.xpath("//*[contains(@class,'scheduleContainer')]")).getText();
            System.out.println("The schedule of this address is:");
            //print out the schedule
            System.out.println(schedule);
            System.out.println();


        }//end of loop

        //quit the driver
        driver.quit();

    }//end of main

}//end of class
