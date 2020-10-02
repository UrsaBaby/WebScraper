/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.MainEnd.Functions.functions.coreFunctions;

import java.awt.AWTException;
import webscraper.MainEnd.ports.FilePort.Interface.FilePortInterface;
import webscraper.MainEnd.Functions.functions.functionInstruction.FunctionInstructionInterfaces.FileFunctionInstructionInterface;
import webscraper.MainEnd.ports.NavigationPort.Interface.Webport.WebPort;

/**
 *
 * @author Peter
 */
public class Functions {

   WebPort webPort;
    FilePortInterface fileHandlerInterface;

    public Functions() throws AWTException {
    
        
    }
    
    
    protected FilePortInterface getFileHandlerInterface(){
        return this.fileHandlerInterface;
    }

 }

    
