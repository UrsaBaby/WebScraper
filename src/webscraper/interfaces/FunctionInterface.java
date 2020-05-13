/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.interfaces;

import java.util.ArrayList;
import webscraper.structures.FunctionInstruction;
import webscraper.structures.ListOfFunctionInstructions;

/**
 *
 * @author Peter
 */
public class FunctionInterface {
    
    public FunctionInterface(){
        
    }
    
    public void run(ListOfFunctionInstructions listOfFunctionInstruction){
        for(FunctionInstruction checker : listOfFunctionInstruction.getListOfFunctionInstruction()){
            
        }
    }
}
