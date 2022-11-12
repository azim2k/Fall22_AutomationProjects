package Day4_10092022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_WebdriverExample {
    public static void main(String[] args) throws InterruptedException { //throws is for sleep method

        //define webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //define the chrome driver to use for your test
        //creating an instance for a  chrome driver(browser) to use automation
        WebDriver driver  = new ChromeDriver();

        //navigate to the google site
        driver.navigate().to("https://www.google.com");

        //wait a few seconds before closing
        Thread.sleep(3000);
        //close the chrome session
        driver.close();



    }//end of main method

}//end of class
