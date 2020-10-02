/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.MainEnd.Functions.functions.functionInstruction.FunctionInstructionInterfaces;

import java.awt.AWTException;

import webscraper.MainEnd.Functions.functions.coreFunctions.Functions;
import webscraper.MainEnd.Functions.functions.functionInstruction.FunctionsInstruction;
import webscraper.MainEnd.Functions.functions.functionInstruction.FunctionsInstructionListRunner;
import webscraper.MainEnd.Functions.functions.functionInstruction.ListOfFunctionInstructions;

/**
 *
 * @author Peter
 */
public class FunctionInstructionInterface { 

    Functions functions;

    FunctionsInstructionListRunner listRunner;

    public FunctionInstructionInterface() throws AWTException {
        functions = new Functions();
    }



    public void runListOfFunctionInstructionsInNewThread(ListOfFunctionInstructions listOfFunctionInstruction) throws AWTException, InterruptedException {
        FunctionsInstructionListRunner listRunner = new FunctionsInstructionListRunner(listOfFunctionInstruction);
        listRunner = new FunctionsInstructionListRunner(listOfFunctionInstruction);
        Thread runThread = new Thread(listRunner);
        runThread.start();
    }
    
    public ListOfFunctionInstructions createFunctionInstructionList(){
        return new ListOfFunctionInstructions();
    }
    
    public void addFunctionInstructionToList(FunctionsInstruction addThis, ListOfFunctionInstructions toThisList){
        toThisList.addFunctionsInstruction(addThis);
    }

  

}
