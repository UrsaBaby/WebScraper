/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.structures;

import org.openqa.selenium.WebElement;

/**
 *
 * @author Peter
 */
public class primeWebElement extends primeElement{
   
    String htmlAdress;
    WebElement webElement;
    
    public primeWebElement(String name){
      super(name);
        this.htmlAdress = htmlAdress;
        this.webElement = webElement;
    }
    
    public String getName(){
        return this.name;
    }
    
   public String getHtmlAdress(){
       return this.htmlAdress;
   }
   
   public WebElement getWebElement(){
       return this.webElement;
   }
   
   public void setName(String name){
       this.name = name;
   }
   
   public void setHtmlAdress(String htmlAdress){
       this.htmlAdress = htmlAdress;
   }
   
   public void setWebElement(WebElement webElement){
       this.webElement = webElement;
   }
}
