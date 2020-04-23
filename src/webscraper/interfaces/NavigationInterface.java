/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.interfaces;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;


import webscraper.navigation.WebGetter;
import webscraper.structures.Elements.PrimeElement;



/**
 *
 * @author Peter
 */
public class NavigationInterface {
WebGetter webGetter;

    public NavigationInterface() throws AWTException {
        webGetter = new WebGetter();
     
    }
    

    
  public WebGetter getWebGetter(){
      return this.webGetter;
  }
    
    
    
    

}
