/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO.MainEnd.Functions.functions.functionInstruction.FunctionInstructionInterfaces;

import java.awt.AWTException;
import java.util.ArrayList;
import IUNGO.MainEnd.Functions.functions.coreFunctions.Functions;
import IUNGO.MainEnd.Functions.functions.functionInstruction.FunctionsInstruction;
import IUNGO.MainEnd.Functions.functions.functionInstruction.FunctionsInstructionCommand;
import IUNGO.MainEnd.Functions.functions.functionInstruction.ListOfFunctionInstructions;
import IUNGO.MainEnd.Functions.functions.coreFunctions.WebFunction;

/**
 *
 * @author Peter
 */
public class WebFunctionInstructionInterface {

    public WebFunctionInstructionInterface() throws AWTException  {
        
    }

 

    public ListOfFunctionInstructions createListOfFunctionsInstructions() {
        return new ListOfFunctionInstructions();
    }

    
    public WebFunction createWebFunction() throws AWTException{
        WebFunction returnWebFunction = new WebFunction();
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

    public FunctionsInstruction createFunctionInstructionStoreTextFromWebElement(String id, String cssSelector) {
        FunctionsInstruction returnFI = new FunctionsInstruction();
        returnFI.addStringValue(id);
        returnFI.addStringValue(cssSelector);
        returnFI.setCommand(FunctionsInstructionCommand.STORETEXTFROMWEBELEMENT);
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
