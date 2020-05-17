/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.interfaces;

import java.awt.AWTException;
import webscraper.structures.functions.Functions;
import webscraper.structures.functions.FunctionsInstruction;
import webscraper.structures.functions.ListOfFunctionInstructions;

/**
 *
 * @author Peter
 */
public class LogicInterface {

    Functions functions;

    public LogicInterface() throws AWTException {
        functions = new Functions("LogicInterfaceFunctions");
    }
    
    public void runListOfFunctionInstructions(ListOfFunctionInstructions listOfFunctionInstruction) throws AWTException, InterruptedException {
        for (FunctionsInstruction checker : listOfFunctionInstruction.getListOfFunctionInstruction()) {
            this.runFunctionInstruction(checker);
        }
    }
    
    public void runFunctionInstruction(FunctionsInstruction runThis) throws InterruptedException, AWTException {
        switch (runThis.getCommand()) {
            case CLICKWEBELEMENT:
                functions.clickElementAtThisCss(runThis.getStringValueWithIndex(0));
                break;
            case CONNECTTOTHISITE:
                functions.connectWebGetterToThisSite(runThis.getStringValueWithIndex(0));
                break;
            case GETTEXTFROMWEBELEMENT:
                functions.getTextFromElementAtThisCss(runThis.getStringValueWithIndex(0));
                break;
            case CLOSE:
                functions.closeFunction();
                break;
            
        }
    }
}
