/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO;

import IUNGO.MainEnd.Functions.functions.functionInstruction.FunctionInstructionInterfaces.FileFunctionInstructionInterface;
import IUNGO.MainEnd.Functions.functions.functionInstruction.FunctionInstructionInterfaces.WebFunctionInstructionInterface;
import IUNGO.MainEnd.Functions.functions.functionInstruction.FunctionsInstruction;
import IUNGO.MainEnd.Functions.functions.functionInstruction.FunctionsInstructionListRunner;
import IUNGO.MainEnd.Functions.functions.functionInstruction.ListOfFunctionInstructions;
import java.awt.AWTException;

/**
 *
 * @author Peter
 */
public class helperConsole {
 FileFunctionInstructionInterface FFI;
 WebFunctionInstructionInterface WFI;
    public helperConsole() throws AWTException {
 FFI = new FileFunctionInstructionInterface();
 WFI = new WebFunctionInstructionInterface(); //TODO dont initialize here
    }

    private void writeFileTest() {
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
    }

    public ListOfFunctionInstructions writeThisTextToAFile(String textToWrite, String fileName, String fileFormat) throws AWTException {
        String id = "textToWrite";
        ListOfFunctionInstructions returnInstructions = new ListOfFunctionInstructions();   
        returnInstructions.addFunctionsInstruction(FFI.createFunctionInstructionStoreText(id, textToWrite));
        returnInstructions.addFunctionsInstruction(FFI.writeStoredTextToFile(id, "", fileName, fileFormat));
        return  returnInstructions;

    }
    
    public ListOfFunctionInstructions connectToThisAdress(String adress){
        ListOfFunctionInstructions returnInstructions = new ListOfFunctionInstructions();
        returnInstructions.addFunctionsInstruction(WFI.createFunctionInstructionConnectToThisSite(adress));             
        return returnInstructions;
    }

    public void getDataAndWriteToFileTest() throws AWTException {
 

        FunctionsInstruction test2 = FFI.writeStoredTextToFile("gsr", "", "ID", ".txt");
        ListOfFunctionInstructions instructionList = new ListOfFunctionInstructions();
        instructionList.addFunctionsInstruction(WFI.createFunctionStartWebGetter());
        instructionList.addFunctionsInstruction(WFI.createFunctionInstructionConnectToThisSite("https://www.google.com/"));

        instructionList.addFunctionsInstruction(WFI.createFunctionInstructionStoreTextFromWebElement("gsr", "#gsr"));

        instructionList.addFunctionsInstruction(test2);

        FunctionsInstructionListRunner FILR = new FunctionsInstructionListRunner(instructionList);
        FILR.run();
    }

    private void runList(ListOfFunctionInstructions runThis) throws AWTException {
        FunctionsInstructionListRunner listRunner = new FunctionsInstructionListRunner(runThis);
        listRunner.run();
    }
    
    public FileFunctionInstructionInterface getFFI(){
        return this.FFI;
    }
    
    public WebFunctionInstructionInterface getWFI(){
        return this.WFI;
    }
    

}
