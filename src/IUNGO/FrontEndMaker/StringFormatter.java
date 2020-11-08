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

    ArrayList<FrontEndObject> listOfCurrentHTMLFrontEndObjects;
    ArrayList<FrontEndObject> listOfCurrentCSSFrontEndObjects;

    public StringFormatter() {

    }

    public String getCSS(FrontEndObject toCSS) {
        String returnString = "";
        this.initiateListOfCurrentCSSFEOs();
        returnString += "<style>" + this.getNewRow();
        listOfCurrentCSSFrontEndObjects.add(toCSS);
        while (!this.listOfCurrentCSSFrontEndObjects.isEmpty()) { //If lsit isnt empty
            FrontEndObject currentCSSObject = this.listOfCurrentCSSFrontEndObjects.get(listOfCurrentCSSFrontEndObjects.size()-1);
            //Sets the last added object to current
            if (!currentCSSObject.isCssPrinted) {
            
                returnString += this.getCssAttributes(currentCSSObject); //Prints css syntax and info
                returnString += "}" + this.getNewRow();
                currentCSSObject.setIsCssPrinted(true); //set to printed
            }

            if (currentCSSObject.isListOfFEOsInitiated() && this.isThereAnUnprintedCssChild(currentCSSObject.getListOfFeos())) {
                this.listOfCurrentCSSFrontEndObjects.add(this.getFirstUnprintedCssChild(currentCSSObject));
            }   //if current object has children and they are unprinted, add it to current objects, will be current next iteration
            else{
               
                listOfCurrentCSSFrontEndObjects.remove(currentCSSObject); //if it doesnt have children that is unprinted
                //                                                          it will have been printed and can therefore be removed;
            }
        }

        returnString += "</style>";
        return returnString;
    }

    public String getHTML(FrontEndObject getThisHTML) {
        String returnString = "";

        this.initiateListOfCurrentHTMLFEOs();
        this.listOfCurrentHTMLFrontEndObjects.add(getThisHTML);

        while (this.isThereAnUnprintedHtmlChild(listOfCurrentHTMLFrontEndObjects)) {
            FrontEndObject currentHTMLObject = listOfCurrentHTMLFrontEndObjects.get(listOfCurrentHTMLFrontEndObjects.size()-1); //Sets to last added unprinted child, first run is the full scene that you want printed.

            if (!currentHTMLObject.isOpeningHtmlPrinted) {
                returnString += this.getIndentation(listOfCurrentHTMLFrontEndObjects.size() - 1) + this.getTagStartString(currentHTMLObject.getTag()) + this.getEmptySpace() + this.getClassDefinitionSyntaxForThisFEO(currentHTMLObject) + this.getCloseTagString() + this.getNewRow();
                currentHTMLObject.setIsOpeningHtmlPrinted(true);
            }
            /* Prints opening. ex , printed parent-> "<div>            with the indentation based on the depth inside another object it is.
                                                                                                                     <div>" <- printed child */

            if (currentHTMLObject.isListOfFEOsInitiated() && this.isThereAnUnprintedHtmlChild(currentHTMLObject.getListOfFeos())) { //If there is an unprinted child, add first one to currentfeos. Will be made current object on next iteration.
                this.addToListOfCurrentFEOs(this.getFirstUnprintedHtmlChild(currentHTMLObject));                                   //making sure the full depth of all children have been printed before we start closing tags.
            } else { //If there is no unprinted child (either through beeing the deepest child object, or having all children printed). Start closing tags
                returnString += this.getIndentation(listOfCurrentHTMLFrontEndObjects.size() - 1) + this.getTagEndString(currentHTMLObject.getTag()) + this.getNewRow(); //print closing with right indentation ex: "</div>
                currentHTMLObject.setIsHtmlPrinted(true); //                                                                                                                           </div>               
                listOfCurrentHTMLFrontEndObjects.remove(currentHTMLObject); //Removes the printedobject and goes back up to its parent to check for other nex unprinted child, if parent has no unprinted child it will be closed, and so on.
            }
        }
        return returnString;
    }

    //
    private FrontEndObject getCurrentObjectLastInThisList(ArrayList<FrontEndObject> thisList) {
        return listOfCurrentHTMLFrontEndObjects.get(listOfCurrentHTMLFrontEndObjects.size() - 1);
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

    private FrontEndObject getFirstUnprintedHtmlChild(FrontEndObject fromThis) {
        for (FrontEndObject checker : fromThis.getListOfFeos()) {
            if (!checker.isHtmlPrinted) {
                return checker;
            }
        }
        return null;
    }

    private FrontEndObject getFirstUnprintedCssChild(FrontEndObject fromThis) {
        for (FrontEndObject checker : fromThis.getListOfFeos()) {
            if (!checker.isCssPrinted) {
                return checker;
            }
        }
        return null;
    }

    //
    private boolean isThereAnUnprintedHtmlChild(ArrayList<FrontEndObject> fromThis) { //TODO refactor
        if (fromThis == null) {
            return false;
        }
        for (FrontEndObject checker : fromThis) {
            if (!checker.isHtmlPrinted) {
                return true;
            }
        }
        return false;
    }

    private boolean isThereAnUnprintedCssChild(ArrayList<FrontEndObject> listOfFeos) {
        for (FrontEndObject checker : listOfFeos) {
            if (!checker.isCssPrinted) {
                return true;
            }
        }
        return false;
    }

    private boolean isListOfCurrentFEOsInitiated() {
        if (this.listOfCurrentHTMLFrontEndObjects == null) {
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
            if (checker.isHtmlPrinted) {
                toRemove.add(checker);
            }
        }
        fromThis.removeAll(toRemove);
    }

    private void addToListOfCurrentFEOs(FrontEndObject addThis) {
        this.listOfCurrentHTMLFrontEndObjects.add(addThis);
    }

    //
    private void initiateListOfCurrentHTMLFEOs() {
        if (this.listOfCurrentHTMLFrontEndObjects == null) {
            this.listOfCurrentHTMLFrontEndObjects = new ArrayList<>(); //initiates the list.
        }
    }

    private void initiateListOfCurrentCSSFEOs() {
        if (this.listOfCurrentCSSFrontEndObjects == null) {
            this.listOfCurrentCSSFrontEndObjects = new ArrayList<>();
        }
    }
    
    private String getCssAttributes(FrontEndObject fromThis){
        String returnString = "";
        returnString += "." + fromThis.getId() + "{" + this.getNewRow(); //todo should only print if it has any properties.
        if(fromThis.getBackgroundColor() != null){
            returnString += this.getIndentation(1)+"background-color: " + fromThis.getBackgroundColor() + ";" + this.getNewRow();
        }
        return returnString;
    }

}
