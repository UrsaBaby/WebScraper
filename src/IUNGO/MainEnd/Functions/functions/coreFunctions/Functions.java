/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO.MainEnd.Functions.functions.coreFunctions;

import java.awt.AWTException;


import IUNGO.MainEnd.ports.FilePort.FilePort;
import IUNGO.MainEnd.ports.Webport.WebPort;

/**
 *
 * @author Peter
 */
public class Functions {

   WebPort webPort;
   FilePort filePort;
   

    public Functions() throws AWTException {
    
        
    }
    

    
    protected FilePort getFilePort(){
        return this.filePort;
    }

 }

    
