/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO.FrontEndMaker;

import IUNGO.FrontEndMaker.FrontEndMakerEnums.FrontEndLengthUnits;
import IUNGO.FrontEndMaker.FrontEndMakerEnums.FrontEndObjectDisplayTypes;
import IUNGO.FrontEndMaker.FrontEndMakerEnums.FrontEndObjectTypes;
import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public class FrontEndObjectStyleInterface {
int[] positionCoordinates;
    public FrontEndObjectStyleInterface() {

    }

    public FrontEndObjectStyle getButton(String id, String gridArea) {
        FrontEndObjectStyle returnStyle = new FrontEndObjectStyle();
        returnStyle.setColor("red");
        returnStyle.setText("button");
        returnStyle.setFrontEndObjectType(FrontEndObjectTypes.BUTTON);
        returnStyle.setGridArea(gridArea);
        returnStyle.setId(id);
        return returnStyle;
    }

    public FrontEndObjectStyle getBoxedImage() {
        FrontEndObjectStyle returnStyle = new FrontEndObjectStyle();
        positionCoordinates = new int[2];
        positionCoordinates[0] = 50;
        positionCoordinates[2] = 50;
        returnStyle.setPositionCoordinates(positionCoordinates);
        returnStyle.setPositionCoordinatesUnits(FrontEndLengthUnits.PER);
        returnStyle.setRepeat(false);
        returnStyle.setHeight(100);
        returnStyle.setHeightUnit(FrontEndLengthUnits.PER);
        returnStyle.setWidth(100);
        returnStyle.setWidthUnit(FrontEndLengthUnits.PER);
        returnStyle.setColor("grey");

        return returnStyle;
    }

    public FrontEndObjectStyle getEmptyObject() {
        FrontEndObjectStyle returnStyle = new FrontEndObjectStyle();
        returnStyle.setColor("grey");
        return returnStyle;
    }
    
    public FrontEndObjectStyle getScene(int[] resolution, FrontEndLengthUnits widthUnit, FrontEndLengthUnits heightUnit, ArrayList<ArrayList<String>> gridAreaLayout){
        FrontEndObjectStyle returnStyle = new FrontEndObjectStyle();
        returnStyle.setWidth(resolution[0]);
        returnStyle.setWidthUnit(widthUnit);
        returnStyle.setHeight(resolution[1]);
        returnStyle.setHeightUnit(heightUnit);
        returnStyle.setLayout(gridAreaLayout);
        returnStyle.setDisplayType(FrontEndObjectDisplayTypes.GRID);
        return returnStyle;
    }
    
}
