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

    public FrontEndObjectStyle getButton() {
        FrontEndObjectStyle returnStyle = new FrontEndObjectStyle();
        this.setToButton(returnStyle); 
        return returnStyle;
    }
    
    public void setToButton(FrontEndObjectStyle forThis){
       forThis.setColor("red");
       forThis.setText("button");
       forThis.setFrontEndObjectType(FrontEndObjectTypes.BUTTON);     
    }

    public FrontEndObjectStyle getBoxedImage() {
        FrontEndObjectStyle returnStyle = new FrontEndObjectStyle();
        this.setToBoxedImage(returnStyle);   
        return returnStyle;
    }
    
    public void setToBoxedImage(FrontEndObjectStyle forThis){
         positionCoordinates = new int[2];
        positionCoordinates[0] = 50;
        positionCoordinates[1] = 50;
        forThis.setPositionCoordinates(positionCoordinates);
        forThis.setPositionCoordinatesUnits(FrontEndLengthUnits.PER);
        forThis.setRepeat(false);
        forThis.setHeight(100);
        forThis.setHeightUnit(FrontEndLengthUnits.PER);
        forThis.setWidth(100);
        forThis.setWidthUnit(FrontEndLengthUnits.PER);
        forThis.setColor("grey");
        forThis.setFrontEndObjectType(FrontEndObjectTypes.BOXEDIMAGE);
    }

    public FrontEndObjectStyle getEmptyObject() {
        FrontEndObjectStyle returnStyle = new FrontEndObjectStyle();
        return returnStyle;
    }
    
    public FrontEndObjectStyle getScene(int[] resolution, FrontEndLengthUnits widthUnit, FrontEndLengthUnits heightUnit, ArrayList<ArrayList<String>> gridTemplateArea){
        FrontEndObjectStyle returnStyle = new FrontEndObjectStyle();
        this.setToScene(returnStyle, resolution, widthUnit, heightUnit, gridTemplateArea);
        return returnStyle;
    }
    
    public void setToScene(FrontEndObjectStyle forThis, int[] resolution, FrontEndLengthUnits widthUnit, FrontEndLengthUnits heightUnit, ArrayList<ArrayList<String>> gridTemplateArea){
               forThis.setWidth(resolution[0]);
        forThis.setWidthUnit(widthUnit);
        forThis.setHeight(resolution[1]);
        forThis.setHeightUnit(heightUnit);
        forThis.setGridTemplateArea(gridTemplateArea);
        forThis.setDisplayType(FrontEndObjectDisplayTypes.GRID);
        forThis.setFrontEndObjectType(FrontEndObjectTypes.SCENE);
    }


    
}
