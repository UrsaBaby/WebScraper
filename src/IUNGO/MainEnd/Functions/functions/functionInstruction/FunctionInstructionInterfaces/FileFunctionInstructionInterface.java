/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO.MainEnd.Functions.functions.functionInstruction.FunctionInstructionInterfaces;

import IUNGO.MainEnd.ports.FilePort.FilePort;
import IUNGO.MainEnd.Functions.functions.functionInstruction.FunctionsInstruction;
import IUNGO.MainEnd.Functions.functions.functionInstruction.FunctionsInstructionCommand;

/**
 *
 * @author Peter
 */
public class FileFunctionInstructionInterface {

    public FileFunctionInstructionInterface() {

    }

    public FunctionsInstruction createNewFile(String pathName, String fileName, String format) { //Will be read in FunctionInstructionListRunner
        FunctionsInstruction returnFI = new FunctionsInstruction();
        returnFI.setCommand(FunctionsInstructionCommand.CREATENEWFILE);
        returnFI.addStringValue(pathName);
        returnFI.addStringValue(fileName);
        returnFI.addStringValue(format);
        return returnFI;
    }

    public FunctionsInstruction writeStoredTextToFile(String textId, String pathName, String fileName, String format) {
        FunctionsInstruction returnFI = new FunctionsInstruction();
        returnFI.addStringValue(textId);
        returnFI.addStringValue(pathName);
        returnFI.addStringValue(fileName);
        returnFI.addStringValue(format);
        returnFI.setCommand(FunctionsInstructionCommand.WRITETOFILE);

        return returnFI;
    }

    public FunctionsInstruction createFunctionInstructionStoreText(String id, String textToStore) {
        FunctionsInstruction returnFI = new FunctionsInstruction();
        returnFI.addStringValue(id);
        returnFI.addStringValue(textToStore);
        returnFI.setCommand(FunctionsInstructionCommand.STORETEXT);
        return returnFI;
    }

}
