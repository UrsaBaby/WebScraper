/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper;

import java.awt.AWTException;
import webscraper.interfaces.FunctionInterface;
import webscraper.interfaces.LogicInterface;
import webscraper.structures.functions.FunctionsInstruction;
import webscraper.structures.functions.ListOfFunctionInstructions;

/**
 *
 * @author Peter
 */
public class WebScraper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AWTException, InterruptedException {

        FunctionInterface testFI = new FunctionInterface();
        LogicInterface testLI;

        testLI = new LogicInterface();
        FunctionsInstruction connect = testFI.createFunctionInstructionConnectToThisSite("https://www.youtube.com/");
        FunctionsInstruction start = testFI.createFunctionStartWebGetter();

        ListOfFunctionInstructions listOfFI = new ListOfFunctionInstructions();
        listOfFI.addFunctionsInstruction(start);
        listOfFI.addFunctionsInstruction(connect);
        testLI.runListOfFunctionInstructionsInNewThread(listOfFI);

//
    }

}
