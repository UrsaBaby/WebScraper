/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.structures.functions.coreFunctions;


import java.awt.AWTException;
import webscraper.interfaces.NavigationInterface;



/**
 *
 * @author Peter Meisel
 */
public class WebFunction extends Functions{
    
public WebFunction(String name) throws AWTException{
  super(name);
  navInterface = new NavigationInterface();
}

    public void startWebGetter() throws AWTException{
        navInterface.startWebGetter();
    }
    
    public void connectWebGetterToThisSite(String url) throws AWTException {
        navInterface.getWebGetter().connectToThisSite(url);
    }

    public String getTextFromElementAtThisCss(String cssSelector) throws InterruptedException, AWTException {
        return navInterface.getWebGetter().getElementAtThisCss(cssSelector).getText();
    }

    public void clickElementAtThisCss(String cssSelector) throws AWTException {
      
            navInterface.getWebGetter().clickElementAtThisCss(cssSelector);
        
    }
    
    

}
