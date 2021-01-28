/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO.FrontEndMaker;

import IUNGO.FrontEndMaker.FrontEndMakerEnums.FrontEndLengthUnits;
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
    ArrayList<ArrayList<String>> gridArea;
    String linksTo;
    String id;

    public String getId() {
        return id;
    }

    public String getLinksTo() {
        return linksTo;
    }

    public ArrayList<ArrayList<String>> getLayout() {
        return gridArea;
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
    
    public void setLayout(ArrayList<ArrayList<String>> gridArea) {
        this.gridArea = gridArea;
    }
    
    public void setLinksTo(String linksTo) {
        this.linksTo = linksTo;
    }
    
    public void setId(String id) {
        this.id = id;
    }


}
