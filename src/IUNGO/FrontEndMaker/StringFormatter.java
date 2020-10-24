/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO.FrontEndMaker;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author Peter
 */
public class StringFormatter {

    ArrayList<FrontEndObject> listOfCurrentFrontEndObjects;

    public StringFormatter() {

    }

    public String formatFrontEndSceneToStringHTMLCSS(FrontEndObject sceneToFormat) { //TODO test this
        String returnString = "";
        returnString += this.getCSS(sceneToFormat) + this.getRewRow();
        returnString += this.getHTML(sceneToFormat) + this.getRewRow();
        return returnString;
    }

    private String getCSS(FrontEndObject toCSS) {
        String returnString = "";
        returnString += "<style>" + this.getRewRow();
        returnString += "</style>";
        return returnString;
    }

    private String getHTML(FrontEndObject toHTML) {
        String returnString = "";
        this.addToListOfCurrentFEOs(toHTML);

        while (this.isThereAnUnprintedChild(listOfCurrentFrontEndObjects)) {
            FrontEndObject currentObject = listOfCurrentFrontEndObjects.get(listOfCurrentFrontEndObjects.size() - 1);
 
            if (!currentObject.isOpeningPrinted) { // works
                returnString += this.printHTMLOpening(currentObject);
                currentObject.setIsOpeningPrinted(true);
            }

            if (currentObject.isListOfFEOsInitiated() && this.isThereAnUnprintedChild(currentObject.getListOfFeos())) {
                this.addToListOfCurrentFEOs(this.getFirstUnprintedChild(currentObject));
            } else {
                returnString += this.getIndentation(listOfCurrentFrontEndObjects.size() - 1) + this.getTagEndString(currentObject.getTag()) + this.getRewRow();
                currentObject.setIsPrinted(true);
                this.removePrintedObjects(listOfCurrentFrontEndObjects);

            }

        }

        return returnString;
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

    private String getRewRow() {
        return "\n";
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

    private String getIndentation(int numberOfIndentations) {
        String returnString = "";
        String indentation = "  ";
        for (int i = 0; i < numberOfIndentations; i++) {
            returnString += indentation;
        }
        return returnString;
    }

    private void initiateListOfCurrentFEOs() {
        this.listOfCurrentFrontEndObjects = new ArrayList<>();
    }

    private boolean isListOfCurrentFEOsInitiated() {
        if (this.listOfCurrentFrontEndObjects == null) {
            return false;
        }
        return true;
    }

    private void addToListOfCurrentFEOs(FrontEndObject addThis) {
        if (!this.isListOfCurrentFEOsInitiated()) {
            this.initiateListOfCurrentFEOs();
        }
        this.listOfCurrentFrontEndObjects.add(addThis);
    }

    private String printHTMLOpening(FrontEndObject printThis) {
        String returnString = "";
        returnString += this.getIndentation(listOfCurrentFrontEndObjects.size() - 1) + this.getTagStartString(printThis.getTag()) + this.getEmptySpace();
        returnString += this.getClassDefinitionSyntaxForThisFEO(printThis);
        returnString += this.getCloseTagString() + this.getRewRow();
        
        return  returnString;
    }
}
