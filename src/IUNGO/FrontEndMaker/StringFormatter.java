/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO.FrontEndMaker;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Peter
 */
public class StringFormatter {

    public StringFormatter() {

    }

    public String formatFrontEndSceneToStringHTMLCSS(FrontEndObject sceneToFormat) { //TODO test this
        String returnString = null;
        ArrayList<FrontEndObject> currentObjects = new ArrayList<>();

        while (this.isThereAnUnprintedChild(currentObjects)) {
            FrontEndObject currentObject = currentObjects.get(currentObjects.size() - 1);
            if (!currentObject.isOpeningPrinted) {
                returnString += this.getTagStartString(currentObject.getTag()) + this.getEmptySpace();
                returnString += this.getClassDefinitionSyntaxForThisFEO(currentObject);
                returnString += this.getCloseTagString();
                currentObject.setIsOpeningPrinted(true);
            }
            if (currentObject.isListOfFEOsInitiated() && this.isThereAnUnprintedChild(currentObject.getListOfFeos())) {

                currentObject.addFrontEndObject(this.getFirstUnprintedChild(currentObject));
            } else {
                this.getTagEndString(currentObject.getTag());
                currentObject.setIsPrinted(true);

            }
            this.removePrintedObjects(currentObjects);

        }

        //get mainscene object
        //print opening mainscene
        //
        //loop through keyset
        //get first object that has mainscene as parent
        //print opening
        //check if it is parent to anyone
        //get first one that has it as parent
        //print opening
        //and so on
        //get second that has mainscene as parent
        //print opening
        //check if it is parent to anyone
        //if yes, print opening
        //and so on
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

    private boolean isThereAnUnprintedChild(ArrayList<FrontEndObject> fromThis) {
        for (FrontEndObject checker : fromThis) {
            if (!checker.isPrinted) {
                return true;
            }
        }
        return false;
    }

    private void removePrintedObjects(ArrayList<FrontEndObject> fromThis) {
        for (FrontEndObject checker : fromThis) {
            if (checker.isPrinted) {
                fromThis.remove(checker);
            }
        }
    }

}
