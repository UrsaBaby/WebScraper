/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper;


import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import webscraper.interfaces.StructuresInterface;
import webscraper.structures.functions.Functions;


/**
 *
 * @author Peter
 */
public class WebScraper {

    /**
     * @param args the command line arguments
     */
    public static  void main(String[] args) throws AWTException  {
  
    
        
   StructuresInterface testStructuresInterface = new StructuresInterface();
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Peter\\Documents\\NetBeansProjects\\WebScraper\\Driver\\chromedriver.exe");
        Functions testFunction = testStructuresInterface.createFunction("Connect");
        testFunction.connectWebGetterToThisSite("https://www.youtube.com/");
        
        
     //   testFunction.addPrimeElement(testStructuresInterface.createPrimeElement("XYZ", "ZYX"));
      //  System.out.println(testFunction.getPrimeElementWithThisName("XYZ"));
    //    System.out.println(testFunction);
      //  Page testPage = new Page("TestPage");
      //  testPage.addFunction(testFunction);
      //  System.out.println(testPage.toStringFull());
        //testFunction.connectToThisHtml("https://www.avanza.se/fonder/lista.html?fundType=Blandfond|Aktiefond&sortField=name&sortDirection=ASCENDING&selectedTab=overview");
      //  Thread.sleep(2000);
        //System.out.println(testFunction.getTextFromElementAtThisCss("body > aza-app > div > main > div > aza-fund-list > aza-subpage > div > div > div > aza-card > table > tbody"));
       
     
        
        
//  Navigator navigator = new Navigator();
      //  WebpageHTMLDatabase webpageDatabase = new WebpageHTMLDatabase();
     //   webpageDatabase.test();
       // navigator.run();
        // Test navigator
        //TE

//
//WebDriver driver = null;
//
    /*    WebDriver driver = null;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Peter\\Documents\\NetBeansProjects\\WebScraper\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        String siteToVisit = "https://www.avanza.se/fonder/lista.html?fundType=Aktiefond&sortField=developmentOneYear&sortDirection=DESCENDING&selectedTab=overview";
      
     //   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //affects how long it stays on the site
        
        String title = driver.getTitle();
        System.out.println(title);
        WebElement element = driver.findElement(By.cssSelector("body > aza-app > div > main > div > aza-fund-list > aza-subpage > div > div > div"));
        String tagName = element.getText();
        System.out.println(tagName);
        System.out.println("as");


      

   
    }

  
    
    public void connectToThisSiteWithThisWebdriver(String site, WebDriver thisDriver){
        thisDriver.navigate().to(site);*/
        
    }
    
    

}
