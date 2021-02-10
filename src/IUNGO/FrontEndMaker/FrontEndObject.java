/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO.FrontEndMaker;

import IUNGO.FrontEndMaker.FrontEndMakerEnums.AlignJustify;
import IUNGO.FrontEndMaker.FrontEndMakerEnums.FrontEndObjectTypes;
import IUNGO.FrontEndMaker.FrontEndMakerEnums.FrontEndObjectDisplayTypes;
import IUNGO.FrontEndMaker.FrontEndMakerEnums.FrontEndLengthUnits;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Peter
 */
public class FrontEndObject {

    ArrayList<FrontEndObject> listOfFrontEndObjects;
    FrontEndObjectTypes frontEndObjectType;
    String id;
    boolean isHtmlPrinted;
    boolean isOpeningHtmlPrinted;
    boolean isCssPrinted;

    String backgroundColor;

    FrontEndLengthUnits heightUnit;
    FrontEndLengthUnits widthUnit;
    int width;
    int height;

    String gridArea;

    FrontEndLengthUnits rowLengthUnit;
    int rowAmount;
    int[] rowSize;

    FrontEndLengthUnits columnLengthUnit;
    HashMap<Integer, FrontEndLengthUnits> columns;
    int columnAmount;
    int[] columnSize;

    FrontEndLengthUnits gridGapRowLengthUnit;
    int gripGapRowDistance;

    FrontEndLengthUnits gridGapColumnsLengthUnit;
    int gridGapColumnsDistance;

    AlignJustify justify;
    AlignJustify align;
    AlignJustify justifySelf;

    ArrayList<ArrayList<String>> gridTemplateArea;

    FrontEndObjectDisplayTypes displayType;

    String linksTo = "";

    String outputTo;

    int boxedImageSize;
    FrontEndLengthUnits boxedImageSizeUnitType;
    int[] boxedImageCoordinates;
    FrontEndLengthUnits boxedImageCoordinatesUnitType;

    FrontEndObjectStyle style;

    public FrontEndObject(FrontEndObjectTypes typeOfObject, String id) {
        this.frontEndObjectType = typeOfObject;
        this.id = id;
        boxedImageCoordinates = new int[2];
        isHtmlPrinted = false;
        isOpeningHtmlPrinted = false;
        this.style = style;
    }

    public void setObjectStyle(FrontEndObjectStyle style) {
        this.style = style;
    }

    public void setRows(FrontEndLengthUnits lengthUnit, int[] rowSize, int numberOfRows) {
        rowLengthUnit = lengthUnit;
        this.rowSize = rowSize;
        rowAmount = numberOfRows;

    }

    public void setColumns(FrontEndLengthUnits lengthUnit, int[] columnMinMaxSize, int numberOfRows) {
        columnLengthUnit = lengthUnit;
        this.columnSize = columnMinMaxSize;
        this.columnAmount = numberOfRows;
    }

    public void setGridGapRows(FrontEndLengthUnits lengthUnit, int gripGapDistance) {
        this.gridGapRowLengthUnit = lengthUnit;
        this.gripGapRowDistance = gripGapDistance;
    }

    public void setGridGapColumns(FrontEndLengthUnits lengthUnit, int gridGapDistance) {
        this.gridGapColumnsLengthUnit = lengthUnit;
        this.gridGapColumnsDistance = gridGapDistance;

    }

    public void setWidthHeight(int width, FrontEndLengthUnits widthUnit, int height, FrontEndLengthUnits heightUnit) {
        this.width = width;
        this.widthUnit = widthUnit;
        this.height = height;
        this.heightUnit = heightUnit;
    }

    public void setID(String id) {
        this.id = id;
    }

    public void setJustify(AlignJustify justifyRule) {
        this.justify = justifyRule;
    }

    public void setAlign(AlignJustify alignRule) {
        this.align = alignRule;
    }

    public void setJustifySelf(AlignJustify justifySelf) {
        this.justifySelf = justifySelf;
    }

    public void setGridTemplateArea(ArrayList<ArrayList<String>> gridTemplateArea) {
        this.gridTemplateArea = gridTemplateArea;
    }

    public void setDisplayType(FrontEndObjectDisplayTypes displayType) {
        this.displayType = displayType;
    }

    public void setIsHtmlPrinted(boolean toThis) {
        this.isHtmlPrinted = toThis;
    }

