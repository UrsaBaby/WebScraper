/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.MainEnd.ports.NavigationPort.Interface;

import java.awt.AWTException;
import webscraper.MainEnd.ports.NavigationPort.Interface.Webport.WebPort;

/**
 *
 * @author Peter
 */
public class NavigationPortInterface { //used byt listrunner

    WebPort webGetter;

    public NavigationPortInterface() throws AWTException {
       

    }
    
    public void startWebHandler() throws AWTException{
         webGetter = new WebPort();
    }
    
    public WebPort getWebHandler() throws AWTException {

        return this.webGetter;
    }

    public void closeWebHandlers() {
        webGetter.close();
    }

    public boolean isWebHandlerConnectedToThisSite(String url) {
        if (webGetter.getSiteCurrentlyConnectedTo().equals(url)) {
            return true;
        }
        return false;
    }




    public void closeNavInterface() {
        this.closeWebHandlers();
    }

}
