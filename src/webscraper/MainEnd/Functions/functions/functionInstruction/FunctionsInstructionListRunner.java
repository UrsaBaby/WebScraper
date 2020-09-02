/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.MainEnd.Functions.functions.functionInstruction;

import webscraper.MainEnd.Functions.functions.functionInstruction.FunctionsInstruction;
import webscraper.MainEnd.Functions.functions.coreFunctions.WebFunction;
import webscraper.MainEnd.Functions.functions.coreFunctions.Functions;
import java.awt.AWTException;
import java.util.logging.Level;
import java.util.logging.Logger;

import webscraper.MainEnd.Logic.LogicInterface;

/**
 *
 * @author Peter
 */
public class FunctionsInstructionListRunner implements Runnable {

    ListOfFunctionInstructions listToRun;
    LogicInterface logicInterface;
    Functions functions;
    WebFunction webFunctions;

    public FunctionsInstructionListRunner(ListOfFunctionInstructions listToRun) throws AWTException {
        this.listToRun = listToRun;
        logicInterface = new LogicInterface();
    }

    @Override
    public void run() {
        try {
            if(webFunctionsIsUsed(listToRun)){
                initiateWebFunctions();
                runWebFunctions(listToRun);
            }
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
                case GETTEXTFROMWEBELEMENT:
                    return true;
                case STARTWEBGETTER:
                    return true;
            }
        }
        return false;
    }

    private void initiateWebFunctions() throws AWTException{
        this.webFunctions = new WebFunction();
    }
    
    private void runWebFunctions(ListOfFunctionInstructions listToRun) throws AWTException, InterruptedException{
         for (FunctionsInstruction checker : listToRun.getListOfFunctionInstruction()) {
                switch (checker.getCommand()) {
                    case CLICKWEBELEMENT:
                        webFunctions.clickElementAtThisCss(checker.getStringValueWithIndex(0));
                        break;
                    case CONNECTTOTHISITE:
                        webFunctions.connectWebGetterToThisSite(checker.getStringValueWithIndex(0));
                        break;
                    case GETTEXTFROMWEBELEMENT:
                        webFunctions.getTextFromElementAtThisCss(checker.getStringValueWithIndex(0));
                        break;
                    case CLOSEWEBFUNCTION:
                        webFunctions.closeFunction();
                        break;
                    case STARTWEBGETTER:
                        webFunctions.startWebGetter();
                        break;
                }
            }     
    }
}

