package day6_10162022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_FindElements{
    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the chrome window
        options.addArguments("start-maximized", "incognito");
//        options.addArguments("headless");
        //for mac use "start-fullscreen"
//        options.addArguments("start-fullscreen");
        //define the webdriver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);
        //go to yahoo page
        driver.navigate().to("https://www.yahoo.com");

        Thread.sleep(3000);
        /*
        When we have multiple elements with the same attribute name such as class name or text, we can use
        findElements with a s instead of findElement to go through the index of the elements to click on a specific one.
        This is a last resort if you cannot find a unique attribute for the elements or you want to iterate though the elements
         */
        //in the example below the code will click on news becaus eits the second element index 1 of the lists of elements with that class name
        //The reason we used contains because the class name had a space at the end and we don't want to use space
        //driver.findElements(By.xpath("//*[contains(@class,'_yb_sc88r')]")).get(1).click();
        driver.findElements(By.xpath("//*[contains(@class,'_yb_sc88r')]")).get(3).click();
        driver.quit();

    }
}
