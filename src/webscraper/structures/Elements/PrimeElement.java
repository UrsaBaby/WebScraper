/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.structures.Elements;

/**
 *
 * @author Peter
 */
public class PrimeElement {
      String name;
      String origin; //Where it came from, maybe html adress?
      
      public PrimeElement(String name, String origin){
          this.name = name;
          this.origin = origin;
      }
      
    

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public String getOrigin(){
        return this.origin;
    }
    
    public void setOrigin(String origin){
        this.origin = origin;
    }
    
    public String toString(){
        return "PrimeElement name: " + this.getName() + ", Origin: " + this.getOrigin();
    }
    

}
