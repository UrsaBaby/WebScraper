/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.structures.functions;

import java.util.ArrayList;
import webscraper.structures.Elements.PrimeElement;
import webscraper.structures.Elements.PrimeWebElement;

/**
 *
 * @author Peter
 */
public class Function {
    String name;
    ArrayList<PrimeElement> listOfPrimeElements;
    
    public Function(String name){
        this.name = name;
        listOfPrimeElements = new ArrayList<PrimeElement>();
    }
    
    public void addPrimeElementWithThisName(PrimeElement addThis){
        listOfPrimeElements.add(addThis);
    }
    
    public boolean containsPrimeElementWithThisName(String name){
        for(PrimeElement checker : listOfPrimeElements){
            if(checker.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    
    
    public PrimeElement getPrimeElementWithThisName(String name){
        for(PrimeElement checker : listOfPrimeElements){
            if(checker.getName().equals(name)){
                return checker;
            }
        }
        return null;
    }
    
    public String getStringRepForPrimeElements(){
        String returnString = "";
        for(PrimeElement checker : listOfPrimeElements){
            returnString += checker + "\n";
        }
        return returnString;
    }
    
    public String toString(){
        return "Function name: " + this.getName() + ", PrimeElements:" + "\n" + this.getStringRepForPrimeElements();
    }
    
    
   
    

}
