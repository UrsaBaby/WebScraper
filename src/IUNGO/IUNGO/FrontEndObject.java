/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO.IUNGO;

import java.util.ArrayList;


/**
 *
 * @author Peter
 */
public class FrontEndObject {
   ArrayList<FrontEndObject> listOfFrontEndObjects;
   public FrontEndObject(){
       
   }
   
   public boolean isListInitiated(){
           if(listOfFrontEndObjects == null){
              return false; 
           }
           return true;
}
   
   private void initiateListOfFrontEndObjects(){
       this.listOfFrontEndObjects = new ArrayList<>();
   }
   
   public void addFrontEndObject(FrontEndObject addThis){
       if(!this.isListInitiated()){
           this.initiateListOfFrontEndObjects();
       }
      this.getListOfFrontEndObjects().add(addThis);
   }
   
   private ArrayList<FrontEndObject> getListOfFrontEndObjects(){
       return this.listOfFrontEndObjects;
   }
}
