/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import java.beans.EventHandler;


/**
 *
 * @author Peter
 */
public class Event extends EventHandler{
    String name;
    public Event(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
}
