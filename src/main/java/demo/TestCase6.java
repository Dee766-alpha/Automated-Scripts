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
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
///


public class TestCase6{
    ChromeDriver driver;
    


    public void TestCase_6() throws InterruptedException, AWTException{
        this.driver=TestCases.TestCases();
        //navigate to linked in
        driver.get("https://www.linkedin.com/home");
        driver.navigate().refresh();
        //enter the username
        driver.findElement(By.id("session_key")).sendKeys("deepudeepali64@gmail.com");
        //enter the password
        driver.findElement(By.id("session_password")).sendKeys("Jobseeker@123");
        //click on sign in
        driver.findElement(By.xpath("//*[@data-id='sign-in-form__submit-btn']")).click();

        driver.findElement(By.xpath("(//button[@aria-label='Add a photo'])[1]")).click();


        Robot robot = new Robot();
       StringSelection filepath = new StringSelection("Downloads\\image.jpg");
       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
       Thread.sleep(2000);
       robot.keyPress(KeyEvent.VK_CONTROL);
       Thread.sleep(2000);
       robot.keyPress(KeyEvent.VK_V);
       Thread.sleep(2000);
       robot.keyRelease(KeyEvent.VK_CONTROL);

       robot.keyPress(KeyEvent.VK_ENTER);
       robot.keyRelease(KeyEvent.VK_ENTER);
       Thread.sleep(2000);

       driver.findElement(By.xpath("//span[text()='Done']")).click();

    }
}
      
