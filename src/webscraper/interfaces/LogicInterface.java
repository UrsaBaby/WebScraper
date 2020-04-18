/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.interfaces;

import java.awt.AWTException;
import java.util.HashMap;
import org.openqa.selenium.WebElement;
import webscraper.navigation.WebGetter;
import webscraper.structures.Elements.PrimeWebElement;


/**
 *
 * @author Peter
 */
public class LogicInterface {
    private WebGetter navigator;
    
    public LogicInterface() throws AWTException{
        navigator = new WebGetter();
            
    }
    

}
