package Day7_10222022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_Select_statement {
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
        driver.navigate().to("https://www.mlcalc");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*'[text()='Show advanced options']")).click();
        Thread.sleep(1000);

        /*
        We use select class
         */
        WebElement srtMonth = driver.findElement(By.xpath("//*[@name='sm']"));
        Select startMonthDropdown = new Select(srtMonth);
        startMonthDropdown.selectByVisibleText("Nov");

        /*
        WebElement srtYear = driver.findElement(By.xpath("//*[@name='sy']"));
        Select startYearDropdown = new Select(srtYear);
        startMonthDropdown.selectByVisibleText("2023");

         */
        //use click method for year
        driver.findElement(By.xpath("//*[@name='sy']")).click();
        driver.findElement(By.xpath("//*[text()='2023']")).click();

    }

}
