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
public class FunctionInstruction {
   ArrayList<String> listOfStringValues;
    ArrayList<Integer> listOfIntValues;
    InstructionCommand command;
    //TODO ENUM or someway to check instruction (String?) and ListOfStringValues and listOfIntValues
    public FunctionInstruction(){
        listOfStringValues = new ArrayList<String>();
        listOfIntValues = new ArrayList<Integer>();             
    }
    
    public void setCommand(InstructionCommand command){
        this.command = command;
    }
    
    public InstructionCommand getCommand(){
        return this.command;
    }
    
    public void addStringValue(String addValue){
        this.getStringValues().add(addValue);
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
    
    public void addIntValue(int intValue){
        this.getIntValues().add(intValue);
    }
            
}
