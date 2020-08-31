/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.interfaces;

import java.awt.AWTException;
import webscraper.structures.navigation.WebGetter;

/**
 *
 * @author Peter
 */
public class NavigationInterface {

    WebGetter webGetter;

    public NavigationInterface() throws AWTException {
       

    }
    
    public void startWebGetter() throws AWTException{
         webGetter = new WebGetter();
    }
    
    public WebGetter getWebGetter() throws AWTException {

        return this.webGetter;
    }

    public void closeWebGetters() {
        webGetter.close();
    }

    public boolean isWebGetterConnectedToThisSite(String url) {
        if (webGetter.getSiteCurrentlyConnectedTo().equals(url)) {
            return true;
        }
        return false;
    }




    public void closeNavInterface() {
        this.closeWebGetters();
    }

}
