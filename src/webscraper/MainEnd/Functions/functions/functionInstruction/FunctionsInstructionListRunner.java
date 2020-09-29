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
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import webscraper.MainEnd.Functions.functions.coreFunctions.FileFunction;

import webscraper.MainEnd.interfaces.FunctionInterfaces.FunctionInstructionInterface;

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
    ArrayList<String> storedStrings;

    public FunctionsInstructionListRunner(ListOfFunctionInstructions listToRun) throws AWTException {
        this.listToRun = listToRun;
       // logicInterface = new LogicInterface(); probably remove
       storedStrings = new ArrayList<>(); //TODO dont initiate here, check for boolean.
    }

    @Override
    public void run() {
        try {
            initiateUsedFunctions(listToRun);
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
    
    private boolean fileFunctionIsUsed(ListOfFunctionInstructions listToCheck){
        //TODO 
        return true;
    }


    private void runFunctions(ListOfFunctionInstructions listToRun) throws AWTException, InterruptedException, IOException{
         for (FunctionsInstruction checker : listToRun.getListOfFunctionInstruction()) {
                switch (checker.getCommand()) {
                    case CLICKWEBELEMENT:
                        webFunctions.clickElementAtThisCss(checker.getStringValueWithIndex(0));
                        break;
                    case CONNECTTOTHISITE:
                        webFunctions.connectWebGetterToThisSite(checker.getStringValueWithIndex(0));
                        break;
                    case STORETEXTFROMWEBELEMENT:
                        storedStrings.add(webFunctions.getTextFromElementAtThisCss(checker.getStringValueWithIndex(0)));
                                
                        break;
                    case CLOSEWEBFUNCTION:
                        webFunctions.closeFunction();
                        break;
                    case STARTWEBGETTER:
                        webFunctions.startWebGetter();
                        break;
                        
                    case CREATENEWFILE:
                        //fileFunction.createNewFile(pathName, fileName, format)
                        fileFunction.createNewFile(checker.getStringValueWithIndex(0), checker.getStringValueWithIndex(1), checker.getStringValueWithIndex(2));
                        //TODO check correct values
                    case WRITETOFILE:
                       // fileFunction.writeTextToFile(textToWrite, pathName, filename, format);
                        fileFunction.writeTextToFile(storedStrings.get(0), checker.getStringValueWithIndex(0), checker.getStringValueWithIndex(1), checker.getStringValueWithIndex(2));
                }
            }     
    }


    
    private void initiateUsedFunctions(ListOfFunctionInstructions listToRun) throws AWTException, IOException{
             if(webFunctionsIsUsed(listToRun)){
                this.webFunctions = new WebFunction();
            }
            if(fileFunctionIsUsed(listToRun)){
                  this.fileFunction = new FileFunction();
            }
        
    }


}

