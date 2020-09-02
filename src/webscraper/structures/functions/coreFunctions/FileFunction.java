/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.structures.functions.coreFunctions;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import webscraper.interfaces.FilePortInterface;
import webscraper.interfaces.FunctionInterfaces.FileFunctionInterface;

import webscraper.structures.Handlers.FilePorting.FilePort;

/**
 *
 * @author Peter
 */
public class FileFunction extends Functions {

    public FileFunction() throws AWTException, IOException {
        super();
   fileHandlerInterface = new FilePortInterface();
    }

    public File createNewFile(String pathName, String fileName, String format) throws IOException { //TODO format maybe enum?
     
        return this.getFileHandlerInterface().getFilePort().createNewFileWithThisNameAtThisLocationInThisFormat(fileName, fileName, format);

    }
}
