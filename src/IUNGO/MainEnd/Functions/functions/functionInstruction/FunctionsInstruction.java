/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO.MainEnd.Functions.functions.functionInstruction;

import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public class FunctionsInstruction {
   ArrayList<String> listOfStringValues;
    ArrayList<Integer> listOfIntValues;
    ArrayList<String> listOfFormattedStrings;
    FunctionsInstructionCommand command;
    //TODO ENUM or someway to check instruction (String?) and ListOfStringValues and listOfIntValues
    public FunctionsInstruction(){
        
           
    }
    
    public void setCommand(FunctionsInstructionCommand command){
        this.command = command;
    }
    
    public FunctionsInstructionCommand getCommand(){
        return this.command;
    }
    
    public void addStringValue(String stringValue){
        if(!isListOfStringValuesInitiated()){
            this.initiateListOfStringValues();
        }
        this.listOfStringValues.add(stringValue);
    }
    
      public void addIntValue(int intValue){
          if(!isListOfIntValuesInitiated()){
              this.initiateListOfIntValues();
          }
        this.listOfIntValues.add(intValue);
    }
    
    
    public void addListOfFormattedString(ArrayList<String> formattedString){
        listOfFormattedStrings = formattedString;
    }
    
    public String getStringValueWithIndex(int index){
        return this.listOfStringValues.get(index);
    }
    
    //
    private void initiateListOfStringValues(){
        listOfStringValues = new ArrayList<String>();
    }
    
    private void initiateListOfIntValues(){
        listOfIntValues = new ArrayList<Integer>();  
    }
    //
    
    private boolean isListOfStringValuesInitiated(){
        if(this.listOfStringValues == null){
            return false;
        }
        return true;
    }
    
       private boolean isListOfIntValuesInitiated(){
        if(this.listOfIntValues == null){
            return false;
        }
        return true;
    }              
}
