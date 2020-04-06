/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.structures;

import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public class Function {
    String name;
    ArrayList<primeElement> listOfPrimeElements;
    
    public Function(String name){
        this.name = name;
        listOfPrimeElements = new ArrayList<primeElement>();
    }
    
    public void addPrimeWebelementWithThisNameAndHtmlAdress(primeWebElement addThis){
        listOfPrimeElements.add(addThis);
    }
    
    public boolean containsPrimeWebElementWithThisName(String name){
        for(primeElement checker : listOfPrimeElements){
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
    
    
    
    public primeElement getPrimeElementWithThisName(String name){
        for(primeElement checker : listOfPrimeElements){
            if(checker.getName().equals(name)){
                return checker;
            }
        }
        return null;
    }
    
    
   
    

}
