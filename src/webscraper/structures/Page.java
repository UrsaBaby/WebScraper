/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.structures;

import webscraper.structures.functions.Function;
import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public class Page {

    String siteName; //IE News, Economy, Social
    ArrayList<Function> listOfAvailableFunctions;
    ArrayList<Function> listOfUsedFunctions;

    public Page(String name) {
        siteName = name;

    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteName() {
        return this.siteName;
    }

    public void addFunction(Function addThisFunction) {
        listOfAvailableFunctions.add(addThisFunction);
    }

    public boolean containsFunctionWithThisName(String name) {
        for (Function checker : listOfAvailableFunctions) {
            if (checker.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Function getFunctionWithThisName(String name) {
        for (Function checker : listOfAvailableFunctions) {
            if (checker.getName().equals(name)) {
                return checker;
            }
        }
        return null;
    }

}
