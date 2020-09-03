/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.MainEnd.ports.FilePort.Interface.FilePort;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Peter
 */
public class FilePort {
    
    public FilePort(){
        
    }
    
    public File createNewFileWithThisNameAtThisLocationInThisFormat(String pathName, String fileName, String fileFormat) throws IOException{
        File newFile = new File(pathName+ fileName + fileFormat);
        newFile.createNewFile();
        return newFile;
       
    }
    
    public void writeThisTextToFileAtThisPathname(String pathName, String fileName, String format, String textToWrite) throws IOException{
        FileWriter newFileWriter = new FileWriter(pathName + fileName + format);
        newFileWriter.write(textToWrite);
        newFileWriter.close();
    }
    
    public void saveFile(File saveFile) throws IOException{
        saveFile.createNewFile();
    }
}
