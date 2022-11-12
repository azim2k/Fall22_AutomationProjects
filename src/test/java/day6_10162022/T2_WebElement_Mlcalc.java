package day6_10162022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_WebElement_Mlcalc {
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
        //go to mlcalc page
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(3000);

        /*
        We can create a WebElement variable for a element that will be reused for multiple functionalities
        for example clearing a text field and entering new value, so we would have to use the element twice
        and that's where it's helpful to use a variable, so we don't have to keep on locating the element via xpath
         */

        //create a webelement variable for the pruchaseprice element
        WebElement purchasePrice = driver.findElement(By.xpath("//*[@name='ma']"));
        purchasePrice.clear();
        purchasePrice.sendKeys("45000");

        //create a webelement variable for the down payment percentage
        WebElement downPayment = driver.findElement(By.xpath("//*[@name='dp']"));
        downPayment.clear();
        downPayment.sendKeys("25");

    }
}
