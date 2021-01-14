/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO.FrontEndMaker;

import IUNGO.FrontEndMaker.FrontEndMakerEnums.FrontEndObjectTypes;
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
            FrontEndObject currentCSSObject = this.listOfCurrentCSSFrontEndObjects.get(listOfCurrentCSSFrontEndObjects.size() - 1);
            //Sets the last added object to current
            if (!currentCSSObject.isCssPrinted) {

                returnString += this.getCssAttributes(currentCSSObject); //Prints css syntax and info
                returnString += "}" + this.getNewRow();
                currentCSSObject.setIsCssPrinted(true); //set to printed
            }

            if (currentCSSObject.isListOfFEOsInitiated() && this.isThereAnUnprintedCssChild(currentCSSObject.getListOfFeos())) {
                this.listOfCurrentCSSFrontEndObjects.add(this.getFirstUnprintedCssChild(currentCSSObject));
            } //if current object has children and they are unprinted, add it to current objects, will be current next iteration
            else {

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
            FrontEndObject currentHTMLObject = listOfCurrentHTMLFrontEndObjects.get(listOfCurrentHTMLFrontEndObjects.size() - 1); //Sets to last added unprinted child, first run is the full scene that you want printed.

            if (!currentHTMLObject.isOpeningHtmlPrinted) {
                returnString += this.getIndentation(listOfCurrentHTMLFrontEndObjects.size() - 1) + this.getTagStartString(currentHTMLObject.getObjectType()) + this.getEmptySpace() + this.getClassDefinitionSyntaxForThisFEO(currentHTMLObject);
                returnString += this.getObjectOpeningBracketInfo(currentHTMLObject);
                returnString += this.getCloseTagString() + this.getNewRow();
                currentHTMLObject.setIsOpeningHtmlPrinted(true);
            }
            /* Prints opening. ex , printed parent-> "<div>            with the indentation based on the depth inside another object it is.
                                                                                                                     <div>" <- printed child */

            if (currentHTMLObject.isListOfFEOsInitiated() && this.isThereAnUnprintedHtmlChild(currentHTMLObject.getListOfFeos())) { //If there is an unprinted child, add first one to currentfeos. Will be made current object on next iteration.
                this.addToListOfCurrentFEOs(this.getFirstUnprintedHtmlChild(currentHTMLObject));                                   //making sure the full depth of all children have been printed before we start closing tags.
            } else { //If there is no unprinted child (either through beeing the deepest child object, or having all children printed). Start closing tags
                returnString += this.getIndentation(listOfCurrentHTMLFrontEndObjects.size() - 1) + this.getTagEndString(currentHTMLObject.getObjectType()) + this.getNewRow(); //print closing with right indentation ex: "</div>
                currentHTMLObject.setIsHtmlPrinted(true); //                                                                                                                           </div>               
                listOfCurrentHTMLFrontEndObjects.remove(currentHTMLObject); //Removes the printedobject and goes back up to its parent to check for other nex unprinted child, if parent has no unprinted child it will be closed, and so on.
            }
        }
        return returnString;
    }

    //
    private String getStyleDecleration(FrontEndObject toFormat) {
        String returnString = "";

        returnString += this.getTagStartString(toFormat.getObjectType());

        return returnString;
    }

    private String getObjectOpeningBracketInfo(FrontEndObject currentHTMLObject) {
        String returnString = "";
        if(currentHTMLObject.getObjectType().equals(FrontEndObjectTypes.BUTTON) ){
            returnString += " " + "href=\"" + currentHTMLObject.getLinksTo() + "\"";
        }
        return returnString;
    }

    private String getTagStartString(FrontEndObjectTypes forThisTag) {
        switch (forThisTag) {
            case CONTAINER:
                return "<div";
            case BOXEDIMAGE:
                return "<div";
            case TEXT:
                return "<p";
            case VIDEO:
                return "";
            case BUTTON:
                return "<a";//TODO   
        }
        return null;
    }

    private String getTagEndString(FrontEndObjectTypes forThisTag) {
        switch (forThisTag) {
            case CONTAINER:
                return "</div>";
            case BOXEDIMAGE:
                return "</div>";
            case TEXT:
                return "</p>";
            case VIDEO:
                return "";
            case BUTTON:
                return "</a>";//TODO   
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

    private String getCssAttributes(FrontEndObject currentObject) {
        String returnString = "";
        returnString += "." + currentObject.getId() + "{" + this.getNewRow(); //todo should only print if it has any properties.
        if (currentObject.getBackgroundColor() != null) {
            returnString += this.getIndentation(1) + "background-color: " + currentObject.getBackgroundColor() + ";" + this.getNewRow();
        }
        if (currentObject.getWidthUnit() != null) {
            returnString += this.getIndentation(1) + "width: " + currentObject.getWidth() + currentObject.getWidthUnit() + ";" + this.getNewRow();
        }
        if (currentObject.getHeightUnit() != null) {
            returnString += this.getIndentation(1) + "height: " + currentObject.getHeight() + currentObject.getHeightUnit() + ";" + this.getNewRow();
        }
        if (currentObject.getDisplayType() != null) {
            returnString += this.getIndentation(1) + "display: " + currentObject.getDisplayType().toString().toLowerCase() + ";" + this.getNewRow();
        }
        if (currentObject.getGridTemplateArea() != null) {
            returnString += this.getIndentation(1) + "grid-template-areas: " + this.getNewRow();
            for (ArrayList<String> checker : currentObject.getGridTemplateArea()) {
                returnString += "\""; //adds a "
                String newRowString = "";
                for (int i = 0; i < checker.size(); i++) {
                    newRowString += checker.get(i);
                    if (i != checker.size() - 1) {
                        newRowString += " ";
                    }
                }

                /*for (String insideChecker : checker) {
                    newRowString += insideChecker + " ";
                }*/
                returnString += newRowString + "\"" + this.getNewRow();
            }
            returnString += ";" + this.getNewRow();
        }
        if (currentObject.getGridArea() != null) {
            returnString += this.getIndentation(1) + "grid-area: " + currentObject.getGridArea() + ";" + this.getNewRow();
        }
        if(currentObject.getObjectType().equals(FrontEndObjectTypes.BOXEDIMAGE)){
            returnString += "background-image: url(" + currentObject.getLinksTo() + ");" + this.getNewRow();
            returnString += "background-size: " + currentObject.getBoxedImageSize() + currentObject.getBoxedImageSizeUnitType() + ";\n" +
                            "  background-repeat: no-repeat;\n" +
                            "  background-position-x: "+ currentObject.getBoxedImageCoordinates()[0] + currentObject.getBoxedImageCoordinatesUnitType() +";\n" +
                            "  background-position-y:"+ currentObject.getBoxedImageCoordinates()[1] + currentObject.getBoxedImageCoordinatesUnitType()  + ";"+this.getNewRow();
        }

        return returnString;
    }

}
