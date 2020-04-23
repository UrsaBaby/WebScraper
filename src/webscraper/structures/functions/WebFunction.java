/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.structures.functions;

import java.awt.AWTException;
import org.openqa.selenium.WebElement;
import webscraper.interfaces.NavigationInterface;
import webscraper.navigation.WebGetter;
import webscraper.structures.Elements.PrimeWebElement;


/**
 *
 * @author Peter
 */
public class WebFunction extends Functions{
    
    private NavigationInterface NavInterface;
    public WebFunction(String name) throws AWTException {
        super(name);
        NavInterface = new NavigationInterface();           
    }
    
    

}
