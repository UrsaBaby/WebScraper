/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.structures.Elements;

import org.openqa.selenium.WebElement;

/**
 *
 * @author Peter
 */
public class PrimeWebElement extends PrimeElement {

    String origin;
    WebElement webElement;

    public PrimeWebElement(String name, String origin, WebElement webElement) {
        super(name, origin);
        this.webElement = webElement;
    }

    public String getName() {
        return this.name;
    }

    public WebElement getWebElement() {
        return this.webElement;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWebElement(WebElement webElement) {
        this.webElement = webElement;
    }
}
