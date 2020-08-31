/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.structures.functions.coreFunctions;

import java.awt.AWTException;

import webscraper.structures.fileHandling.fileHandler;

/**
 *
 * @author Peter
 */
public class FileFunction extends Functions{
    fileHandler fileHandler;
    public FileFunction(String name) throws AWTException{
        super(name);
        fileHandler = new fileHandler();
    }
    
    public createNewFile(String fileName, String fileFormat){
        fileHandler.createNewFileWithThisNameAtThisLocationInThisFormat(fileName, fileLocation, fileFormat); //TODO, check how saving a file works. overwrite? no location specified.
    }
}
