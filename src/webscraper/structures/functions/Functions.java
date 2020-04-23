/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.structures.functions;

import java.awt.AWTException;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import webscraper.interfaces.NavigationInterface;
import webscraper.structures.Elements.PrimeElement;
import webscraper.structures.Elements.PrimeWebElement;

/**
 *
 * @author Peter
 */
public class Functions {

    String name;
    NavigationInterface navInterface;

    public Functions(String name) throws AWTException {
        this.name = name;
        navInterface = new NavigationInterface();

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Peter\\Documents\\NetBeansProjects\\WebScraper\\Driver\\chromedriver.exe");
    }

    public String getTextFromElementAtThisCss(String cssSelector) throws InterruptedException {
        return navInterface.getWebGetter().getWebElementFromThisCss(cssSelector).getText();
    }

    public void connectToThisHtml(String html) {
        navInterface.getWebGetter().connectWebGetterToThisSite(html);
    }

    public void closeFunction() {
        navInterface.getWebGetter().close();
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public String toString() {
        return "Function name: " + this.getName();
    }



}
