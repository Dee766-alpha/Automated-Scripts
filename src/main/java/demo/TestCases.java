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


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        System.out.println("end Test case: testCase02");
    }
    
    public void testCase02(){
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("amazon");
        driver.findElement(By.xpath("(//*[@value='Google Search'])[1]")).click();
        boolean a = driver.findElement(By.linkText("Amazon.in")).isDisplayed();
        System.out.println(a);

    }

    public void testCase04(){
        driver.get("https://www.google.com/");
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.switchTo().frame("callout");
		//driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/c-wiz/div/div/div/div[2]/div[2]/button")).click();
		
		//driver.switchTo().defaultContent();
		driver.findElement(By.name("q")).sendKeys("bharti");
		driver.findElement(By.xpath("(//*[@name='btnK'])[1]")).click();
	    
	  int count = driver.findElements(By.partialLinkText("bharti")).size();
	  //int c=driver.findElements(By.linkText("deepali")).size();
	  System.out.println(count);
		
		
    }

    public void testCase03(){
        driver.get("https://www.google.com/");
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.switchTo().frame("callout");
		//driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/c-wiz/div/div/div/div[2]/div[2]/button")).click();
		
		//driver.switchTo().defaultContent();
		driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // Locate the locator for hyperlink by using  Using Locator "Tag Name" a
        int count = driver.findElementsByTagName("a").size();
        // Get count of the hyperlinks Using Locator "Tag Name" a
        System.out.println(count);
		
    }

    public void testcase05(){
        //navigate to linked in
        driver.get("https://www.linkedin.com/home");
        //enter the username
        driver.findElement(By.id("session_key")).sendKeys("deepudeepali64@gmail.com");
        //enter the password
        driver.findElement(By.id("session_password")).sendKeys("Jobseeker@123");
        //click on sign in
        driver.findElement(By.xpath("//*[@data-id='sign-in-form__submit-btn']")).click();
        //click on start post
        driver.findElement(By.xpath("//*[text()='Start a post']")).click();
        //select the dropdown list 
        driver.findElement(By.xpath("(//span[@class='share-state-change-button__label'])[1]")).click();
        // select the connection only
        driver.findElement(By.id("CONNECTIONS_ONLY")).click();
        //select the save button
        driver.findElement(By.xpath("//div[@class='share-box-footer__main-actions']/button[2]/span")).click();
        //type " Hello" in post
       driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("HELLO");
       //post.sendKeys("HELLO");
        //click on post button
        driver.findElement(By.xpath("//*[text()='Post']")).click();
        //verify that post is successfully
       String message =driver.findElement(By.xpath("//div[@class='artdeco-toasts_toasts']/div/div/p/span")).getText();
       System.out.println(message);
       
        //display who viewd your  rpofile
         String view =driver.findElement(By.xpath("(//span[@class='feed-identity-widget-item__stat'])[1]")).getText();
         System.out.println("who viewed the profile" +" "+ view);

         //display Implression on your post 
         String impression=driver.findElement(By.xpath("(//span[@class='feed-identity-widget-item__stat'])[2]")).getText();
         System.out.println("impression on post" +" "+impression);


    }
    public void testcase06(){
        //launch the chrome
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        //print the img source of movies in recommended
       //int  counts = driver.findElements(By.xpath("//div[@id='super-wrapper']/div[1]/div[2]/div[3]/div/div[1]/div/div/div/div[2]/div/div[1]/div/a/div/div/div/img")).size();
        //System.out.println(counts);
        List <WebElement> href = driver.findElements(By.xpath("//div[@id='super-wrapper']/div[1]/div[2]/div[3]/div/div[1]/div/div/div/div[2]/div/div[1]/div/a"));
        //System.out.println(counts);
        for(WebElement val:href){
            //System.out.println(val.getText());
            System.out.println(val.getAttribute("href"));}
        }

        public void testcase07(){
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
    public void testcase08(){
         //Launch Chrome
         driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
         driver.switchTo().frame("iframeResult");
         driver.findElement(By.xpath("//button[text()='Try it']")).click();
         //switch to alert
         //Alert alert = driver.switchTo().alert();
        String message = driver.switchTo().alert().getText();
        System.out.println(message);
        driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
        
       driver.switchTo().alert().sendKeys("Deepali");
      //driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
         driver.switchTo().alert().accept();
         driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
         String m = driver.findElement(By.xpath("//p[@id='demo']")).getText();
         System.out.println(m);
         if(m.contains("Deepali")){
            System.out.println("your name displayed"+"true");
         }
         else{
            System.out.println("False");

         }
        }

         public void testcase09() throws IOException{
            //launch the chrome
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
    public void testcase010(){
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
