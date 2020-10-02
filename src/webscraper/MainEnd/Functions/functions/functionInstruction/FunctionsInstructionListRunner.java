/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.MainEnd.Functions.functions.functionInstruction;

import webscraper.MainEnd.Functions.functions.coreFunctions.WebFunction;
import webscraper.MainEnd.Functions.functions.coreFunctions.Functions;
import java.awt.AWTException;
import java.io.IOException;

import java.util.HashMap;

import webscraper.MainEnd.Functions.functions.coreFunctions.FileFunction;

/**
 *
 * @author Peter
 */
public class FunctionsInstructionListRunner implements Runnable {

    ListOfFunctionInstructions listToRun;
    //  LogicInterface logicInterface;
    Functions functions;
    WebFunction webFunctions;
    FileFunction fileFunction;
    HashMap<String, String> storedStrings = new HashMap<>(); //todo initate when used instead

    public FunctionsInstructionListRunner(ListOfFunctionInstructions listToRun) throws AWTException {
        this.listToRun = listToRun;

    }

    @Override
    public void run() {
        try {            
            runFunctions(listToRun);
        } catch (Exception e) {
        }
    }

    private boolean webFunctionsIsUsed(ListOfFunctionInstructions listToCheck) {
        for (FunctionsInstruction checker : listToRun.getListOfFunctionInstruction()) {
            switch (checker.getCommand()) {
                case CLICKWEBELEMENT:
                    return true;
                case CONNECTTOTHISITE:
                    return true;
                case STORETEXTFROMWEBELEMENT:
                    return true;
                case STARTWEBGETTER:
                    return true;
            }
        }
        return false;
    }

    private boolean fileFunctionIsUsed(ListOfFunctionInstructions listToCheck) {
        for (FunctionsInstruction checker : listToRun.getListOfFunctionInstruction()) {
            switch (checker.getCommand()) {
                case CREATENEWFILE:
                    return true;
                case WRITETOFILE:
                    return true;
            }
        }
        return false;
    }

    private void runFunctions(ListOfFunctionInstructions listToRun) throws AWTException, InterruptedException, IOException {
        initiateUsedFunctions(listToRun);
        for (FunctionsInstruction checker : listToRun.getListOfFunctionInstruction()) {
            switch (checker.getCommand()) {
                case CLICKWEBELEMENT:
                    webFunctions.clickElementAtThisCss(checker.getStringValueWithIndex(0));
                    break;
                case CONNECTTOTHISITE:
                    webFunctions.connectWebGetterToThisSite(checker.getStringValueWithIndex(0));
                    break;
                case STORETEXTFROMWEBELEMENT:
                    storedStrings.put(checker.getStringValueWithIndex(0), webFunctions.getTextFromElementAtThisCss(checker.getStringValueWithIndex(1)));
                    break;
                case CLOSEWEBFUNCTION:
                    webFunctions.closeWebPort();
                    break;
                case STARTWEBGETTER:
                    webFunctions.startWebPort();
                    break;

                case CREATENEWFILE:
                    //fileFunction.createNewFile(pathName, fileName, format)
                    fileFunction.createNewFile(checker.getStringValueWithIndex(0), checker.getStringValueWithIndex(1), checker.getStringValueWithIndex(2));
                    //TODO check correct 
                    break;
                case WRITETOFILE:
                    // fileFunction.writeTextToFile(textID, textToWrite, pathName, filename, format); 
                    fileFunction.writeTextToFile(storedStrings.get(checker.getStringValueWithIndex(0)), checker.getStringValueWithIndex(1), checker.getStringValueWithIndex(2), checker.getStringValueWithIndex(3));
                    break;
            }
        }
    }

    private void initiateUsedFunctions(ListOfFunctionInstructions listToRun) throws AWTException, IOException {
        if (webFunctionsIsUsed(listToRun)) {
            this.webFunctions = new WebFunction();
        }
        if (fileFunctionIsUsed(listToRun)) {
            this.fileFunction = new FileFunction();
        }

    }

}
