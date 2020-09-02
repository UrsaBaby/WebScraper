/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.structures.functions.coreFunctions;

import java.awt.AWTException;
import webscraper.interfaces.FilePortInterface;
import webscraper.interfaces.FunctionInterfaces.FileFunctionInterface;


import webscraper.interfaces.NavigationPortInterface;

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

    