    public void setIsOpeningHtmlPrinted(boolean toThis) {
        this.isOpeningHtmlPrinted = toThis;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setIsCssPrinted(boolean toThis) {
        this.isCssPrinted = toThis;
    }

    public void setGridArea(String gridArea) {
        this.gridArea = gridArea;
    }

    public void setLinksTo(String linkToThis) {
        this.linksTo = linkToThis;
    }

    public void setOutputTo(String directoryAndFilename) {
        this.outputTo = directoryAndFilename;
    }

    public void setObjectType(FrontEndObjectTypes thisType) {
        this.frontEndObjectType = thisType;
    }

    public void setImageCropType() {

    }

    public void setBoxedImageSize(int imageSize, FrontEndLengthUnits thisUnit) {
        this.boxedImageSize = imageSize;
        this.boxedImageSizeUnitType = thisUnit;
    }

    public void setBoxedImageCoordinates(int[] theseCoordinates, FrontEndLengthUnits theseUnits) {
        this.boxedImageCoordinates = theseCoordinates;
        this.boxedImageCoordinatesUnitType = theseUnits;
    }

    //
    public FrontEndObjectStyle getFrontEndObjectStyle() {
        return style;
    }

    public String getId() {
        return this.id;
    }

    public AlignJustify getAlign() {
        return this.align;
    }

    public AlignJustify getJustify() {
        return this.justify;
    }

    private ArrayList<FrontEndObject> getListOfFrontEndObjects() {
        return this.listOfFrontEndObjects;
    }

    public FrontEndObjectTypes getFrontEndObjectType() {
        return this.frontEndObjectType;
    }

    public AlignJustify getJustifySelf() {
        return justifySelf;
    }

    public int getColumnsAmount() {
        return this.columnAmount;
    }

    public int[] getColumnsSize() {
        return this.columnSize;
    }

    public FrontEndLengthUnits getColumnLengthUnit() {
        return this.columnLengthUnit;
    }

    public int getRowsAmount() {
        return this.rowAmount;
    }

    public int[] getRowsSize() {
        return this.rowSize;
    }

    public FrontEndLengthUnits getRowLengthUnit() {
        return this.rowLengthUnit;
    }

    public ArrayList<ArrayList<String>> getGridTemplateArea() {
        return gridTemplateArea;
    }

    public FrontEndObjectDisplayTypes getDisplayType() {
        return displayType;
    }

    public ArrayList<FrontEndObject> getListOfFeos() {
        return this.listOfFrontEndObjects;
    }

    public String getBackgroundColor() {
        return this.backgroundColor;
    }

    public int getWidth() {
        return this.width;
    }

    public FrontEndLengthUnits getWidthUnit() {
        return this.widthUnit;
    }

    public int getHeight() {
        return this.height;
    }

    public FrontEndLengthUnits getHeightUnit() {
        return this.heightUnit;
    }

    public String getGridArea() {
        return this.gridArea;
    }

    public String getLinksTo() {
        return this.linksTo;
    }

    public String getOutputTo() {
        return this.outputTo;
    }

    public String getLinkAdress() {
        return this.getLinkAdress() + ".html#" + this.getId();
    }

    public int getBoxedImageSize() {
        return boxedImageSize;
    }

    public int[] getBoxedImageCoordinates() {
        return boxedImageCoordinates;
    }

    public FrontEndLengthUnits getBoxedImageSizeUnitType() {
        return boxedImageSizeUnitType;
    }

    public FrontEndLengthUnits getBoxedImageCoordinatesUnitType() {
        return boxedImageCoordinatesUnitType;
    }

    //
    public void addFrontEndObject(FrontEndObject addThis) {
        if (!this.isListOfFEOsInitiated()) {
            this.initiateListOfFrontEndObjects();
        }
        this.getListOfFrontEndObjects().add(addThis);
    }

    //
    public boolean isRowsInitated() { // not redundant! Works as expected
        if (this.rowLengthUnit == null) {
            return false;
        }
        return true;
    }

    public boolean isColumnsInitiated() {
        if (this.columnLengthUnit == null) {
            return false;
        }
        return true;
    }

    public boolean isGripGapRowsInitiated() {
        if (this.gridGapRowLengthUnit == null) {
            return false;
        }
        return true;
    }

    public boolean isGripGapColumnsInitiated() {
        if (this.gridGapColumnsLengthUnit == null) {
            return false;
        }
        return true;
    }

    public boolean isListOfFEOsInitiated() {
        if (this.listOfFrontEndObjects == null) {
            return false;
        }
        return true;
    }

    public boolean isCssPrinted() {
        return this.isCssPrinted;
    }

    //
    private void initiateListOfFrontEndObjects() {
        this.listOfFrontEndObjects = new ArrayList<>();
    }

}
