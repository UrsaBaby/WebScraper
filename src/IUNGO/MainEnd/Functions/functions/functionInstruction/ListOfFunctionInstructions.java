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
public class ListOfFunctionInstructions {
     private final ArrayList<FunctionsInstruction> listOfFunctionsInstructions;
 
     
     public ListOfFunctionInstructions(){
         listOfFunctionsInstructions = new ArrayList<FunctionsInstruction>();
     }
     
     public void addFunctionsInstruction(FunctionsInstruction addThis){
         this.getListOfFunctionInstruction().add(addThis);
     }
     
     public ArrayList<FunctionsInstruction> getListOfFunctionInstruction(){
         return listOfFunctionsInstructions;
     }
}
