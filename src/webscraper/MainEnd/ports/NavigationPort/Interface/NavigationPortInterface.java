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

    WebPort webPort;

    public NavigationPortInterface() throws AWTException {
       

    }
    
    public void startWebPort() throws AWTException{
         webPort = new WebPort();
    }
    
    public WebPort getWebPort() throws AWTException {

        return this.webPort;
    }

    public void closeWebHandlers() {
        webPort.close();
    }

    public boolean isWebHandlerConnectedToThisSite(String url) {
        if (webPort.getSiteCurrentlyConnectedTo().equals(url)) {
            return true;
        }
        return false;
    }




    public void closeNavInterface() {
        this.closeWebHandlers();
    }

}
