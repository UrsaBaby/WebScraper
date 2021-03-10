/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO.FrontEndMaker;


import IUNGO.FrontEndMaker.FrontEndMakerEnums.FrontEndLengthUnits;
import IUNGO.FrontEndMaker.FrontEndMakerEnums.FrontEndObjectTypes;

/**
 *
 * @author Peter
 */
public class FrontEndObjectInterface {

    public FrontEndObject createScene(String id, FrontEndObjectStyle style) {
        FrontEndObject returnObject = new FrontEndObject();
        returnObject.setId(id);
        style.setId(id);
        returnObject.setObjectStyle(style);
        return returnObject;
    }
    
    public void setToScene(FrontEndObject setThisObject, FrontEndObjectStyle toThisStyle){
       toThisStyle.setId(setThisObject.getId());
       setThisObject.setFrontEndObjectStyle(toThisStyle);
    }

    public FrontEndObject createBoxedImage(String id, int imageSize, FrontEndLengthUnits imageSizeUnit, int[] imageCoordinates, FrontEndLengthUnits imageCoordinateUnit, String imagePath, FrontEndObjectStyle style, String gridArea) {
        FrontEndObject returnObject = new FrontEndObject();
        returnObject.setId(id);
        returnObject.setBoxedImageSize(imageSize, imageSizeUnit);
        returnObject.setBoxedImageCoordinates(imageCoordinates, imageCoordinateUnit);
        returnObject.setLinksTo(imagePath);
        style.setId(id);
        style.setGridArea(gridArea);
        returnObject.setObjectStyle(style);
        return returnObject;
    }
    
    public FrontEndObject createButton(String id, String linksTo, FrontEndObjectStyle style, String gridArea){
        FrontEndObject returnObject = new FrontEndObject();
        returnObject.setId(id);
        style.setId(id);
        style.setGridArea(gridArea);
        returnObject.setObjectStyle(style);
        return returnObject;
    }

}
