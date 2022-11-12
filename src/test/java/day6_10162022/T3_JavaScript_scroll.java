package day6_10162022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T3_JavaScript_scroll {
    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with webdrivermanager
//define javascript executor
        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

        // add the options for maximizing the chrome meeting
        // options.addArguments("start-fullscreen") for mac
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.mlcalc.com");
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //scroll down to 800 pixels
        jse.executeScript("scroll(0,800)");
        //wait 2 secs
        Thread.sleep(2000);
        //scroll up to 400 pixels
        jse.executeScript("scroll(0,-400)");
        //wait 2 secs
        Thread.sleep(2000);

        //store calculate button into webelement variable
        WebElement calculateButton = driver.findElement(By.xpath("//*[@value='Calculate']"));
        //scroll into view of calculate button
        jse.executeScript("arguments[0].scrollIntoView(true);", calculateButton);
        //wait 2 secs
        Thread.sleep(2000);
        //quit chrome
        //driver.quit();



    }
}
