/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.structures;

import webscraper.structures.functions.coreFunctions.Functions;
import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public class Page {

    String siteName; //IE News, Economy, Social
    ArrayList<Functions> listOfAvailableFunctions;
    ArrayList<Functions> listOfUsedFunctions;

    public Page(String name) {
        siteName = name;
        listOfAvailableFunctions = new ArrayList<Functions>();
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteName() {
        return this.siteName;
    }

    public void addFunction(Functions addThisFunction) {
        this.listOfAvailableFunctions.add(addThisFunction);
    }

    public boolean containsFunctionWithThisName(String name) {
        for (Functions checker : listOfAvailableFunctions) {
            if (checker.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Functions getFunctionWithThisName(String name) {
        for (Functions checker : listOfAvailableFunctions) {
            if (checker.getName().equals(name)) {
                return checker;
            }
        }
        return null;
    }

    public String toString() {
        return "Page name: " + this.getSiteName();
    }


  

}
