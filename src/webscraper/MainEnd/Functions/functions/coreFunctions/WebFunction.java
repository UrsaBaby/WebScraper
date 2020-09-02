/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.MainEnd.Functions.functions.coreFunctions;


import java.awt.AWTException;
import webscraper.MainEnd.ports.NavigationPort.Interface.NavigationPortInterface;



/**
 *
 * @author Peter Meisel
 */
public class WebFunction extends Functions{
    
public WebFunction() throws AWTException{
  super();
  navInterface = new NavigationPortInterface();
}

    public void startWebGetter() throws AWTException{
        navInterface.startWebHandler();
    }
    
    public void connectWebGetterToThisSite(String url) throws AWTException {
        navInterface.getWebHandler().connectToThisSite(url);
    }

    public String getTextFromElementAtThisCss(String cssSelector) throws InterruptedException, AWTException {
        return navInterface.getWebHandler().getElementAtThisCss(cssSelector).getText();
    }

    public void clickElementAtThisCss(String cssSelector) throws AWTException {
      
            navInterface.getWebHandler().clickElementAtThisCss(cssSelector);
        
    }
    
    

}
