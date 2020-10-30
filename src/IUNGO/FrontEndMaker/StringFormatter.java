/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO.FrontEndMaker;

import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public class StringFormatter {

    ArrayList<FrontEndObject> listOfCurrentFrontEndObjects;

    public StringFormatter() {

    }


    public String getCSS(FrontEndObject toCSS) {
        String returnString = "";
        returnString += "<style>" + this.getNewRow();
        returnString += "</style>";
        return returnString;
    }
 

    public String getHTML(FrontEndObject getThisHTML) {
        String returnString = "";
        
        if(this.listOfCurrentFrontEndObjects == null){
            this.listOfCurrentFrontEndObjects = new ArrayList<>(); //initiates the list.
        }
        this.listOfCurrentFrontEndObjects.add(getThisHTML);

        while (this.isThereAnUnprintedChild(listOfCurrentFrontEndObjects)) {
            FrontEndObject currentObject = this.getCurrentObjectLastInThisList(listOfCurrentFrontEndObjects); //Sets to last added unprinted child, first run is the full scene that you want printed.

            if (!currentObject.isOpeningPrinted) {
                returnString += this.getIndentation(listOfCurrentFrontEndObjects.size() - 1) + this.getTagStartString(currentObject.getTag()) + this.getEmptySpace() + this.getClassDefinitionSyntaxForThisFEO(currentObject) + this.getCloseTagString() + this.getNewRow();
            }                                                         /* Prints opening. ex , printed parent-> "<div>            with the indentation based on the depth inside another object it is.
                                                                                                                     <div>" <- printed child */   

            if (currentObject.isListOfFEOsInitiated() && this.isThereAnUnprintedChild(currentObject.getListOfFeos())) { //If there is an unprinted child, add first one to currentfeos. Will be made current object on next iteration.
                this.addToListOfCurrentFEOs(this.getFirstUnprintedChild(currentObject));                                   //making sure the full depth of all children have been printed before we start closing tags.
            } else { //If there is no unprinted child (either through beeing the deepest child object, or having all children printed). Start closing tags
                returnString += this.getIndentation(listOfCurrentFrontEndObjects.size() - 1) + this.getTagEndString(currentObject.getTag()) + this.getNewRow(); //print closing with right indentation ex: "</div>
                currentObject.setIsPrinted(true); //TODO refactor, prints closing.                                                                                                                              </div>               
                listOfCurrentFrontEndObjects.remove(currentObject);
            }
        }
        return returnString;
    }    

    
    //
    private FrontEndObject getCurrentObjectLastInThisList(ArrayList<FrontEndObject> thisList) {
        return listOfCurrentFrontEndObjects.get(listOfCurrentFrontEndObjects.size() - 1);
    }

    private String getStyleDecleration(FrontEndObject toFormat) {
        String returnString = "";

        returnString += this.getTagStartString(toFormat.getTag());

        return returnString;
    }

    private String getTagStartString(FrontEndTags forThisTag) {
        switch (forThisTag) {
            case CONTAINER:
                return "<div";
            case IMAGE:
                return "<img";
            case TEXT:
                return "<p";
            case VIDEO:
                return ""; //TODO   
        }
        return null;
    }

    private String getTagEndString(FrontEndTags forThisTag) {
        switch (forThisTag) {
            case CONTAINER:
                return "</div>";
            case IMAGE:
                return "</img>";
            case TEXT:
                return "</p>";
            case VIDEO:
                return ""; //TODO   
        }
        return null;
    }

    private String getCloseTagString() {
        return ">";
    }

    private String getEmptySpace() {
        return " ";
    }

    private String getNewRow() {
        return "\n";
    }

    private String getIndentation(int numberOfIndentations) {
        String returnString = "";
        String indentation = "  ";
        for (int i = 0; i < numberOfIndentations; i++) {
            returnString += indentation;
        }
        return returnString;
    }

    private String getClassDefinitionSyntaxForThisFEO(FrontEndObject defineThis) {
        return "class=\"" + defineThis.getId() + "\"";
    }

    private FrontEndObject getFirstUnprintedChild(FrontEndObject fromThis) {
        for (FrontEndObject checker : fromThis.getListOfFeos()) {
            if (!checker.isPrinted) {
                return checker;
            }
        }
        return null;
    }

    //
    
    private boolean isThereAnUnprintedChild(ArrayList<FrontEndObject> fromThis) { //TODO refactor
        if (fromThis == null) {
            return false;
        }
        for (FrontEndObject checker : fromThis) {
            if (!checker.isPrinted) {
                return true;
            }
        }
        return false;
    }

    private boolean isListOfCurrentFEOsInitiated() {
        if (this.listOfCurrentFrontEndObjects == null) {
            return false;
        }
        return true;
    }

    //
    private void removePrintedObjects(ArrayList<FrontEndObject> fromThis) {

        /*  for (Iterator iterator = fromThis.iterator(); iterator.hasNext();){
            if()
        }*/
        ArrayList<FrontEndObject> toRemove = new ArrayList<FrontEndObject>();
        for (FrontEndObject checker : fromThis) { //TODO iterator?
            if (checker.isPrinted) {
                toRemove.add(checker);
            }
        }
        fromThis.removeAll(toRemove);
    }


    private void addToListOfCurrentFEOs(FrontEndObject addThis) {
        this.listOfCurrentFrontEndObjects.add(addThis);
    }

   

}
