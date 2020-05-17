/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.structures.functions;

import java.awt.AWTException;


import webscraper.interfaces.NavigationInterface;

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
    


    public String getName() {
        return this.name;
    }

    public void closeFunction() {
        navInterface.closeNavInterface();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Function name: " + this.getName();
    }

}
