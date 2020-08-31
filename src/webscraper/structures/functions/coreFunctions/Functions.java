/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.structures.functions.coreFunctions;

import java.awt.AWTException;
import webscraper.interfaces.FileFunctionInterface;


import webscraper.interfaces.NavigationInterface;

/**
 *
 * @author Peter
 */
public class Functions {

    String name;
    NavigationInterface navInterface;
    FileFunctionInterface FileFuncInterface;

    public Functions(String name) throws AWTException {
        this.name = name;
        
    }
    
    public String getName() {
        return this.name;
    }

    public void closeFunction() {
        navInterface.closeNavInterface();
        FileFuncInterface.c
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Function name: " + this.getName();
    }

}
