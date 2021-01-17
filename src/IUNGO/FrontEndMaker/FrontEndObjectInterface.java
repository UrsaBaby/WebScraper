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

    public FrontEndObject createEmptyObject(String id, FrontEndObjectStyle style) {
        FrontEndObject returnObject = new FrontEndObject(FrontEndObjectTypes.CONTAINER, id, style);
        return returnObject;
    }

    public FrontEndObject createBoxedImage(String id, int imageSize, FrontEndLengthUnits imageSizeUnit, int[] imageCoordinates, FrontEndLengthUnits imageCoordinateUnit, String imagePath, FrontEndObjectStyle style) {
        FrontEndObject returnObject = new FrontEndObject(FrontEndObjectTypes.BOXEDIMAGE, id, style);
        returnObject.setBoxedImageSize(imageSize, imageSizeUnit);
        returnObject.setBoxedImageCoordinates(imageCoordinates, imageCoordinateUnit);
        returnObject.setLinksTo(imagePath);
        return returnObject;
    }
    
    public FrontEndObject createButton(String id, String linksTo, FrontEndObjectStyle style){
        FrontEndObject returnObject = new FrontEndObject(FrontEndObjectTypes.BUTTON, id, style);
        return returnObject;
    }

}
