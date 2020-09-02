/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.MainEnd.Functions.functions.coreFunctions;

import java.awt.AWTException;
import webscraper.MainEnd.ports.FilePort.Interface.FilePortInterface;
import webscraper.MainEnd.interfaces.FunctionInterfaces.FileFunctionInterface;
import webscraper.MainEnd.ports.NavigationPort.Interface.NavigationPortInterface;

/**
 *
 * @author Peter
 */
public class Functions {

  
    NavigationPortInterface navInterface;
    FilePortInterface fileHandlerInterface;

    public Functions() throws AWTException {
    
        
    }
    
  

    public void closeFunction() {
        navInterface.closeNavInterface();
    }
    
    protected NavigationPortInterface getNavInterface(){
        return this.navInterface;
    }
    
    protected FilePortInterface getFileHandlerInterface(){
        return this.fileHandlerInterface;
    }

 }

    
