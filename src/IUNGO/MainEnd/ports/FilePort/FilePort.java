/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO.MainEnd.ports.FilePort;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Peter
 */
public class FilePort {
    
    public FilePort(){
        FileWriter fileWriter;
    }
    
    public void createNewFileWithThisNameAtThisLocationInThisFormat(String pathName, String fileName, String fileFormat) throws IOException{
        File newFile = new File(pathName+ fileName + fileFormat);
        newFile.createNewFile();
       
    }
    
    public void writeThisTextToFileAtThisPathname(String textToWrite, String pathName, String fileName, String format) throws IOException{
        FileWriter fileWriter = new FileWriter(pathName + fileName + format);
        fileWriter.write(textToWrite);
        fileWriter.close();
    }
    

}
