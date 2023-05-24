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


public class TestCase9 {
    ChromeDriver driver;
    

    public void TestCase_9(){
      this.driver=TestCases.TestCases();

         //Launch Chrome
         driver.get(("https://www.imdb.com/chart/top?sort=ir,desc&mode=simple&page=1"));
         // Locate the dropdown list Using Locator "Name" sort
           WebElement dropdownlist= driver.findElement(By.name("sort"));
           Select option =new Select(dropdownlist);
          option.selectByValue("ir:descending");
          //Print highest IMBD movie
          List <WebElement> highestrating  = driver.findElements(By.xpath("//td[@class='ratingColumn imdbRating']/strong"));
          List <WebElement> highestratingmovie= driver.findElements(By.xpath("//td[@class='titleColumn']/a"));
          for(int i=0;i< highestrating.size();i++){
              String value = highestrating.get(i).getText();
              Double val = Double.parseDouble(value);
              if(val ==9.2){
                  System.out.println("Highest rating"+highestratingmovie.get(i).getText()+" "+highestrating.get(i).getText());
              }
  
          }
  
          System.out.println("highest movie rating"+highestratingmovie.size());
          option.selectByValue("us:descending");
  
          //System.out.println(highestratingmovie.get(250).getText());
            //String leastmovie=driver.findElement(By.xpath("(//td[@class='titleColumn']/a)[250]"));
          System.out.println(driver.findElement(By.xpath("//tr[250]/td[@class='titleColumn']/a")).getText());
          System.out.println(driver.findElement(By.xpath("//tr[1]/td[@class='titleColumn']/a")).getText());
  
          //Print the most user rated movie from the list
          List <WebElement> list2 = driver.findElements(By.xpath("//td[@class='ratingColumn imdbRating']/strong"));
          List<Integer> arrList=new ArrayList<>();
          for(WebElement user:list2){
              String[] noOfUsers=user.getAttribute("title").split("");
              String val=noOfUsers[3].replace(",", "");
            int v =Integer.parseInt(val, 0);
              arrList.add(v);
  
          }
          int highest =arrList.indexOf(Collections.max(arrList));
          System.out.println("Highestrating"+driver.findElement(By.xpath("//tr[1]/td[@class='titleColumn']/a")).getText());
  
      }
  

    }

