package Day5_10152022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_XpathTextContains {

    public static void main(String[] args) throws InterruptedException {
        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver();

        //navigate to the yahoo site
        driver.navigate().to("https://www.yahoo.com");

        //maximize my window
        //for windows we can use maximize or fullscreen
        driver.manage().window().maximize();


        //sleep statement
        Thread.sleep(2000);

        //search a keyword on the search field
        //relative xpath to locate the element
        /*
        in this case we're using a text xpath because sometimes we may not have a id or name or any other
        unique attribute, so we can look for a unique text in the element and find it.
         */
        driver.findElement(By.xpath("//*[text()='Sign in']")).click();
        Thread.sleep(2000);

        //back to yahoo home page
        driver.navigate().to("https://www.yahoo.com");
        /*
        sometimes the id or name might be too long or might contain undesired characters such as spaces so we can
        tell the program to look at the attributes partially via the contains method so it will look at the element
        and compare the value we told the program to look for. This is also useful for attributes that changes partially like the
        ending of the class or name, but the beginning of it is constant.
         */
        //click on bell icon
        driver.findElement(By.xpath("//*[contains(@class,'rapid-nonanchor')]")).click();

        Thread.sleep(2000);
        driver.quit();

    }
}
