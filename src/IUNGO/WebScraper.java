/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO;

import java.awt.AWTException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import IUNGO.MainEnd.Functions.functions.functionInstruction.FunctionsInstructionListRunner;
import IUNGO.MainEnd.Functions.functions.functionInstruction.ListOfFunctionInstructions;
import IUNGO.MainEnd.Functions.functions.functionInstruction.FunctionInstructionInterfaces.FileFunctionInstructionInterface;
import IUNGO.MainEnd.Functions.functions.functionInstruction.FunctionInstructionInterfaces.WebFunctionInstructionInterface;
import IUNGO.MainEnd.Functions.functions.functionInstruction.FunctionsInstruction;
import IUNGO.MainEnd.ports.FilePort.FilePort;



/**
 *
 * @author Peter
 */
public class WebScraper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AWTException, InterruptedException, IOException {

     /*   FunctionInterface testFI = new FunctionInterface();
        LogicInterface testLI;

        testLI = new LogicInterface();
        FunctionsInstruction connect = testFI.createFunctionInstructionConnectToThisSite("https://www.youtube.com/");
        FunctionsInstruction start = testFI.createFunctionStartWebGetter();

        ListOfFunctionInstructions listOfFI = new ListOfFunctionInstructions();
        listOfFI.addFunctionsInstruction(start);
        listOfFI.addFunctionsInstruction(connect);
        testLI.runListOfFunctionInstructionsInNewThread(listOfFI);*/

        //fileHandler fileHandler = new fileHandler();
      //  fileHandler.createNewFileWithThisNameAtThisLocationInThisFormat("nyttTest", "C:\\Users\\Peter\\Documents\\", ".txt");
      
        WebFunctionInstructionInterface WFI = new WebFunctionInstructionInterface();
        FileFunctionInstructionInterface FFI = new FileFunctionInstructionInterface();
       
        FunctionsInstruction test2 = FFI.writeTextToFile("gsr", "", "ID", ".txt");
        ListOfFunctionInstructions instructionList = WFI.createListOfFunctionsInstructions();
        instructionList.addFunctionsInstruction(WFI.createFunctionStartWebGetter());
            instructionList.addFunctionsInstruction(WFI.createFunctionInstructionConnectToThisSite("https://www.google.com/"));
           
             instructionList.addFunctionsInstruction(WFI.createFunctionInstructionStoreTextFromWebElement("gsr", "#gsr"));
             
             instructionList.addFunctionsInstruction(FFI.createNewFile("", "google", ".txt")); 
              //TODO redo stored value? 
             instructionList.addFunctionsInstruction(test2); //TODO textID isnt captured? se threadsafe?
             
             FunctionsInstructionListRunner FILR = new FunctionsInstructionListRunner(instructionList);
             FILR.run();
             
         
             
             
        

            
   
    }

}
