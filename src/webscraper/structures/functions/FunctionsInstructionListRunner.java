/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.structures.functions;

import java.awt.AWTException;
import java.util.logging.Level;
import java.util.logging.Logger;

import webscraper.interfaces.LogicInterface;

/**
 *
 * @author Peter
 */
public class FunctionsInstructionListRunner implements Runnable {

    ListOfFunctionInstructions listToRun;
    LogicInterface logicInterface;
    Functions functions;

    public FunctionsInstructionListRunner(ListOfFunctionInstructions listToRun) throws AWTException {
        this.listToRun = listToRun;
        logicInterface = new LogicInterface();
        functions = new Functions("FunctionsInstructionListRunner");
    }

    @Override
    public void run() {
        try {
            for (FunctionsInstruction checker : listToRun.getListOfFunctionInstruction()) {
                switch (checker.getCommand()) {
                    case CLICKWEBELEMENT:
                        functions.clickElementAtThisCss(checker.getStringValueWithIndex(0));
                        break;
                    case CONNECTTOTHISITE:
                        functions.connectWebGetterToThisSite(checker.getStringValueWithIndex(0));
                        break;
                    case GETTEXTFROMWEBELEMENT:
                        functions.getTextFromElementAtThisCss(checker.getStringValueWithIndex(0));
                        break;
                    case CLOSE:
                        functions.closeFunction();
                        break;

                    case STARTWEBGETTER:
                        functions.startWebGetter();
                        break;                       
                }
            }
        } catch (Exception e) {
        }

//  logicInterface.runListOfFunctionInstructionsInThisThread(listToRun);
        /* for(FunctionsInstruction checker : listToRun.getListOfFunctionInstruction()){
          try {
              logicInterface.runFunctionInstruction(checker);
          } catch (InterruptedException ex) {
              Logger.getLogger(FunctionsInstructionListRunner.class.getName()).log(Level.SEVERE, null, ex);
          } catch (AWTException ex) {
              Logger.getLogger(FunctionsInstructionListRunner.class.getName()).log(Level.SEVERE, null, ex);
          }
      }*/
    }

}
