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
public class ListOfFunctionInstructions {
     private ArrayList<FunctionInstruction> listOfFunctionsInstructions;
     
     public ListOfFunctionInstructions(){
         listOfFunctionsInstructions = new ArrayList<FunctionInstruction>();
     }
     
     public ArrayList<FunctionInstruction> getListOfFunctionInstruction(){
         return listOfFunctionsInstructions;
     }
}
