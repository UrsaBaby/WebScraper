/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.interfaces;

import java.awt.AWTException;
import org.openqa.selenium.WebElement;
import webscraper.structures.Elements.PrimeElement;
import webscraper.structures.Elements.PrimeWebElement;
import webscraper.structures.Page;
import webscraper.structures.functions.Functions;

/**
 *
 * @author Peter
 */
public class StructuresInterface {

    public PrimeWebElement createPrimeWebElement(WebElement thisElement, String name, String origin) {

        PrimeWebElement returnElement = new PrimeWebElement(name,origin,thisElement);
        return returnElement;
    }

    public PrimeElement createPrimeElement(String name, String origin) {
        PrimeElement returnElement = new PrimeElement(name, origin);
        return returnElement;
    }


    
    public Page createPage(String name){
        Page returnPage = new Page(name);
        return returnPage;
    }
    
    
}
