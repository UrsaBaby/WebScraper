/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO.FrontEndMaker;

import IUNGO.FrontEndMaker.FrontEndMakerEnums.BackgroundImageRepeatEnum;
import IUNGO.FrontEndMaker.FrontEndMakerEnums.FrontEndLengthUnits;
import IUNGO.FrontEndMaker.FrontEndMakerEnums.FrontEndObjectDisplayTypes;
import IUNGO.FrontEndMaker.FrontEndMakerEnums.FrontEndObjectTypes;
import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public class FrontEndObjectStyle {

    int width;
    FrontEndLengthUnits widthUnit;
    int height;
    FrontEndLengthUnits heightUnit;
    int[] positionCoordinates;
    FrontEndLengthUnits positionCoordinatesUnits;
    boolean repeat;
    String color;
    int opacity;
    ArrayList<ArrayList<String>> gridTemplateArea;
    String linksTo;
    String frontEndObjectStyleId;
    FrontEndObjectDisplayTypes displayType;
    String gridArea;
    FrontEndObjectTypes frontEndObjectType;
    BackgroundImageRepeatEnum repeatRule;
    String text;
    
    public String getText(String text){
        return text;
    }

    public BackgroundImageRepeatEnum getRepeatRule() {
        return repeatRule;
    }

    public FrontEndObjectTypes getFrontEndObjectType() {
        return frontEndObjectType;
    }


    public String getGridArea() {
        return gridArea;
    }

    public ArrayList<ArrayList<String>> getGridTemplateArea() {
        return gridTemplateArea;
    }

    public FrontEndObjectDisplayTypes getDisplayType() {
        return displayType;
    }

    public String getFrontEndObjectId() {
        return frontEndObjectStyleId;
    }

    public String getLinksTo() {
        return linksTo;
    }

    public ArrayList<ArrayList<String>> getLayout() {
        return gridTemplateArea;
    }

    public int getOpacity() {
        return opacity;
    }

    public String getColor() {
        return color;
    }

    public boolean getRepeat() {
        return repeat;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public FrontEndLengthUnits getHeightUnit() {
        return heightUnit;
    }

    public FrontEndLengthUnits getWidthUnit() {
        return widthUnit;
    }

    public int[] getPositionCoordinates() {
        return positionCoordinates;
    }

    public FrontEndLengthUnits getPositionCoordinatesUnits() {
        return positionCoordinatesUnits;
    }

    /////////
    
    public void setRepeatRule(BackgroundImageRepeatEnum repeatRule) {
        this.repeatRule = repeatRule;
    }

    public void setFrontEndObjectType(FrontEndObjectTypes frontEndObjectType) {
        this.frontEndObjectType = frontEndObjectType;
    }
    
    public void setGridArea(String gridArea) {
        this.gridArea = gridArea;
    }
      
    public void setGridTemplateArea(ArrayList<ArrayList<String>> gridTemplateArea) {
        this.gridTemplateArea = gridTemplateArea;
    }

    public void setDisplayType(FrontEndObjectDisplayTypes displayType) {
        this.displayType = displayType;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setWidthUnit(FrontEndLengthUnits widthUnit) {
        this.widthUnit = widthUnit;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setHeightUnit(FrontEndLengthUnits heightUnit) {
        this.heightUnit = heightUnit;
    }

    public void setPositionCoordinates(int[] positionCoordinates) {
        this.positionCoordinates = positionCoordinates;
    }

    public void setPositionCoordinatesUnits(FrontEndLengthUnits positionCoordinatesUnits) {
        this.positionCoordinatesUnits = positionCoordinatesUnits;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOpacity(int opacity) {
        this.opacity = opacity;
    }


    public void setLinksTo(String linksTo) {
        this.linksTo = linksTo;
    }

    public void setId(String frontEndObjectStyleId) {
        this.frontEndObjectStyleId = frontEndObjectStyleId;
    }

    public void setText(String text) {
        this.text = text;
    }

}
