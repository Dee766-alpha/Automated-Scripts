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


public class TestCase10 {
    ChromeDriver driver;
   

    public void TestCase_10()throws IOException{
        this.driver=TestCases.TestCases();
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        driver.switchTo().frame("iframeResult");
        //String parent = driver.getWindowHandle();

        driver.findElement(By.xpath("//button[text()='Try it']")).click();
    
    
        Set<String> windows=driver.getWindowHandles();
    Iterator<String> itr=windows.iterator();
        String parentwindow=itr.next();
        String child =itr.next();
        driver.switchTo().window(child);
        String title=driver.getTitle();
        String url= driver.getCurrentUrl();
        
        System.out.println("title: "+title);
        System.out.println("url: "+url);

        File screenshotFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       
File DestFile = new File("screenshot\\demo.png");
FileUtils.copyFile(screenshotFile, DestFile);

  
    
    
}
}
