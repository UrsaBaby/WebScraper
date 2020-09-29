/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper;

import java.awt.AWTException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import webscraper.MainEnd.Functions.functions.functionInstruction.FunctionsInstructionListRunner;
import webscraper.MainEnd.Functions.functions.functionInstruction.ListOfFunctionInstructions;
import webscraper.MainEnd.interfaces.FunctionInterfaces.FileFunctionInterface;
import webscraper.MainEnd.interfaces.FunctionInterfaces.WebFunctionInterface;

import webscraper.MainEnd.ports.FilePort.Interface.FilePort.FilePort;
import webscraper.MainEnd.ports.FilePort.Interface.FilePortInterface;


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
      
        WebFunctionInterface WFI = new WebFunctionInterface();
        FileFunctionInterface FFI = new FileFunctionInterface();
        
        ListOfFunctionInstructions instructionList = WFI.createListOfFunctionsInstructions();
        instructionList.addFunctionsInstruction(WFI.createFunctionStartWebGetter());
            instructionList.addFunctionsInstruction(WFI.createFunctionInstructionConnectToThisSite("https://www.google.com/"));
             instructionList.addFunctionsInstruction(WFI.createFunctionInstructionStoreTextFromWebElement("#gsr"));
             
             instructionList.addFunctionsInstruction(FFI.createNewFile("", "google", ".txt")); //Desnt work?
             instructionList.addFunctionsInstruction(FFI.writeTextToFile(0, "", "google", ".txt"));
             
             FunctionsInstructionListRunner FILR = new FunctionsInstructionListRunner(instructionList);
             FILR.run();
        

            
   
    }

}
