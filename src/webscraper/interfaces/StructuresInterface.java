/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.interfaces;

import org.openqa.selenium.WebElement;
import webscraper.structures.Elements.PrimeElement;
import webscraper.structures.Elements.PrimeWebElement;
import webscraper.structures.functions.Function;

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

    public Function createFunction(String name) {
        Function returnFunction = new Function(name);
        return returnFunction;
    }
}
