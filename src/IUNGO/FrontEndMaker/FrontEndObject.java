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
public class FrontEndObject {

    ArrayList<FrontEndObject> listOfFrontEndObjects;
    FrontEndTags typeOfObject;
    String id;
    boolean isPrinted;
    boolean isOpeningPrinted;
    
    String backgroundColor;

    FrontEndLengthUnits rowLengthUnit;
    int rowAmount;
    int[] rowSize;

    FrontEndLengthUnits columnLengthUnit;
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

    public FrontEndObject(FrontEndTags typeOfObject, String id) {
        this.typeOfObject = typeOfObject;
        this.id = id;
        rowSize = new int[2];
        columnSize = new int[2];
        isPrinted = false;
        isOpeningPrinted = false;

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
    
    public void setID(String id){
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
    
    public void setIsPrinted(boolean toThis){
        this.isPrinted = toThis;
    }
    
    public void setIsOpeningPrinted(boolean toThis){
        this.isOpeningPrinted = toThis;
    }
    
    public void setBackgroundColor(String backgroundColor){
        this.backgroundColor = backgroundColor;
    }

    //
    
    public String getId(){
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

    public FrontEndTags getTag() {
        return this.typeOfObject;
    }

    public AlignJustify getJustifySelf() {
        return justifySelf;
    }

    public ArrayList<ArrayList<String>> getGridTemplateArea() {
        return gridTemplateArea;
    }

    public FrontEndObjectDisplayTypes getDisplayType() {
        return displayType;
    }
    
    public ArrayList<FrontEndObject> getListOfFeos(){
        return this.listOfFrontEndObjects;
    }
    
    public String getBackgroundColor(){
        return this.backgroundColor;
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

    //
    private void initiateListOfFrontEndObjects() {
        this.listOfFrontEndObjects = new ArrayList<>();
    }

}
