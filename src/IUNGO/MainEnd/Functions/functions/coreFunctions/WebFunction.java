/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO.MainEnd.Functions.functions.coreFunctions;


import java.awt.AWTException;
import IUNGO.MainEnd.ports.Webport.WebPort;



/**
 *
 * @author Peter Meisel
 */
public class WebFunction extends Functions{
   
public WebFunction() throws AWTException{
  super();
  

}

    public void startWebPort() throws AWTException{
        webPort = new WebPort();
    }
    
    public void connectWebGetterToThisSite(String url) throws AWTException {
        webPort.connectToThisSite(url);
    }

    public String getTextFromElementAtThisCss(String cssSelector) throws InterruptedException, AWTException {
        return webPort.getElementAtThisCss(cssSelector).getText();
    }

    public void clickElementAtThisCss(String cssSelector) throws AWTException {
      
            webPort.clickElementAtThisCss(cssSelector);
        
    }
    
    public void closeWebPort(){
        webPort.close();
    }
    
    

}
