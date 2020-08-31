/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.structures.fileHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Peter
 */
public class fileHandler {
    
    public fileHandler(){
        
    }
    
    public void createNewFileWithThisNameAtThisLocationInThisFormat(String name, String fileLocation, String fileFormat) throws IOException{
        File newFile = new File(fileLocation + name + fileFormat);
        newFile.createNewFile();
       
    }
    
    public void writeThisDataToFileWithThisNameAtThisLocationInThisFormat(String data, String fileName, String fileLocation, String fileFormat) throws IOException{
        FileWriter newFileWriter = new FileWriter(fileLocation + fileName + fileFormat);
        newFileWriter.write(data);
        newFileWriter.close();
    }
    
    public void saveFile(File saveFile) throws IOException{
        saveFile.createNewFile();
    }
}
