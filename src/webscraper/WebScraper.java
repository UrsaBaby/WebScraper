/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper;

import java.awt.AWTException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import webscraper.structures.fileHandling.fileHandler;


/**
 *
 * @author Peter
 */
public class WebScraper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AWTException, InterruptedException, IOException {

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
      File testFile = new File("jagindar.txt");
     
        FileWriter myWrite = new FileWriter(testFile);
     
        
        myWrite.close();
        testFile.createNewFile();
   
    }

}
