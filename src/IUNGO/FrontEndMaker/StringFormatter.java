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
        ArrayList<FrontEndObject> listOfCurrentObjects = new ArrayList<>();
        if (!listOfCurrentObjects.contains(toHTML)) {
            listOfCurrentObjects.add(toHTML);
        }

        while (this.isThereAnUnprintedChild(listOfCurrentObjects)) {
            FrontEndObject currentObject = listOfCurrentObjects.get(listOfCurrentObjects.size() - 1);
            // System.out.println(currentObject.getId());
            if (!currentObject.isOpeningPrinted) { // works
                returnString += this.getIndentation(listOfCurrentObjects.size()-1) +this.getTagStartString(currentObject.getTag()) + this.getEmptySpace();
                returnString += this.getClassDefinitionSyntaxForThisFEO(currentObject);
                returnString += this.getCloseTagString() + this.getRewRow();
                currentObject.setIsOpeningPrinted(true);
            }

            
           
            if (currentObject.isListOfFEOsInitiated() && this.isThereAnUnprintedChild(currentObject.getListOfFeos())) {
                listOfCurrentObjects.add(this.getFirstUnprintedChild(currentObject));
            } else {
                returnString +=this.getIndentation(listOfCurrentObjects.size()-1) + this.getTagEndString(currentObject.getTag()) + this.getRewRow();
                currentObject.setIsPrinted(true);
                this.removePrintedObjects(listOfCurrentObjects);

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
    
    private String getIndentation(int numberOfIndentations){
        String returnString = "";
        String indentation = "  ";
        for(int i = 0; i<numberOfIndentations; i++){
            returnString += indentation;
        }
        return returnString;
    }
}
