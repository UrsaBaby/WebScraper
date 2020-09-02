/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.interfaces;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import webscraper.structures.functions.coreFunctions.Functions;
import webscraper.structures.functions.functionInstruction.FunctionsInstruction;
import webscraper.structures.functions.functionInstruction.FunctionsInstructionListRunner;
import webscraper.structures.functions.functionInstruction.ListOfFunctionInstructions;

/**
 *
 * @author Peter
 */
public class LogicInterface { //Merge with FunctionInstructionListRunner?

    Functions functions;

    FunctionsInstructionListRunner listRunner;

    public LogicInterface() throws AWTException {
        functions = new Functions();
    }

   /* public void runListOfFunctionInstructionsInMainThread(ListOfFunctionInstructions listOfFunctionsInstructions) {
        for (FunctionsInstruction checker : listOfFunctionsInstructions.getListOfFunctionInstruction()) {
            try {
                runFunctionInstruction(checker);
            } catch (InterruptedException ex) {
                Logger.getLogger(LogicInterface.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Couldnt run FunctionsInstruction InterreptedException");
            } catch (AWTException ex) {
                Logger.getLogger(LogicInterface.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Couldnt run FunctionsInstruction AWTEexception");
            }
        }
    }*/

    public void runListOfFunctionInstructionsInNewThread(ListOfFunctionInstructions listOfFunctionInstruction) throws AWTException, InterruptedException {
        FunctionsInstructionListRunner listRunner = new FunctionsInstructionListRunner(listOfFunctionInstruction);
        listRunner = new FunctionsInstructionListRunner(listOfFunctionInstruction);
        Thread runThread = new Thread(listRunner);
        runThread.start();
    }

   /* public void runFunctionInstruction(FunctionsInstruction runThis) throws InterruptedException, AWTException {
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
            case CLOSEWEBFUNCTION:
                functions.closeFunction();
                break;
            case STARTWEBGETTER:
                functions.startWebGetter();
                break;
        }
    }*/

}
