/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.MainEnd.interfaces.FunctionInterfaces;

import webscraper.MainEnd.ports.FilePort.Interface.FilePort.FilePort;
import webscraper.MainEnd.Functions.functions.functionInstruction.FunctionsInstruction;
import webscraper.MainEnd.Functions.functions.functionInstruction.FunctionsInstructionCommand;

/**
 *
 * @author Peter
 */
public class FileFunctionInterface {
   
    public FileFunctionInterface() {
        
    }
    


    public FunctionsInstruction createNewFile(String pathName, String fileName, String format) { //Will be read in FunctionInstructionListRunner
        FunctionsInstruction returnFI = new FunctionsInstruction();
        returnFI.setCommand(FunctionsInstructionCommand.CREATENEWFILE);
        returnFI.addStringValue(pathName);
        returnFI.addStringValue(fileName);
        returnFI.addStringValue(format);
        return returnFI;
    }

}
