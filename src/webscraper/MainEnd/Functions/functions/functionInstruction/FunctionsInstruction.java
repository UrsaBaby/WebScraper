/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.MainEnd.Functions.functions.functionInstruction;

import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public class FunctionsInstruction {
   ArrayList<String> listOfStringValues;
    ArrayList<Integer> listOfIntValues;
    FunctionsInstructionCommand command;
    //TODO ENUM or someway to check instruction (String?) and ListOfStringValues and listOfIntValues
    public FunctionsInstruction(){
        listOfStringValues = new ArrayList<String>();
        listOfIntValues = new ArrayList<Integer>();             
    }
    
    public void setCommand(FunctionsInstructionCommand command){
        this.command = command;
    }
    
    public FunctionsInstructionCommand getCommand(){
        return this.command;
    }
    
    public void addStringValue(String stringValue){
        this.getStringValues().add(stringValue);
    }
    
 
    
    private ArrayList<String> getStringValues(){
        return this.listOfStringValues;
    }
    
    public String getStringValueWithIndex(int index){
        return this.getStringValues().get(index);
    }
    
    private ArrayList<Integer> getIntValues(){
        return this.listOfIntValues;
    }
    
    public void addIntValues(int intValue){
        this.getIntValues().add(intValue);
    }
    
    public int getIntValueWithIndex(int index){
        return this.getIntValues().get(index);
    }
    
    public void addIntValue(int intValue){
        this.getIntValues().add(intValue);
    }
            
}
