/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO;

import IUNGO.FrontEndMaker.FrontEndLengthUnits;
import IUNGO.FrontEndMaker.FrontEndObject;
import IUNGO.FrontEndMaker.FrontEndObjectInterface;
import IUNGO.FrontEndMaker.FrontEndTags;
import IUNGO.FrontEndMaker.StringFormatter;
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
        FrontEndObjectInterface FEOInterface = new FrontEndObjectInterface();
        int[] minMaxSize = new int[2];
        minMaxSize[0] = 100;
        minMaxSize[1] = 1000;
        FrontEndObject mainScene = FEOInterface.createContainer("SCENE", minMaxSize, 0, minMaxSize, 0);
        mainScene.setBackgroundColor("blue");
        
        FrontEndObject insideBox = FEOInterface.createContainer("box", minMaxSize, 0, minMaxSize, 0);
        
        mainScene.addFrontEndObject(insideBox);
        
        StringFormatter stringFormat = new StringFormatter();
        System.out.println(stringFormat.getCSS(mainScene));
        System.out.println(stringFormat.getHTML(mainScene));
        //System.out.println(stringFormat.getHTML2(mainScene));

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

    private void getDataAndWriteToFileTest() throws AWTException {
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

}
