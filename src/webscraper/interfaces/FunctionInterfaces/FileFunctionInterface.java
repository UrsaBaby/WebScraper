/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.interfaces.FunctionInterfaces;

import webscraper.structures.Handlers.FilePorting.FilePort;
import webscraper.structures.functions.functionInstruction.FunctionsInstruction;
import webscraper.structures.functions.functionInstruction.FunctionsInstructionCommand;

/**
 *
 * @author Peter
 */
public class FileFunctionInterface {
   
    public FileFunctionInterface() {
        
    }
    


    public FunctionsInstruction createNewFile(String filename, String fileFormat) {
        FunctionsInstruction returnFI = new FunctionsInstruction();
        returnFI.setCommand(FunctionsInstructionCommand.CREATENEWFILE);
        returnFI.addStringValue(filename);
        returnFI.addStringValue(fileFormat);
        return returnFI;
    }

}
