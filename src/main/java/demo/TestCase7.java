package demo;

import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;
import java.util.*;

//import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class TestCase7 {
    ChromeDriver driver;
    
      
    public void testCase_7(){
        this.driver=TestCases.TestCases();
        //Launch Chrome
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        //switch to top frame
        driver.switchTo().frame("frame-top");
        //switch to left frame
       driver.switchTo().frame("frame-left");
       //driver.findElement(null)
        //WebElement leftframe = driver.findElement(By.tagName("body"));
        //String left = leftframe.getText();
       String left= driver.findElement(By.tagName("body")).getText();
        System.out.println(left);


       driver.switchTo().parentFrame();
       driver.switchTo().frame("frame-middle");
        String middle = driver.findElement(By.tagName("body")).getText();
        System.out.println(middle);
        driver.switchTo().parentFrame();
         
        driver.switchTo().frame("frame-right");
        String right = driver.findElement(By.tagName("body")).getText();
        System.out.println(right);

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
       String downframe= driver.findElement(By.tagName("body")).getText();
        System.out.println(downframe);



    }
}
    