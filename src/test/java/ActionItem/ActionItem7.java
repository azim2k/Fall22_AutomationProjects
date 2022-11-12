package ActionItem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class ActionItem7 {
    public static void main(String[] args) throws InterruptedException {
        //Arraylist of sports
        ArrayList<String> sports = new ArrayList<>();
        sports.add("Soccer");
        sports.add("Basketball");
        sports.add("Hockey");
        sports.add("Cricket");

        //setting up a WebDriver manager for chrome
        WebDriverManager.chromedriver().setup();
        //making an instance of the chrome driver class.
        WebDriver driver = new ChromeDriver();

        //for loop to iterate through the ArrayList
        for(int i =0; i<sports.size();i++) {
            //naviagte to bing.com
            driver.navigate().to("https://www.bing.com/");
            //maximize the window
            driver.manage().window().maximize();
            //wait 3 seconds before resuming automation
            Thread.sleep(3000);
            //find the search box element via xpath and sending in ArrayList value
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(sports.get(i));
            //find the search icon element via xpath and submitting
            driver.findElement(By.xpath("//*[@id='search_icon']")).submit();
            //waiting 2 seconds to load
            Thread.sleep(2000);

            //storing the search result in  a string
            String result = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
            //splitting the result into a string array
            String[] searchNum = result.split(" ");
            //outputting the first index in the array
            System.out.println("The search number for " + sports.get(i) + " is " + searchNum[0]);

        }//end of for loop
        //closing this instance of the driver
        driver.quit();

    }//end of main

}//end of class
