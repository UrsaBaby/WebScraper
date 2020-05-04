/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.interfaces;

import java.awt.AWTException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import webscraper.navigation.WebGetter;
import webscraper.structures.Elements.PrimeElement;

/**
 *
 * @author Peter
 */
public class NavigationInterface {

    ArrayList<WebGetter> listOfWebGetters;

    public NavigationInterface() throws AWTException {
        listOfWebGetters = new ArrayList<WebGetter>();
  
    }

    public WebGetter getWebGetter() throws AWTException {

        WebGetter returnGetter = new WebGetter();
        listOfWebGetters.add(returnGetter);
        return returnGetter;
    }

    public void closeWebGetters() {
        for (WebGetter checker : listOfWebGetters) {
            checker.closeWebGetter();
        }
    }

    public boolean isAWebGetterAtThisSite(String url) {
        for (WebGetter checker : listOfWebGetters) {
            if (checker.getSiteCurrentlyConnectedTo().equals(url)) {
                return true;
            }
        }
        return false;
    }

    public WebGetter getWebGetterConnectedToThisSite(String url) {
        WebGetter returnGetter = null;
        for (WebGetter checker : listOfWebGetters) {
            if (checker.getSiteCurrentlyConnectedTo().equals(url)) {
                returnGetter = checker;
            }
        }
        return returnGetter;
    }

    public void closeWebGetterConnectedToThisSite(String url) {
        for (WebGetter checker : listOfWebGetters) {
            if (checker.getSiteCurrentlyConnectedTo().equals(url)) {
                checker.closeWebGetter();
            }
        }
    }
    
    public void closeNavInterface(){
        this.closeWebGetters();
    }

}
