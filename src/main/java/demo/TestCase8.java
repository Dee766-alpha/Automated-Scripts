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


public class TestCase8 {
    ChromeDriver driver;
    

    public void TestCase_8(){
        this.driver=TestCases.TestCases();
        driver.get(" https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        driver.switchTo().alert().sendKeys("Deepali");
        driver.switchTo().alert().accept();
        String message = driver.findElement(By.xpath("//p[@id='demo']")).getText();
        System.out.println(message);
        if(message.contains("Deepali")){
            System.out.println("Your name is displayed");
        }
        else{
            System.out.println(("not displayed"));
        }

    }
}
      