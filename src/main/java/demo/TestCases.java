package demo;

import java.util.concurrent.TimeUnit;
import java.awt.AWTException;
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


public class TestCases {
     static ChromeDriver driver;
    public static ChromeDriver TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws IOException, InterruptedException, AWTException{
        System.out.println("Start Test case: testCase01");
        //driver.get("https://www.google.com");
        TestCase7 test7 =new TestCase7();
        test7.testCase_7();
        TestCase8 test8=new TestCase8();
        test8.TestCase_8();
        TestCase9 test9=new TestCase9();
        test9.TestCase_9();
        TestCase10 test10=new TestCase10();
        //test10.TestCase_10();
        test10.TestCase_10();
        TestCase6 test6=new TestCase6();
        test6.TestCase_6();

        
        System.out.println("end Test case: testCase02");
    }
    
    }
