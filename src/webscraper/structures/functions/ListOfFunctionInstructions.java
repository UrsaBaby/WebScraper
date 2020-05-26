/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.structures.functions;

import webscraper.structures.functions.FunctionsInstruction;
import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public class ListOfFunctionInstructions {
     private ArrayList<FunctionsInstruction> listOfFunctionsInstructions;
     String name;
     
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
