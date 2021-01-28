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
public class FrontEndObjectStyleInterface {
int[] positionCoordinates;
    public FrontEndObjectStyleInterface() {

    }

    public FrontEndObjectStyle getButton(String id) {
        FrontEndObjectStyle returnStyle = new FrontEndObjectStyle();
        returnStyle.setId(id);
        return returnStyle;
    }

    public FrontEndObjectStyle getBoxedImage(String id) {
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
        returnStyle.setId(id);

        return returnStyle;
    }

    public FrontEndObjectStyle getEmptyObject(String id) {
        FrontEndObjectStyle returnStyle = new FrontEndObjectStyle();
        returnStyle.setColor("grey");
        returnStyle.setId(id);
        return returnStyle;
    }
    
    public FrontEndObjectStyle getScene(String id, int[] resolution, FrontEndLengthUnits widthUnit, FrontEndLengthUnits heightUnit, ArrayList<ArrayList<String>> layout){
        FrontEndObjectStyle returnStyle = new FrontEndObjectStyle();
        returnStyle.setWidth(resolution[0]);
        returnStyle.setWidthUnit(widthUnit);
        returnStyle.setHeight(resolution[1]);
        returnStyle.setHeightUnit(heightUnit);
        returnStyle.setLayout(layout);
        returnStyle.setId(id);
        return returnStyle;
    }
    
}
