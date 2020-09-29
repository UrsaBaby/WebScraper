/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.MainEnd.Functions.functions.coreFunctions;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import webscraper.MainEnd.ports.FilePort.Interface.FilePortInterface;

/**
 *
 * @author Peter
 */
public class FileFunction extends Functions {

    public FileFunction() throws AWTException, IOException {
        super();
   fileHandlerInterface = new FilePortInterface();
    }

    public void createNewFile(String pathName, String fileName, String format) throws IOException { //TODO format maybe enum?
     
      this.getFileHandlerInterface().getFilePort().createNewFileWithThisNameAtThisLocationInThisFormat(pathName, fileName, format);

    }
    
    public void saveNewFile(String pathName, String fileName, String format) throws IOException{
        this.getFileHandlerInterface().getFilePort().createNewFileWithThisNameAtThisLocationInThisFormat(pathName, fileName, format); //TODO test
    }
    
    public void writeTextToFile(String textToWrite, String pathName, String filename, String format) throws IOException{ //TODO test
        this.getFileHandlerInterface().getFilePort().writeThisTextToFileAtThisPathname(pathName, filename, format, textToWrite);
    }
}
