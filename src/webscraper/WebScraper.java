/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.openqa.grid.common.SeleniumProtocol.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import webscraper.navigation.Navigator;

/**
 *
 * @author Peter
 */
public class WebScraper {

    /**
     * @param args the command line arguments
     */
    public static  void main(String[] args) throws IOException, InterruptedException, AWTException {
        
        Navigator navigator = new Navigator();
        navigator.run();
        // TODO code application logic here

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
