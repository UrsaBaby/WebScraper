/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.interfaces;

import java.awt.AWTException;
import java.util.ArrayList;
import webscraper.structures.functions.Functions;
import webscraper.structures.functions.FunctionsInstruction;
import webscraper.structures.functions.FunctionsInstructionCommand;
import webscraper.structures.functions.ListOfFunctionInstructions;
import webscraper.structures.functions.WebFunction;

/**
 *
 * @author Peter
 */
public class FunctionInterface {

    public FunctionInterface()  {
       
    }

 

    public ListOfFunctionInstructions createListOfFunctionsInstructions() {
        return new ListOfFunctionInstructions();
    }

    public Functions createFunction(String name) throws AWTException {
        Functions returnFunction = new Functions(name);
        return returnFunction;
    }
    
    public WebFunction createWebFunction(String name) throws AWTException{
        WebFunction returnWebFunction = new WebFunction(name);
        return returnWebFunction;
    }

    public FunctionsInstruction createFunctionInstructionConnectToThisSite(String url) {
        FunctionsInstruction returnFI = new FunctionsInstruction();
        returnFI.addStringValue(url);
        returnFI.setCommand(FunctionsInstructionCommand.CONNECTTOTHISITE);
        return returnFI;
    }

    public FunctionsInstruction createFunctionInstructionClickThisWebElement(String cssSelector) {
        FunctionsInstruction returnFI = new FunctionsInstruction();
        returnFI.addStringValue(cssSelector);
        returnFI.setCommand(FunctionsInstructionCommand.CLICKWEBELEMENT);
        return returnFI;
    }

    public FunctionsInstruction createFunctionInstructionGetTextFromWebElement(String cssSelector) {
        FunctionsInstruction returnFI = new FunctionsInstruction();
        returnFI.addStringValue(cssSelector);
        returnFI.setCommand(FunctionsInstructionCommand.GETTEXTFROMWEBELEMENT);
        return returnFI;
    }

    public FunctionsInstruction createFunctionInstructionCloseWebFunctions() {
        FunctionsInstruction returnFI = new FunctionsInstruction();
        returnFI.setCommand(FunctionsInstructionCommand.CLOSEWEBFUNCTION);
        return returnFI;
    }
    
    public FunctionsInstruction createFunctionStartWebGetter() {
        FunctionsInstruction returnFI = new FunctionsInstruction();
        returnFI.setCommand(FunctionsInstructionCommand.STARTWEBGETTER);
        return returnFI;
    }
}
