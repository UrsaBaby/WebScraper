/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.interfaces;

import java.awt.AWTException;
import java.util.HashMap;
import webscraper.navigation.Navigator;


/**
 *
 * @author Peter
 */
public class LogicInterface {
    private Navigator navigator;
    
    public LogicInterface() throws AWTException{
        navigator = new Navigator();
       
    }
}
