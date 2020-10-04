/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO.MainEnd.Functions.functions.coreFunctions;

import java.awt.AWTException;

import java.io.IOException;
import IUNGO.MainEnd.ports.FilePort.FilePort;


/**
 *
 * @author Peter
 */
public class FileFunction extends Functions {

    public FileFunction() throws AWTException, IOException {
        super();
  
   filePort = new FilePort();
    }

    public void createNewFile(String pathName, String fileName, String format) throws IOException { //TODO format maybe enum?
     
      this.getFilePort().createNewFileWithThisNameAtThisLocationInThisFormat(pathName, fileName, format);

    }
    
    public void saveNewFile(String pathName, String fileName, String format) throws IOException{
        this.getFilePort().createNewFileWithThisNameAtThisLocationInThisFormat(pathName, fileName, format); //TODO test
    }
    
    public void writeTextToFile(String textToWrite, String pathName, String filename, String format) throws IOException{ //TODO test
        this.getFilePort().writeThisTextToFileAtThisPathname(pathName, filename, format, textToWrite);
    }
}
