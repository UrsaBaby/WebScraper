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

    public helperConsole() {

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

    public void writeThisTextToAFile(String textToWrite, String fileName, String fileFormat) throws AWTException {
        String id = "textToWrite";
        ListOfFunctionInstructions writeTextInstructions = new ListOfFunctionInstructions();
        FileFunctionInstructionInterface FFI = new FileFunctionInstructionInterface();
        writeTextInstructions.addFunctionsInstruction(FFI.createFunctionInstructionStoreText(id, textToWrite));
        writeTextInstructions.addFunctionsInstruction(FFI.writeStoredTextToFile(id, "", fileName, fileFormat));
        runList(writeTextInstructions);

    }

    public void getDataAndWriteToFileTest() throws AWTException {
        WebFunctionInstructionInterface WFI = new WebFunctionInstructionInterface();
        FileFunctionInstructionInterface FFI = new FileFunctionInstructionInterface();

        FunctionsInstruction test2 = FFI.writeStoredTextToFile("gsr", "", "ID", ".txt");
        ListOfFunctionInstructions instructionList = WFI.createListOfFunctionsInstructions();
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

}
